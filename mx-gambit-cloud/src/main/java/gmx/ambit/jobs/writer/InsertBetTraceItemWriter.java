package gmx.ambit.jobs.writer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import gmx.ambit.data.GambitTrace;
import gmx.ambit.jobs.bet.BetWrapperList;
import gmx.ambit.repo.GambitTraceRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
public class InsertBetTraceItemWriter implements ItemWriter<BetWrapperList> {

	@Autowired
	private GambitTraceRepository betRepository;
	
	
	@Override
	public void write(List<? extends BetWrapperList> items) throws Exception {
		List <GambitTrace> tracing= new ArrayList<GambitTrace>();
		items.forEach(times ->{
			tracing.addAll(times.getResults());
		});
		if(tracing.size()>0) {
			log.info("Saving to Trace size " +tracing.size());
			betRepository.saveAll(tracing);
		}
		
			
		
	}

}
