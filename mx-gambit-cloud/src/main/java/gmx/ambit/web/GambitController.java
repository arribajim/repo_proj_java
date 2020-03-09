package gmx.ambit.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import gmx.ambit.data.Country;
import gmx.ambit.repo.CountryRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class GambitController {

  private final CountryRepository countryRepo;
  
// AUTO CREATE WITH LOMBOK public GambitController(CountryRepository countryRepo) {
//	// TODO Auto-generated constructor stub
//	  this.countryRepo= countryRepo;
//}
	
  @GetMapping("/gambit")     // <2>
  public String home(Model model) {
	List<Country> list = new ArrayList<Country>();
	countryRepo.findAll().forEach( c -> list.add(c));
	model.addAttribute("countries", list);
	
    return "gambit";     // <3>
  }

}
