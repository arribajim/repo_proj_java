package gmx.ambit.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Data
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class EventBean extends BaseBean{
	private Boolean Locked;
	private Date StarDate;	
	private String StatisticsId;
	private List<GameBean> Games ;
	private List<ParticipantBean> Participants;

	public String toString() {
		if(Games!=null)
			log.info(" Games size "+ Games.size());
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId
				+", "+Locked+", "+StarDate+", "+StatisticsId + Games +"  " +Participants;
	}
	
	public String sqlInsert() {
		String sql =String.format
        		("insert into events values ( %s, \'%s\',\'%s\', %s, %s, \'%s\', %s);",
        				NodeId,Name,getTimeStampFormat(),Priority,Locked,StatisticsId,ParentNodeId);
		return sql;
	}


	/**
	 * @return the timeStampFormat
	 */
	public String getTimeStampFormat() {
		String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(StarDate);
	}

	
	 
}
