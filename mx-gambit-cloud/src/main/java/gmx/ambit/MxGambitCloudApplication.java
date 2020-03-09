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
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.data.IngredientRepository;
@Slf4j
@ComponentScan({"tacos","gmx"})
@EntityScan({"tacos","gmx"})
@EnableJpaRepositories({"tacos.data","gmx.ambit.repo"})
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
	  public CommandLineRunner dataLoader(IngredientRepository repo) {
	    return new CommandLineRunner() {
	      @Override
	      public void run(String... args) throws Exception {
	        repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
	        repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
	        repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
	        repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
	        repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
	        repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
	        repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
	        repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
	        repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
	        repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
	      }
	    };
	  }

}
