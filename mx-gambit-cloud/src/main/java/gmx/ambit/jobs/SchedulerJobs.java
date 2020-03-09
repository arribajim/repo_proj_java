package gmx.ambit.jobs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SchedulerJobs {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");

    @Scheduled(cron="${codere.json.scheduler.cron.expresion}")
    //@Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));        
    }
}
