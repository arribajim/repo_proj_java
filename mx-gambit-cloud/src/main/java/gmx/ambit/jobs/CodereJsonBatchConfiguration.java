package gmx.ambit.jobs;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.json.GsonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gmx.ambit.bean.EventBean;
import gmx.ambit.data.Event;
import gmx.ambit.jobs.bet.BetWrapperList;
import gmx.ambit.jobs.bet.CodereBetItemProcessor;
import gmx.ambit.jobs.writer.InsertBetTraceItemWriter;
import gmx.ambit.jobs.writer.InsertEventItemWriter;
import gmx.ambit.parcer.JsonDateDeserializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
@Slf4j
public class CodereJsonBatchConfiguration {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;
	private final CodereJsonItemProcessor processorStep1;
	private final CodereBetItemProcessor processorStep2;
	
	@Bean
//	@Primary
	public Job parceJsonCodere(CodereJsonJobDoneNotifListener listener, @Qualifier("step1") Step step1,
			@Qualifier("step2") Step step2) {
		return jobBuilderFactory.get("parceJsonCodere").incrementer(new RunIdIncrementer()).listener(listener)
				.start(step1).next(step2).build();
	}

	@JobScope
	@Bean	
	public Step step1(InsertEventItemWriter writer, @Value("#{jobParameters['process.file.name']}") String param) {
		return stepBuilderFactory.get("step1").<EventBean, Event>chunk(50).reader(readerEventStep1(param))
				.processor(processorStep1).writer(writer).build();
	}

	@Bean
	public InsertEventItemWriter writerEvent() {
		return new InsertEventItemWriter();
	}

	@JobScope
	@Bean	
	public JsonItemReader<EventBean> readerEventStep1(@Value("#{jobParameters['process.file.name']}") String param) {
		Resource jsonR = new FileSystemResource(param);
		log.info("::::> Reading first File from procees dir " + jsonR.getFilename());
		GsonJsonObjectReader<EventBean> json = new GsonJsonObjectReader<EventBean>(EventBean.class);
		try {
			json.open(jsonR);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Gson mapper = new Gson();
		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
		json.setMapper(gson);
		return new JsonItemReaderBuilder<EventBean>().name("eventItemReader").resource(jsonR).saveState(false)
				.maxItemCount(10000).jsonObjectReader(json).build();
	}
	// end::readerwriterprocessor[]

//	@Bean
//	public JsonItemReader<EventBean> readerEventStep2() {
//		GsonJsonObjectReader<EventBean> json = new GsonJsonObjectReader<EventBean>(EventBean.class);
//		try {
//			json.open(new ClassPathResource("GetEvents.json"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		// Gson mapper = new Gson();
//		Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
//		json.setMapper(gson);
//
//		return new JsonItemReaderBuilder<EventBean>().name("eventBetItemReader")
//				.resource(new ClassPathResource("GetEvents.json")).saveState(false).maxItemCount(1000)
//				.jsonObjectReader(json).build();
//	}

	@Bean	
	public InsertBetTraceItemWriter writerBet() {
		return new InsertBetTraceItemWriter();
	}

	@Bean
	@JobScope
	public Step step2(InsertBetTraceItemWriter writer,  @Value("#{jobParameters['process.file.name']}")String param) {
		return stepBuilderFactory.get("step2").<EventBean, BetWrapperList>chunk(100).reader(readerEventStep1(param))
				// .listener(listener)
				// .repository(jobRepository)
				.processor(processorStep2).writer(writer).build();
	}

	// end::jobstep[]

}

//EXAMPLE WRITER WITH DATASOURCE String sql =String.format
//("insert into events (nodeid , name , startdate, locked, priority, statisticsid, parentnodeid)"
//		+ " VALUES (:NodeId, :Name, :StarDate, :Locked, :Priority, :StatisticsId, :parentnodeid)");
//
//
//String sql2 =String.format
//("insert into events (nodeid , name , startdate, locked, priority, statisticsid, parentnodeid)"
//		+ " VALUES (:NodeId, :Name, :StarDate, :Locked, :Priority, :StatisticsId, :parentnodeid)");
//return new JdbcBatchItemWriterBuilder<Event>()
//.itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
//.sql(sql).sql(sql2)
//.dataSource(dataSource)
//.build();

//override class ant add maxttemtps
//@Bean
//public ItemReader<Test> reader(LineMapper<Test> lineMapper, ApplicationProperties properties) {
//    FlatFileItemReader<Test> flatFileItemReader = new FlatFileItemReader<Test>() {
//        @Override
//        @Retryable(value = {ItemStreamException.class}, maxAttempts=5)
//        public void open(ExecutionContext executionContext) throws ItemStreamException {
//            super.open(executionContext);
//        }
//
//        @Override
//        @Retryable(maxAttempts=5)
//        public Holding read() throws UnexpectedInputException, ParseException, Exception {
//            return super.read();
//        }
//
//    };
//    flatFileItemReader.setResource(new FileSystemResource(properties.getLoadFile()));
//    flatFileItemReader.setLineMapper(lineMapper);
//    return flatFileItemReader;

//}