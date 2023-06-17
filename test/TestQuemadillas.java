package test;

import java.awt.Color;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import elements.CustomComparator;
import elements.Player;


public class TestQuemadillas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<Player> lista = initialTest();
		//showData(lista);
		// TestQuemadillas.table(lista);
		// TestQuemadillas.tableTop(lista);
		// TestQuemadillas.tableInvitados(lista);
		// TestQuemadillas.tableRafalin(lista);
		System.out.println(topWinners(lista));
	}
	
	
	public static void showData(List<Player> ls) {
		for(Player p : ls) {
			System.out.println(p.displayAll());
		}
	}
	
	public static void table(List<Player> ls) {
		
		String[]columNames = {"Nombre", "Posición", "Partidos","Victorias","Empates","Puntos","% Victorias","Goles"};
		ls = ls.stream().filter(x -> !x.getName().contains("(Invitado)")).toList();
		
		
		String [][] data = new String[ls.size()][8]; 
        
		Integer index = 0;
       for(Player p : ls) {
    		   data[index]= new String[] {p.getName(),p.getPosition(),p.getGames().toString(),
	   					  p.getVictories().toString(),String.valueOf(p.getDraws()),
	   					  p.getPoints().toString(), String.valueOf((p.getVictories()*100/p.getGames())+"%"),
	   					  p.getGoals().toString(),
	   					  p.getPoints().toString(), p.getGoals().toString()
						 };
    		   
    	   index++;
       }
       
      

		JTable table = new JTable(data,columNames);
		JFrame frame = new JFrame("Plantilla 2022/23");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane sp = new JScrollPane(table);
	    frame.add(sp);
	    
	    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
	       {
	           @Override
	           public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	           {
	               final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
	               c.setBackground(row % 2 == 0 ? Color.LIGHT_GRAY : Color.WHITE);
	               return c;
	           }
	       });
	    
		frame.setVisible(true);		
	}
	
public static void tableInvitados(List<Player> ls) {
		
		String[]columNames = {"Nombre", "Posición", "Partidos","Victorias","Puntos","% Victorias","Goles"};
		ls = ls.stream().filter(x -> x.getName().contains("(Invitado)"))
				.sorted(Comparator.comparing(Player::getGoals).reversed()).toList();
		
		String [][] data = new String[ls.size()][7]; 
        
		Integer index = 0;
       for(Player p : ls) {
    		   data[index]= new String[] {p.getName().replace("(Invitado)", ""),p.getPosition(),p.getGames().toString(),
	   					  p.getVictories().toString(), p.getPoints().toString(),
	   					  String.valueOf((p.getVictories()*100/p.getGames())+"%"),
	   					  p.getGoals().toString()
						 };
    		   index++;
       }

		JTable table = new JTable(data,columNames);
		JFrame frame = new JFrame("Invitados 2022/23");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane sp = new JScrollPane(table);
	    frame.add(sp);
		frame.setVisible(true);		
	}
	
	
	
	
public static void tableRafalin(List<Player> ls) {
		
		String[]columNames = {"Nombre", "Posición", "Partidos","Victorias","Puntos","% Victorias","Goles"};
		
		String [][] data = new String[1][7]; 
        
		Integer index = 0;
       for(Player p : ls) {
    	   if(p.getId()==11) {
    		   data[0]= new String[] {p.getName(),p.getPosition(),p.getGames().toString(),
	   					  p.getVictories().toString(), p.getPoints().toString(),
	   					  String.valueOf((p.getVictories()*100/p.getGames())+"%"),
	   					  "12"
						 };
    		   break;
    	   }
    	   
    	   
       }
		
		
		JTable table = new JTable(data,columNames);
		
		JFrame frame = new JFrame("Pichichi Quemadillas");
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
	    	        				 Integer.valueOf(fields[7]) // goals
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
	
	public static void tableTop(List<Player> ls) {
		DecimalFormat df = new DecimalFormat("0.00");
		List<Player> lista = topScorers(ls,"goals");
		String[]columNames = {"Nombre", "Posición", "Partidos","Goles","Goles/Partido"};
		
		String [][] data = new String[lista.size()][5]; 
        
		Integer index = 0;
       for(Player p : lista) {
    	   Double goalsRate = Double.valueOf(p.getGoals())/Double.valueOf(p.getGames());
    	   String golesRate = df.format(goalsRate);
    	   data[index]= new String[] {p.getName(),p.getPosition(),p.getGames().toString(),
    			   					  p.getGoals().toString(),
    			   					  golesRate
    			   					  };
    	   index++;
       }
		
		
		JTable table = new JTable(data,columNames);
		
		
		
		JFrame frame = new JFrame("Máximos goleadores");
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JScrollPane sp = new JScrollPane(table);
	    frame.add(sp);
		frame.setVisible(true);
		
	}
	
	
	

	
	public static List<Player> topScorers(List<Player> ls, String mode) {
		List<Player> result = new ArrayList<>();
		if(mode=="goals") {
			ls.sort(Comparator.comparing(Player::getGoalsGame).reversed());
			ls.sort(Comparator.comparing(Player::getGoals).reversed());
			
			for(int index = 0; index<10;index++) {
				result.add(ls.get(index));
				if(index>=4) {
					if(ls.get(index).getGoals() != ls.get(index+1).getGoals()) {
						break;
					}
							
				}
			}
			
		}
			else {
				ls.sort((Player p1, Player p2) -> p2.getGoals()-p1.getGoals());	
				for(int index = 0; index<7;index++) {
					
					System.out.println(ls.get(index).display("name", "position", "goals", null, null, null));
			}	
		}
		return result;
	}
	
	
	public static List<Player> topWinners(List<Player> ls) {
			List<Player> result = new ArrayList<>();
			result = ls.stream().filter(x -> ! x.getName().contains("Invitado"))
					.sorted(Comparator.comparing(Player::getPoints).reversed())
					.toList();
			
			
			for(int index = 0; index<10;index++) {
				System.out.println(result.get(index).getName()+" "+result.get(index).getPoints().toString());
				
				
				if(index>=4) {
					if(ls.get(index).getVictoriesGame() != ls.get(index+1).getVictoriesGame()) {
						break;
					}
							
				}
			}
			
			
		
		return result;
	}
	
	
	public static void tableTopWinners(List<Player> ls) {
		DecimalFormat df = new DecimalFormat("0.00");
		List<Player> lista = topWinners(ls);
		String[]columNames = {"Nombre", "Posición", "Partidos","Goles","Goles/Partido"};
		
		String [][] data = new String[lista.size()][5]; 
        
		Integer index = 0;
       for(Player p : lista) {
    	   Double goalsRate = Double.valueOf(p.getGoals())/Double.valueOf(p.getGames());
    	   String golesRate = df.format(goalsRate);
    	   data[index]= new String[] {p.getName(),p.getPosition(),p.getGames().toString(),
    			   					  p.getGoals().toString(),
    			   					  golesRate
    			   					  };
    	   index++;
       }
		
		
	
	}
	
	
}
