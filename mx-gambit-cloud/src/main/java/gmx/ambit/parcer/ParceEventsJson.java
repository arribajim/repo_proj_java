package gmx.ambit.parcer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import gmx.ambit.bean.EventBean;
import gmx.ambit.bean.GambitBean;
import gmx.ambit.bean.GameBean;
import gmx.ambit.bean.ParticipantBean;
import gmx.ambit.bean.ResultBean;

public class ParceEventsJson {
	private ArrayList<EventBean> eventList;
	private ArrayList<GameBean> gameList;
	private ArrayList<ResultBean> resultList;
	private ArrayList<ParticipantBean> participantList;
	private ArrayList<GambitBean> gambitList;
	
	@SuppressWarnings("unchecked")
	public void parceEvents(Object obj) {
		JSONArray events = (JSONArray) obj;
		eventList = new ArrayList<EventBean>();
		events.forEach( country ->{
			parceEvent((JSONObject)country);
		});
	}
	
	@SuppressWarnings("unchecked")
	public void parceGames(Object obj) {
		JSONArray events = (JSONArray) obj;
		gameList = new ArrayList<GameBean>();		
		events.forEach( event ->{
			JSONArray games = (JSONArray) ((JSONObject)event).get("Games");
			games.forEach(part ->{
				parceGame((JSONObject)part);
			});
		});		
	}
	
	@SuppressWarnings("unchecked")
	public void parceGambit(String jsonFilePath,long createJsonFile) throws IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();              
    	FileReader reader = new FileReader(jsonFilePath);
    	Object obj = jsonParser.parse(reader);    
		JSONArray events = (JSONArray) obj;
		gambitList = new ArrayList<GambitBean>();
		try {
			
		
			events.forEach( event ->{
				JSONArray games = (JSONArray) ((JSONObject)event).get("Games");
				games.forEach(part ->{
					JSONArray results = (JSONArray) ((JSONObject)part).get("Results");
					results.forEach(result ->{
						parceGambit((JSONObject)result);
					});
				});
			});
					
			gambitList.forEach(elt->{
				 elt.setDateOfGambitCheck(createJsonFile);
				 if(!elt.getParentNodeId().equals("2601345415")) {
					 System.out.println(elt.sqlInsert());
				 }
	         	
	         });
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void parceGambit(JSONObject jsonObject) {
		// TODO Auto-generated method stub		
		GambitBean gambit = new GambitBean();		
		gambit.setParentNodeId( jsonObject.get("NodeId").toString());//from results nodes only need historic info
		gambit.setOdd( Double.parseDouble(jsonObject.get("Odd").toString()));		
        gambitList.add(gambit);
	}

	@SuppressWarnings("unchecked")
	public void parceResults(Object obj) {
		JSONArray events = (JSONArray) obj;
		resultList = new ArrayList<ResultBean>();		
		events.forEach( event ->{
			JSONArray games = (JSONArray) ((JSONObject)event).get("Games");
			games.forEach(part ->{
				JSONArray results = (JSONArray) ((JSONObject)part).get("Results");
				results.forEach(result ->{
					parceResult((JSONObject)result);
				});
			});
		});		
	}
	
	

	private void parceResult(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		ResultBean result = new ResultBean();
		result.setNodeId( jsonObject.get("NodeId").toString());	                
		result.setName( jsonObject.get("Name").toString());
		result.setPriority( Integer.parseInt(jsonObject.get("Priority").toString()));
		result.setParentNodeId( jsonObject.get("ParentNodeId").toString());
		result.setOdd( Double.parseDouble(jsonObject.get("Odd").toString()));
		result.setLocked( Boolean.parseBoolean(jsonObject.get("Locked").toString()));
        resultList.add(result);
	}

	@SuppressWarnings("unchecked")
	public void parceParticipants(Object obj) {
		JSONArray events = (JSONArray) obj;
		participantList = new ArrayList<ParticipantBean>();		
		events.forEach( event ->{
			JSONArray participants = (JSONArray) ((JSONObject)event).get("Participants");

			participants.forEach(part ->{
				parceParticipant((JSONObject)part,(JSONObject)event);
			});
		});		
	}
	private void parceParticipant(JSONObject jsonObject, JSONObject event) {
		//Get jsonObject object within list     
			ParticipantBean part = new ParticipantBean();
			part.setNodeId( jsonObject.get("Id").toString());	                	        
	        part.setParentNodeId(event.get("ParentNodeId").toString());
	        //TODO move 
	        part.setName(parceName((JSONObject) jsonObject,"LocalizedNames"));	        
	        //part.setShortName(parceName((JSONObject) jsonObject,"LocalizedShortNames"));	        
	        participantList.add(part);		
	}
	
	private void parceGame(JSONObject jsonObject) {
		// TODO Auto-generated method stub
		GameBean game = new GameBean();
		game.setNodeId( jsonObject.get("NodeId").toString());	                
		game.setName( jsonObject.get("Name").toString());
		game.setPriority( Integer.parseInt(jsonObject.get("Priority").toString()));
		game.setParentNodeId( jsonObject.get("ParentNodeId").toString());
		game.setLocked( Boolean.parseBoolean(jsonObject.get("Locked").toString()));
        gameList.add(game);
	}

	private String parceName(JSONObject jsonObject, String string) {
		String nameR="";
		JSONObject LocalizedNames = (JSONObject) jsonObject.get(string);
        JSONArray names =(JSONArray)LocalizedNames.get("LocalizedValues");
        
        for(Object name:names) {
        	nameR = ((JSONObject)name).get("Value").toString();
        }
		return nameR;
	}

	private void parceEvent(JSONObject jsonObject) {
		//Get jsonObject object within list     
		EventBean event = new EventBean();
		event.setNodeId( jsonObject.get("NodeId").toString());                
		event.setName( jsonObject.get("Name").toString());
		event.setLocked( Boolean.parseBoolean(jsonObject.get("Locked").toString()));
		event.setPriority(Integer.parseInt(jsonObject.get("Priority").toString()));
		event.setParentNodeId( jsonObject.get("ParentNodeId").toString());
		//date
		 String strDate = (String) jsonObject.get("StarDate");
	        Calendar cal = Calendar.getInstance();
	        		cal.setTimeInMillis(
	        				Long.parseLong(
	        						strDate.substring(strDate.indexOf("(")+1, 
	        								strDate.indexOf(")"))));
		event.setStarDate(cal.getTime());
		event.setStatisticsId(jsonObject.get("StatisticsId").toString());
	         
        eventList.add(event);        
	}
	
	
	
	/**
	 * @return the eventList
	 */
	public ArrayList<EventBean> getEventList() {
		return eventList;
	}
	/**
	 * @param eventList the eventList to set
	 */
	public void setEventList(ArrayList<EventBean> eventList) {
		this.eventList = eventList;
	}
	/**
	 * @return the gameList
	 */
	public ArrayList<GameBean> getGameList() {
		return gameList;
	}
	/**
	 * @param gameList the gameList to set
	 */
	public void setGameList(ArrayList<GameBean> gameList) {
		this.gameList = gameList;
	}
	/**
	 * @return the resultList
	 */
	public ArrayList<ResultBean> getResultList() {
		return resultList;
	}
	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(ArrayList<ResultBean> resultList) {
		this.resultList = resultList;
	}
	/**
	 * @return the participantList
	 */
	public ArrayList<ParticipantBean> getParticipantList() {
		return participantList;
	}
	/**
	 * @param participantList the participantList to set
	 */
	public void setParticipantList(ArrayList<ParticipantBean> participantList) {
		this.participantList = participantList;
	}
}
