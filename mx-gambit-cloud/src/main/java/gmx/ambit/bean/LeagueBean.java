package gmx.ambit.bean;

public class LeagueBean extends BaseBean{
	
	public String sqlInsert() {
		String sql =String.format
        		("insert into leagues values ( %s, \'%s\', %s, %s);",
        				NodeId,Name,Priority,ParentNodeId);
		return sql;
	}
}
