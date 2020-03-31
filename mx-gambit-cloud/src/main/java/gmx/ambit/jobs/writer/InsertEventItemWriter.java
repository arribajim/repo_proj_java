package gmx.ambit.jobs.writer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import gmx.ambit.data.Event;
import gmx.ambit.repo.EventRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
public class InsertEventItemWriter implements ItemWriter<Event> {

	@Autowired
	private EventRepository eventRepository;
	
	
	@Override
	public void write(List<? extends Event> items) throws Exception {		
		List<Event> events = new ArrayList<Event>();		
		items.forEach(item ->{			
			if(!eventRepository.existsById(item.getNodeId())) {
				events.add(item);
			}
		});
		
		if(events.size()>0) {
			log.info(":::::> SAVING EVENTS NEWS " +items.size());
			eventRepository.saveAll(events);	
		}
		
//		not necessary, nested items save by jpa
//		items.forEach(action ->{
//			
//			action.getGames().forEach(game->{
//				log.info("Savinf each game "+ game);
//				gameRepository.save(game);
//			});
//			
//		});
		
		
		
		
	}

}