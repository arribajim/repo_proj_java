package gmx.ambit.jobs;

import java.math.BigInteger;
import java.util.ArrayList;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import gmx.ambit.bean.EventBean;
import gmx.ambit.bean.GameBean;
import gmx.ambit.bean.ResultBean;
import gmx.ambit.data.Event;
import gmx.ambit.data.GambitResult;
import gmx.ambit.data.Game;



@Component
public class CodereJsonItemProcessor implements ItemProcessor<EventBean, Event>{

	@Override
	public Event process(EventBean item) throws Exception {		
		Event event = new Event();
		event.setName(item.getName());
		event.setNodeId(new BigInteger(item.getNodeId()));
		event.setParentnodeid(new BigInteger(item.getParentNodeId()));
		event.setPriority(item.getPriority());
		event.setStarDate(item.getStarDate());
		event.setLocked(item.getLocked());
		event.setStatisticsId(item.getStatisticsId());
		
		ArrayList<Game> games = new ArrayList<Game>();
		item.getGames().forEach(arg0 ->{
			Game g = new Game();
			GameBean gb =(GameBean) arg0;
			g.setName(gb.getName());
			g.setNodeId(new BigInteger(gb.getNodeId()));
			//g.setParentnodeid(new BigInteger(gb.getParentNodeId()));
			g.setEvent(event);
			g.setPriority(gb.getPriority());
			g.setLocked(gb.isLocked());			
			games.add(g);
			ArrayList<GambitResult> results = new ArrayList<GambitResult>();			
			gb.getResults().forEach( result ->{				
				ResultBean rb= (ResultBean) result;
				GambitResult gr = new GambitResult();
				gr.setGame(g);
				gr.setLocked(rb.isLocked());
				gr.setName(rb.getName());
				gr.setNodeId(new BigInteger(rb.getNodeId()));
				gr.setOdd(new Double(rb.getOdd().doubleValue()));
				gr.setPriority(rb.getPriority());
				
				results.add(gr);
			});
			g.setResults(results);
		});
		event.setGames(games);
		
		
		return event;
	}	

}
