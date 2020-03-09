package gmx.ambit;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class WebCustomPort implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory > {

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		factory.setPort(9080);		
	}

}
