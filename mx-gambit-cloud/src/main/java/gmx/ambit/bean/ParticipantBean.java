package gmx.ambit.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ParticipantBean extends BaseBean{
	private Integer Id;
	private Boolean IsHome;
	private LocalizedName LocalizedNames;
	
	public String toString() {
		return Id+ " " +IsHome + " "+ LocalizedNames;
	}
	
//	public String sqlInsert() {
//		String sql =String.format
//        		("insert into participants values ( %s, \'%s\', \'%s\', %s);",
//        				NodeId,Name,Id,ParentNodeId);
//		return sql;
//	}
}
