package gmx.ambit.bean;

public class CountryBean extends BaseBean {
	
	private String CountryCode;
	private LeagueBean[] leagues=null;
	
	@Override
	public String toString() {
		return  NodeId+", "+Name +", "+CountryCode+", "+Priority+", "+ParentNodeId;
	}
	public String sqlInsert() {
		String sql =String.format
        		("insert into countries values ( %s, \'%s\', \'%s\', %s);",
        				NodeId,Name,CountryCode,Priority);
		return sql;
	}
	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return CountryCode;
	}
	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	/**
	 * @return the leagues
	 */
	public LeagueBean[] getLeagues() {
		return leagues;
	}
	/**
	 * @param leagues the leagues to set
	 */
	public void setLeagues(LeagueBean[] leagues) {
		this.leagues = leagues;
	}
}
