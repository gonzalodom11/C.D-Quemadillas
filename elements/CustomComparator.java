package elements;

import java.util.Comparator;

public class CustomComparator implements Comparator<Player> {
	
	public int compare(Player o1, Player o2) {
		double rate1 = o1.goals/o1.games;
		double rate2 = o2.goals/o2.games;
        
        if (o1.goals > o2.goals) {
            return 1;
        }
        else if (o1.goals<o2.goals) {
            return -1;
        }
        else {
            if(rate1>rate2) {
            	return 1;
            
        }
            else {
            	return -1;
            }
    }
	}

	
}