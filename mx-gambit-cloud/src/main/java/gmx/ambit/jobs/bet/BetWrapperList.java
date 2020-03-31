package gmx.ambit.jobs.bet;

import java.util.List;

import gmx.ambit.data.GambitTrace;
import lombok.Data;

@Data
public class BetWrapperList {
	private List<GambitTrace> results;
}
