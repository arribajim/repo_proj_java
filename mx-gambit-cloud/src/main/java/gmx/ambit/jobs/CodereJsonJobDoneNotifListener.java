package gmx.ambit.jobs;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.stereotype.Component;

import gmx.ambit.repo.CountryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 
@Slf4j
@RequiredArgsConstructor
@Component
public class CodereJsonJobDoneNotifListener extends JobExecutionListenerSupport {

	private final CountryRepository countryRepo;

	@Override
	public void afterJob(JobExecution jobExecution) {
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results");
			countryRepo.findAll().forEach( country ->{
				log.info(country.toString());
			});	
			
		}
	}
}
