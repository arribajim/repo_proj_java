package gmx.ambit.bean;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ResultBean extends BaseBean{
	private Number Odd;
	private String SortOrder;
	private boolean IsLive;	
	private String  EventNodeTypeId;		
	private boolean Locked;
	private Date dateOfGambitCheck;
	
	public String toString() {		
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId
				+", "+Locked+", "+Odd +", "+ dateOfGambitCheck+", "+ IsLive;
	}
	
	public String sqlInsert() {
		String sql =String.format
        		("insert into GAMBIT_RESULTS values ( %s, \'%s\',\'%s\', %s, %s, \'%s\', %s);",
        				NodeId,Name,getTimeStampFormat(),Odd,Priority,Locked,ParentNodeId);
		return sql;
	}
	
	
	/**
	 * @return the timeStampFormat
	 */
	public String getTimeStampFormat() {
		String pattern = "yyyy-MM-dd HH:mm:ss.SSS";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(dateOfGambitCheck==null?new Date():dateOfGambitCheck);
	}

	

	/**
	 * @param dateOfGambitCheck the dateOfGambitCheck to set
	 */
	public void setDateOfGambitCheck(Date dateOfGambitCheck) {
		this.dateOfGambitCheck = dateOfGambitCheck;
	}
	public void setDateOfGambitCheck(long dateOfGambitCheck) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(dateOfGambitCheck);
		this.dateOfGambitCheck = cal.getTime();
	}
	
}
