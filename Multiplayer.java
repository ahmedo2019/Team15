import java.util.Scanner;
import java.util.*;
import java.lang.Math;
import java.util.Arrays;
public class Multiplayer extends Grid {
	public static void Multiplay() {
    	System.out.println("\n******Welcome to the Card Match Memory Game******\n");
		
		//System.out.print("Enter 1 for Easy Level or Enter 2 for Hard Level: ");
		System.out.print("Enter 1 for Multiplayer or Enter 2 to play against a computer: ");
	    Scanner input = new Scanner(System.in);
	    int levelNum = input.nextInt(); 


	    // decides if easy(1) or hard (2) mode to be applied
	    
	   if (levelNum == 1|| levelNum ==2) {
	    	if (levelNum == 1) {
		    	System.out.println("You have chose the multiplayer option:\n");
				System.out.print("Enter 1 for Easy Level or Enter 2 for Hard Level: ");
				Scanner go = new Scanner(System.in);
				int difficulty = go.nextInt();
				if (difficulty == 1 || difficulty == 2) {
					if (difficulty == 1) {
						System.out.println("\nLEVEL DIFFICULTY: EASY :\n");
						// input = 1
						Grid.gridPlayEasy();
					}
					else if (difficulty == 2) {
						System.out.println("\nLEVEL DIFFICULTY: HARD :\n");
						// input = 2
						Grid.gridPlayHard();
						
					}
					
				}
		   else if (levelNum == 2) {
				System.out.println("You have chosen the vsComputer option:\n");
				System.out.println("Please enter 1 for easy mode or Enter 2 for hard mode:\n");
				Scanner scan = new Scanner(System.in);
				int compdifficulty = scan.nextInt();
					if (compdifficulty ==1 || compdifficulty == 2){
						if (compdifficulty ==1){
							System.out.println("Level Difficulty : EASY: \n");
							vsComputer.easycomp();
						}
						if (compdifficulty == 2){
							System.out.println("Level Difficulty : Hard: \n");
							vsComputer.hardcomp();
						}
					}
				}
			}
		}
	}
}