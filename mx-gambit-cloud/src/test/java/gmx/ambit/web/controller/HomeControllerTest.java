package gmx.ambit.web.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@WebMvcTest(HomeController.class)   // <1>
public class HomeControllerTest{

	private static final Logger log = LoggerFactory.getLogger(HomeControllerTest.class);
  @Autowired
  private MockMvc mockMvc;   // <2>

  @Test
  public void testHomePage() throws Exception {
	  
	  log.info("MENSAJE DE PRYUEBA PARA SABER SI EJECUTA LA PRUEST");
    mockMvc.perform(get("/"))    // <3>    
      .andExpect(status().isOk())  // <4>      
      .andExpect(view().name("home"))  // <5>      
      .andExpect((ResultMatcher) content().string(           // <6>
          containsString("Welcome to...")));  
  }

}
