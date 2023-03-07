package elements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Player implements Comparable<Player> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Integer id = null; //0
	String name = null; //1
	Integer age = null; //2 
	String position = null; //3
	Integer games = 0; //4
	Integer victories = 0; // 5
	Integer draws = 0; //6
	Integer defeats = games - victories - draws; // 7
	Integer goals = 0;
	Integer points = 0;
	Double goalsGame = Double.valueOf(goals)/Double.valueOf(games);
	Double victoriesGame = victories*100.0/games;
	
	public Double getGoalsGame() {
		return goalsGame;
	}

	public void setGoalsGame(Double goalsGame) {
		this.goalsGame = goalsGame;
	}

	public Integer getDraws() {
		return draws;
	}

	public void setDraws(Integer draws) {
		this.draws = draws;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	

	public Double getVictoriesGame() {
		return victoriesGame;
	}

	
	public Player(Integer id, String name, Integer age, String position, Integer games, 
			Integer victories,Integer draws,Integer goals) {
		
		this.id = id;
		this.name = name;
		this.age = age;
		this.position = position;
		this.games = games;
		this.victories = victories;
		this.draws = draws;
		this.defeats = games - victories - draws;
		this.goals = goals;
		
		points = victories*3 + draws;
		goalsGame = Double.valueOf(goals)/Double.valueOf(games);
	}
	
	public String display(String s1 , String s2, String s3,String s4, String s5, String s6) {
		List<String> ls = new ArrayList<>();
		ls.add(s1);ls.add(s2);ls.add(s3);ls.add(s4);ls.add(s5);ls.add(s6);
		String result = "";
		for(String s : ls) {
			if(s == null) {
				break;
			}
			switch (s) {
			  case "id":
			    result+= " | id:"+id;
			    break;
			  case "name":
				  result+= " | name:"+name;
			    break;
			  case "age":
				  result+= " | age:"+age;
			    break;
			  case "position":
				  result+= " | position:"+position;
			    break;
			  case "games":
				  result+= " | games:"+games;
			    break;
			  case "victories":
				  result+= " | victories:"+victories;
			    break;
			  case "goals":
				  result+= " | goals:"+goals;
			    break;
			  case "points":
				  result += " | points:"+points;
			  default:
				  break;
			}
		}
		
	
		
		
		
		return result;
	}
	
	public  String displayAll() {
	
			return " id:" + id + " | Name:"+name+" | Age:"+age+" | Position:"+ position
					+" | Games:"+ games + " | Victories:"+ victories + " | Draws:"
					+ draws + " | Defeats:" + defeats + " | Goals:"+ goals + " | Points:" + points;
		
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public Integer getGames() {
		return games;
	}
	public void setGames(Integer games) {
		this.games = games;
	}
	public Integer getVictories() {
		return victories;
	}
	public void setVictories(Integer victories) {
		this.victories = victories;
	}
	public Integer getDefeats() {
		return defeats;
	}
	public void setDefeats(Integer defeats) {
		this.defeats = defeats;
	}
	public Integer getGoals() {
		return goals;
	}
	public void setGoals(Integer goals) {
		this.goals = goals;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	
	

	@Override
	public int compareTo(Player o) {
		double rate = o.goals/o.games;
		double thisRate = this.goals/this.games;
        // elements are sorted in reverse order
		int res = o.getGoals().compareTo(this.getGoals());
		
		if (res == 0) {
			if(rate>thisRate) {
				res = 1;
			}
			else if(rate<thisRate) {
				res = -1;
			}
			else {
				res = 0;
			}
			
		}
		return res;
	}
	
	
	
}
