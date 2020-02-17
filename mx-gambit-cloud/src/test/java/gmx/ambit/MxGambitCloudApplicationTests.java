package gmx.ambit;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gmx.ambit.web.controller.HomeController;

@SpringBootTest
class MxGambitCloudApplicationTests {
	@Autowired
	private HomeController controller;
	private static final Logger log = LoggerFactory.getLogger(MxGambitCloudApplicationTests.class);
	@Test
	void contextLoads() {
		log.info("EJECUANTO Pruenbas");
		assertThat(controller).isNotNull();
	}

}
