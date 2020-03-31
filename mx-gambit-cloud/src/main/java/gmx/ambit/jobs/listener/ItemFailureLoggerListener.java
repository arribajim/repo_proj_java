package gmx.ambit.jobs.listener;

import java.util.List;

import org.springframework.batch.core.listener.ItemListenerSupport;

import gmx.ambit.bean.EventBean;
import gmx.ambit.jobs.bet.BetWrapperList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ItemFailureLoggerListener extends ItemListenerSupport<EventBean, BetWrapperList>{

	@Override
	public void onReadError(Exception ex) {
		// TODO Auto-generated method stub
		super.onReadError(ex);
		log.error("Batch Process o readError -->", ex);
	}

	@Override
	public void onWriteError(Exception ex, List item) {
		// TODO Auto-generated method stub
		super.onWriteError(ex, item);
		log.error("Batch Process o writeError -->", ex);
	}

}
