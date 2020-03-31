package gmx.ambit.parcer;


import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import gmx.ambit.bean.CountryBean;
import gmx.ambit.bean.LeagueBean;

public class ParceCountriesJson {

	private ArrayList<CountryBean> countriesList;
	private ArrayList<LeagueBean> leaguesList;
	@SuppressWarnings("unchecked")
	public void parceCountries(Object obj) {
		JSONArray countries = (JSONArray) obj;
		countriesList = new ArrayList<CountryBean>();
		countries.forEach( country ->{
			parceCountry((JSONObject)country);
		});
	}
	
	@SuppressWarnings("unchecked")
	public void parceLeagues(Object obj) {
		JSONArray countries = (JSONArray) obj;
		leaguesList = new ArrayList<LeagueBean>();		
		countries.forEach( country ->{
			JSONArray Leagues = (JSONArray) ((JSONObject)country).get("Leagues");

			Leagues.forEach(league ->{
				parceLeague((JSONObject)league);
			});
		});		
	}
	
	public void parceLeague(JSONObject jsonObject) {
		//Get jsonObject object within list     
			LeagueBean country = new LeagueBean();
	        country.setNodeId( jsonObject.get("NodeId").toString());	                
	        country.setName( jsonObject.get("Name").toString());
	        country.setPriority( Integer.parseInt(jsonObject.get("Priority").toString()));
	        country.setParentNodeId( jsonObject.get("ParentNodeId").toString());
	        leaguesList.add(country);		
	}

	public void parceCountry(JSONObject jsonObject) {
		//Get jsonObject object within list     
		CountryBean country = new CountryBean();
        country.setNodeId( jsonObject.get("NodeId").toString());
        country.setCountryCode( jsonObject.get("CountryCode").toString());        
        country.setName( jsonObject.get("Name").toString());
        country.setPriority( Integer.parseInt(jsonObject.get("Priority").toString()));
        country.setParentNodeId( jsonObject.get("ParentNodeId").toString());
        countriesList.add(country);        
	}

	/**
	 * @return the countriesList
	 */
	public ArrayList<CountryBean> getCountriesList() {
		return countriesList;
	}

	/**
	 * @param countriesList the countriesList to set
	 */
	public void setCountriesList(ArrayList<CountryBean> countriesList) {
		this.countriesList = countriesList;
	}

	/**
	 * @return the leaguesList
	 */
	public ArrayList<LeagueBean> getLeaguesList() {
		return leaguesList;
	}

	/**
	 * @param leaguesList the leaguesList to set
	 */
	public void setLeaguesList(ArrayList<LeagueBean> leaguesList) {
		this.leaguesList = leaguesList;
	}
}
