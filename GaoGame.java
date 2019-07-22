import java.util.Scanner;
import java.util.*;
import java.lang.Math;
import java.util.Arrays;

// need notes to explain this shit
public class GaoGame {


	public static int numRows = 4;
    public static int numCols = 4;
	public static int numRows2 = 5;
    public static int numCols2 = 5;
	// 2d array to put the 1d values in
    public static int[][] grid = new int[numRows][numCols];
	public static int[][] grid2 = new int[numRows2][numCols2];
	// 1d array to put values in
	public static int [] Count = new int[ ( ( numRows * numCols))];
	public static int [] Count2 = new int[ ( ( numRows2 * numCols2))];

	public static void main(String[] args) {
    	System.out.println("******welcome to Card Match Memory Game******");
		System.out.println();
		System.out.println("---------------------------------------------");

		
		System.out.print("Enter the level of the game 4 or 5:");
	    Scanner input = new Scanner(System.in);
	    int gridNumber = input.nextInt(); 
	    
	    if (gridNumber==4) {
			System.out.println();
	    	System.out.println("welcome to level 4 :\n");
			gridPlay4();
		}
	    else if(gridNumber==5) {
	    	System.out.print("welcome to level 5:\n");
	    	gridPlay5();
		}
	    else {
			System.out.println();
	    	System.out.print("terminate!");
	    	
	    }
	    	
        }
	
private static void printArray(String[][] array){
	
	for(int i=0; i<array.length; i++){
        for(int j=0; j<array[0].length; j++){
                System.out.print(" | "+array[i][j]);
        System.out.print(" | ");        
                }
       
        System.out.println("");         
	}
}

	public static void gridPlay4() {

		createGrid();
	}
	
	public static void createGrid() {
		// makes a 1d list made up of (numCols * numRows) amount of values
		// only 2 of each number allowed
		int counter = 0;
		for( int i = 0; i < ( ( numRows * numCols)); i+= 2){ //8 times
			if (i == 0 || i == 1)
				Count[0] = 0;
				Count[1] = 0;
			if (i >= 2)
				Count[i] = i/2;
				Count[i+1] = i/2;
		}
		
		// shuffles the above list
		Random random = new Random();

		for (int i = Count.length - 1; i > 0; i--) {
			int m = random.nextInt(i + 1);
			int temp = Count[i];
			Count[i] = Count[m];
			Count[m] = temp;
			}
			//System.out.println(Arrays.toString(Count));
			// makes the list into a 2d array
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = Count[counter];
				counter += 1;
			}
	// prints the 2d list , one row at a time
			String array = Arrays.toString(grid[i]);
			System.out.println(array);
		}
			System.out.println();
			//System.out.println(grid[1][0]);
			//System.out.println(grid[2][0]);
			//System.out.println(grid[3][0]);
			
			
			System.out.print("\nPlayer 1 please enter your X-coordinate for card one:");
			Scanner input = new Scanner(System.in);
			int b = input.nextInt();
			
			System.out.print("Player 1 please enter your Y-coordinate for card one:");
			int a = input.nextInt();
			
			System.out.println("Your first card is: " +grid[a][b]);
			
			System.out.print("\nPlayer 1 please enter your X-coordinate for card two:");
			int d = input.nextInt();
			
			System.out.print("Player 1 please enter your Y-coordinate for card two:");
			int c = input.nextInt();
			
			System.out.println("Your second card is: " +grid[c][d]);
			
			if (grid[a][b] == grid[c][d]) {
				System.out.println("They Match!");
			}
			else 
			{
				System.out.println();
				System.out.println("They do not Match!");	
			}	
	}


	public static void gridPlay5() {
	System.out.println("To be available.");
    
    
}

}


