package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import elements.Player;


public class TestQuemadillas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Player> lista = initialTest();
		
		topScorers(lista);
		
	}
	
	
	public static List<Player> initialTest() throws IOException {
		String file = "src\\datos\\Quemadillas.csv";
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Integer index = 0;
		List<Player> result = new ArrayList<>();
		
		
		try {
			String line = reader.readLine();
	         while (null!=line) {
	        	 if(index != 0) {
	        		 String [] fields = line.split(",");
	        		 
	        		 
	        		 for (String field : fields) {
	        			 if (field == "") {
	        				 field = null;
	        			 }
	        			
	        			 
	        		 }
	        		 result.add(
	        				 new Player(Integer.valueOf(fields[0]),// id 
	    	        				 fields[1], //Nombre
	    	        				 Integer.valueOf(fields[2]), //edad
	    	        				 fields[3], // Posicion
	    	        				 Integer.valueOf(fields[4]), // games
	    	        				 Integer.valueOf(fields[5]), //victories
	    	        				 Integer.valueOf(fields[6]), //draws
	    	        				 null,
	    	        				 Integer.valueOf(fields[7]), //goals
	    	        				 Integer.valueOf(fields[8]), // assits
	    	        				 Integer.valueOf(fields[9]) // MVPs
	        						 )
	        				 );
	        		 
	 	              
	        	 }
	            
	        	
	            index ++;
	            line = reader.readLine();
	         }
	         
			
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		
		finally {
			reader.close();
			
		}
		return result;
	
	}
	
	
	public static void topScorers(List<Player> ls) {
		ls.sort((Player p1, Player p2) -> p2.getGoals()-p1.getGoals());	
		for(int index = 0; index<5;index++) {
			
			System.out.println(ls.get(index).display("name", "position", "goals", null, null, null));
			
		}
	
		
	}
}
