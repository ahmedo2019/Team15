import java.util.Scanner;
import java.util.*;
import java.lang.Math;
import java.util.Arrays;
public class Multiplayer{
	public static void Multiplay() {
    	System.out.println("\n******Welcome to the Card Match Memory Game******\n");
		System.out.print("Enter 1 for Easy Level or Enter 2 for Hard Level: ");
	    Scanner input = new Scanner(System.in);
	    int levelNum = input.nextInt(); 
	    // decides if easy(1) or hard (2) mode to be applied
	    if (levelNum == 1 || levelNum == 2) {
	    	if (levelNum == 1) {
		    	System.out.println("\nLEVEL DIFFICULTY: EASY :\n");
				// input = 1
	    		Grid.gridPlayEasy();
	    	}
	    	else if (levelNum == 2) {
		    	System.out.println("\nLEVEL DIFFICULTY: HARD :\n");
				// input = 2
	    		Grid.gridPlayHard();
	    		
	    	}
	    }
		// restricts input to either 1 or 2
	    else if (levelNum < 1 || levelNum >2) {
	    	while (levelNum < 1 || levelNum > 2) {
	    	System.out.println("\nPlease Choose a valid level of difficulty");
			System.out.print("\nEnter 1 for Easy Level or Enter 2 for Hard Level: ");
		    Scanner inputTwo = new Scanner(System.in);
		    levelNum = inputTwo.nextInt(); 
		    
			// prints the mode of difficulty for the player and executes them from Grid.java
		    if (levelNum == 1) {
	    	System.out.println("\nLEVEL DIFFICULTY: EASY :\n");
	    	Grid.gridPlayEasy();
			}
		    
		    else if(levelNum == 2) {
	    	System.out.println("\nLEVEL DIFFICULTY: HARD :\n");
	    	Grid.gridPlayHard();
			}
	    }
	}
	}
}