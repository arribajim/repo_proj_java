package gmx.ambit.jobs;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.json.GsonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import gmx.ambit.bean.Event;
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
	
	private final CodereJsonItemProcessor processor;
	
	 // tag::readerwriterprocessor[]
    
	@Bean
    public JdbcBatchItemWriter<Event> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Event>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
            .dataSource(dataSource)
            .build();
    }
	
    @Bean
    public JsonItemReader<Event> reader() {
    	log.info("writher meothd");
    	GsonJsonObjectReader<Event> json = new GsonJsonObjectReader<Event>(Event.class);
    	try {
			json.open(new ClassPathResource("GetEvents.json"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//Gson mapper = new Gson();
    	Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDateDeserializer()).create();
    	json.setMapper(gson);
    	
    	return new JsonItemReaderBuilder<Event>()
    			.name("eventItemReader")
    			.resource(new ClassPathResource("GetEvents.json"))
    			.saveState(false)
    			.maxItemCount(1000)
    			.jsonObjectReader(json)    			
    			.build();
    			
    }
    // end::readerwriterprocessor[]

    
	@Bean
    public Job parceJsonCodere(CodereJsonJobDoneNotifListener listener, Step step1) {
        return jobBuilderFactory.get("parceJsonCodere")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Event> writer) {
        return stepBuilderFactory.get("step1")
        		.<Event, Event> chunk(10)
                .reader(reader())
                .processor(processor)
                .writer(writer)
                .build();
    }
    // end::jobstep[]

}
