package gmx.ambit.bean;

import lombok.Data;

@Data
public class BaseBean {
	protected String Name;
	protected String NodeId;
	protected String ParentNodeId;
	protected Integer Priority;
		public String toString() {
		return NodeId +", "+ Name+", "+Priority+", "+ParentNodeId;
	}
	public String sqlInsert() {
		String sql =String.format
        		("insert into TABLE_XX values ( %s, \'%s\', \'%s\', %s);",
        				NodeId,Name,Priority,ParentNodeId);
		return sql;
	}
}
