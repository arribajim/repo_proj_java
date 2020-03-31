package gmx.ambit.jobs;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SchedulerJobs {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
    @Value("${bath.codere.dir.process}")
	private String processDir;
    @Value("${bath.codere.file.process}")
	private String processFile;
    @Value("${bath.codere.dir.input}")
	private String inputDir;	
	@Value("${bath.codere.dir.output}")
	private String outputDir;
	
	
    @Autowired
    JobLauncher jobLauncher;
//WORKING OK WITH parceJsonCodere CHECK HOW TO PERSONALISE
//    2020-03-10 23:01:30.026  INFO 3176 --- [   scheduling-1] o.s.batch.core.step.AbstractStep         : Step: [step1] executed in 10ms
//    2020-03-10 23:01:30.029  INFO 3176 --- [   scheduling-1] o.s.b.c.l.support.SimpleJobLauncher      : Job: [FlowJob: [name=parceJsonCodere]] completed with the following parameters: [{}] and the following status: [FAILED] in 22ms
    @Autowired
    Job job;
    
//    @Scheduled(cron="${codere.json.scheduler.cron.expresion}")
//    //@Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//        try {
//			jobLauncher.run(job, new JobParameters());
//		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
//				| JobParametersInvalidException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    }
    
    @Scheduled(cron="${codere.json.scheduler.cron.expresion}")
    public void schedule() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
    	//if(job.getName().equals("parceJsonCodere")){
    	
    	log.info("Executing the parceJsonCodere "+ processDir+ " Date: ", dateFormat.format(new Date() ));
    	jobLauncher.run(job, new JobParametersBuilder()        		
    	            .addDate("bet.codere.date", new Date())
    	            .addString("process.file.name", processDir+processFile)
//    	            .addString("input.dir.name", inputDir)
//    	            .addString("output.dir.name", outputDir)
//    	            .addString("process.dir.name", processDir)
    	            .toJobParameters());
    	//}
        
    }
    
    @Bean
    public File getProcessFile() {
    	return null;
    }
}
