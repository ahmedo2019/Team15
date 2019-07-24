import java.util.Scanner;
import java.util.*;
import java.lang.Math;
import java.util.Arrays;
public class Grid{
	// numRows/Cols = easy
	public static int numRows = 4;
	public static int numRows2 = 6;
    public static int numCols = 4 ;
    public static int numCols2 = 6;

	public static void setRows(int r){
		numRows = r;
	 }
	 public static void setCols(int c){
		numCols = c;
	 }
	 public static void setCount(int [] co){
		Count = co;
	 }
	 public static void setGrid(int [][] g){
		 grid = g;
	 }
	public static int[][] grid = new int[numRows][numCols];
	public static int[][] grid2 = new int[numRows2][numCols2];
	// 1d array to put values in
	public static int [] Count = new int[ ( ( numRows * numCols))];
	public static int [] Count2 = new int[ ( ( numRows2 * numCols2))];
	public static void gridPlayEasy() {
		// 2d array to put the 1d values in
		setCols(4);
		setRows(4);
		setGrid( grid);
		setCount( Count);
		createGrid();
	}
	public static void gridPlayHard() {
		setCols(6);
		setRows(6);
		setGrid( grid2);
		setCount( Count2);
		createGrid( );
	}
	public static void createGrid() {
		// makes a 1d list made up of (numCols * numRows) amount of values
		// only 2 of each number allowed
		int counter = 0;
		for( int i = 0; i < ( ( numRows * numCols)); i+= 2){ 
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

		// counts the amount of elements in list
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = Count[counter];
				counter += 1;
			}

			String array = Arrays.toString(grid[i]);
			System.out.println(array);
		}
			System.out.println();

			String[][] array = new String[numRows2][numCols2];
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				array[i][j] = "*";
			}
		}
		System.out.println("Before: ");
	    for(int i = 0; i<numRows; i++){
			for(int j = 0; j<numCols; j++){
				if (j <= numCols - 2)
				System.out.print("|" + array[i][j]);
				if (j == numCols - 1)
				System.out.print("|" + array[i][j] + "|");
			}
		System.out.println();
		}
		
			int score1=0;int m=1; int score2 = 0;
			for(int i = 0;i<8;i++) {
				// m = 1 is player 1, m = 2 is player 2
				if (m%2==0)
		    		m=2;
		    	else
		    		m=1;
				
				// input from players taken
				System.out.print("\nPlayer " + m+" please enter your X-coordinate for card one: ");
				Scanner input = new Scanner(System.in);
				int b = input.nextInt();
				
				System.out.print("Player " +m+ " please enter your Y-coordinate for card one: ");
				int a = input.nextInt();
				// limit inorder for input to not go out of bound
				if (a >= numRows && b >= numCols) {
					System.out.println("\nPlease Choose valid X and Y coordinates");}
				else {	
					int value1 =grid[a][b];
					System.out.println("Your first card is: " +value1);
				
				System.out.print("\nPlayer " +m+ " please enter your X-coordinate for card two: ");
				int d = input.nextInt();
				
				System.out.print("Player " +m+ " please enter your Y-coordinate for card two: ");
				int c = input.nextInt();
				// limit such that input doesnot fo out of bound
				if (c >= numRows && d >= numCols) {
					System.out.println("\nPlease Choose valid X and Y coordinates");}
				else {
					int value2 =grid[c][d];
					System.out.println("Your second card is: " +value2);
				// decide if the 2 values match
				if (value1 == value2) {
					System.out.println("They Match!");
					// score1 = score for player 1
					if (m == 1) {
						score1=score1+1;
						System.out.println("Player " + m + " score is: "+score1);
					}
					else 
						// score 2 = score for player 2
					{
						score2=score2+1;
						System.out.println("Player " + m + " score is: "+score2);
					}

					String v1=Integer.toString(value1);
					array[a][b]=v1; 
					String v2=Integer.toString(value2);
					array[c][d]=v2;
				for(int o = 0; o<numRows; o++){
					for(int j = 0; j<numCols; j++){
						System.out.print("|" + array[o][j]);
						}
						System.out.println();
					}
					
							
					m++;	
				}
				// message if the 2 values do not match
				else 
				{
					System.out.println();
					System.out.println("They do not Match!");
					
					if (m == 1) {
						System.out.println("Player " + m + " score is: "+score1);
					}
					else 
					{
						System.out.println("Player " + m + " score is: "+score2);
					}
					
					m++;
				}	
			}
				}
			}
			// when all the values are matched
			System.out.println("Game Over\nMatch Summary\n\n");
			// decide result
			if (score1 > score2) {
				System.out.println("Player 1 wins!");
			}
			else if (score1 < score2) {
				System.out.println("Player 2 wins!");
			}
			else {
				System.out.println("Play again!");
			}       
	}
	// hard mode

}