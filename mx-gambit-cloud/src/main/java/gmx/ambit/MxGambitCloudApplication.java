package gmx.ambit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@ComponentScan({"gmx"})
@EntityScan({"gmx"})
@EnableJpaRepositories({"gmx.ambit.repo"})
@EnableScheduling
@SpringBootApplication
public class MxGambitCloudApplication {
	private static ApplicationContext applicationContext;
	public static void main(String[] args) {
		applicationContext = SpringApplication.run(MxGambitCloudApplication.class, args);
		for (String name : applicationContext.getBeanDefinitionNames()) {
			log.debug("===>bean Name"+name);
		}
	}
	
	@Bean
	  public CommandLineRunner dataLoader() {
	    return new CommandLineRunner() {
	      @Override
	      public void run(String... args) throws Exception {
	       
	      }
	    };
	  }

}
