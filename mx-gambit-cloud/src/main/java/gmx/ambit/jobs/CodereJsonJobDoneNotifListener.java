package gmx.ambit.jobs;

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import gmx.ambit.repo.EventRepository;
import gmx.ambit.util.BetUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Component
public class CodereJsonJobDoneNotifListener extends JobExecutionListenerSupport {

	private final EventRepository repository;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYYHHmmss");
	@Value("${bath.codere.dir.process}")
	private String processDir;
	@Value("${bath.codere.file.process}")
	private String processFile;
	@Value("${bath.codere.dir.input}")
	private String inputDir;
	@Value("${bath.codere.dir.output}")
	private String outputDir;


	@Override
	public void afterJob(JobExecution jobExecution) {
		super.afterJob(jobExecution);		
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			log.info("!!! JOB FINISHED! Time to verify the results Count " + repository.count());							
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {			
			BetUtil.toEmptyProccessDir(processDir,dateFormat+".json",outputDir);
			StringBuffer sb = new StringBuffer();
			jobExecution.getAllFailureExceptions().forEach(elt -> {
				sb.append(elt.getCause().toString()).append("\n");
			});
			log.error("Fallo la ejecución del proceso batch", sb.toString());
		}
		BetUtil.toDeleteFile(processDir + processFile);
		
	}

	@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		super.beforeJob(jobExecution);		
		try {
			String nameFile = BetUtil.toProcessFile(inputDir, processDir + processFile);
			log.debug("::::::::::::> BEFORE JOB START COUNT OF EVENTS  " + repository.count()+" MOVING FILE "+nameFile);
		}catch(ArrayIndexOutOfBoundsException e) {
			log.error("Not found files, stoping the job");
			jobExecution.stop();
		}
		
		

	}

}
