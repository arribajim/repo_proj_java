package gmx.ambit.jobs.bet;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import gmx.ambit.bean.EventBean;
import gmx.ambit.bean.GameBean;
import gmx.ambit.bean.ResultBean;
import gmx.ambit.data.GambitTrace;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class CodereBetItemProcessor implements ItemProcessor<EventBean, BetWrapperList>{

	@Override
	public BetWrapperList process(EventBean item) throws Exception {				
		List<GambitTrace> results = new ArrayList<GambitTrace>();				
		item.getGames().forEach(arg0 ->{
			GameBean gb =(GameBean) arg0;							
			gb.getResults().forEach( result ->{				
				ResultBean rb= (ResultBean) result;
				GambitTrace gr = new GambitTrace();
				gr.setParentnodeid(new BigInteger(gb.getParentNodeId()));
				gr.setNodeId(new BigInteger(rb.getNodeId()));
				gr.setOdd(new Double(rb.getOdd().doubleValue()));
				results.add(gr);
			});			
		});
		BetWrapperList wrapper = new BetWrapperList();
		wrapper.setResults(results);
		return wrapper;
	}	

}
