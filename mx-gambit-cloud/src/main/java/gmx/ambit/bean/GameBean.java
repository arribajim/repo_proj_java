package gmx.ambit.bean;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

@Data
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class GameBean extends BaseBean{
	private String DisplayTypeName;
	private String GameType;
	private boolean SmartMarketAvailable;	
	private String EventNodeTypeId;	
	private String SportHandle;
	private String ChildrenCount;
	private boolean Locked;
	private List<ResultBean> Results;
	
	
	public String toString() {		
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId
				+", "+Locked + " Results: "+ Results;
	}
	public String sqlInsert() {
		String sql =String.format
        		("insert into games values ( %s, \'%s\',%s, %s, %s);",
        				NodeId,Name,Priority,Locked,ParentNodeId);
		return sql;
	}
	
	 
	
}
