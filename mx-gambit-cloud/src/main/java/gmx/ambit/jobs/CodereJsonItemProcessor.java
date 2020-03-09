package gmx.ambit.jobs;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.JSONParser;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import gmx.ambit.bean.Event;
import gmx.ambit.parcer.ParceEventsJson;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class CodereJsonItemProcessor implements ItemProcessor<Event, Event>{

	@Override
	public Event process(Event item) throws Exception {
		log.info("Valor de Item ${item} "+item);
		return item;//todo e
	}
	
	private static ArrayList<Event> jsonParce() {
		log.info("Start info parce");
		JSONParser jsonParser = new JSONParser();      
        try 
        {
        	FileReader reader = new FileReader("c://tmp/files/GetEvents.json");
        	Object obj = jsonParser.parse(reader);
        	
            ParceEventsJson parce = new ParceEventsJson();
            parce.parceEvents(obj);
            parce.getEventList().forEach( event ->{
            	log.info(event.sqlInsert());
            });
            parce.parceParticipants(obj);
            parce.getParticipantList().forEach(part ->{
            	log.info(part.sqlInsert());
            });
            
            parce.parceGames(obj);
            parce.getGameList().forEach(elt->{
            	log.info(elt.sqlInsert());
            });
            parce.parceResults(obj);
            parce.getResultList().forEach(elt->{
            	log.info(elt.sqlInsert());
            });
            
//            reader = new FileReader("c://tmp/files/GetCountries.json");
//            obj = jsonParser.parse(reader);
//        	ParceCountriesJson parcec = new ParceCountriesJson();
//        	parcec.parceCountries(obj);
//        	parcec.parceLeagues(obj);
//        	parcec.getCountriesList().forEach(l ->{
//        		log.info(l.sqlInsert());
//        	});
//        	parcec.getLeaguesList().forEach(l ->{
//        		log.info(l.sqlInsert());
//        	});
            return parce.getEventList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
	}
	

}
