package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import elements.Player;


public class TestQuemadillas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Player> lista = initialTest();
		//showData(lista);
		//topScorers(lista,"poi");
		table(lista);
	}
	
	
	public static void showData(List<Player> ls) {
		for(Player p : ls) {
			System.out.println(p.displayAll());
		}
	}
	
	public static void table(List<Player> ls) {
		
		String[]columNames = {"Name", "Position", "Goals","Points","% Victories"};
		
		String [][] data = new String[ls.size()][5]; 
        
		Integer index = 0;
       for(Player p : ls) {
    	   data[index]= new String[] {p.getName(),p.getPosition(),p.getGoals().toString(),
    			   p.getPoints().toString(),String.valueOf((p.getVictories()*100/p.getGames())+"%")};
    	   index++;
       }
		
		
		
		
		
		
	
		
		JTable table = new JTable(data,columNames);
		
		
		
		JFrame frame = new JFrame("Table Demo");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane sp = new JScrollPane(table);
	    frame.add(sp);
		frame.setVisible(true);
		
	}
	
	
	
	
	public static void getPositions(List<Player> ls){
		Map<String, List<String>> hm = new HashMap<>();
		
		
		for(Player p : ls) {
			
			if(hm.containsKey(p.getPosition())) {
				
				List<String> lista = hm.get(p.getPosition());
				String name = p.getName();
				lista.add(name);
				hm.replace(p.getPosition(), lista);
			}
			else {
				
				List<String> lista = new ArrayList<>();
				lista.add(p.getName());
				hm.put(p.getPosition(), lista);
			}
		}
		
		hm.forEach((key, value) -> {System.out.println(key + value);});
		
		
		
		
	}
	
	
	
	public static List<Player> initialTest() throws IOException {
		String file = "datos\\Quemadillas.csv";
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
	    	        				 Integer.valueOf(fields[8])
	    	 
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
	
	
	public static void topScorers(List<Player> ls, String mode) {
		if(mode=="points") {
			ls.sort((Player p1, Player p2) -> p2.getPoints()-p1.getPoints());	
			for(int index = 0; index<7;index++) {
				
				System.out.println(ls.get(index).display("name", "position", "points", null, null, null));
			}
		}
			else {
				ls.sort((Player p1, Player p2) -> p2.getGoals()-p1.getGoals());	
				for(int index = 0; index<7;index++) {
					
					System.out.println(ls.get(index).display("name", "position", "goals", null, null, null));
			}
		
			
		}
		
		
	
		
	}
}
