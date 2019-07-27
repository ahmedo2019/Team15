import java.util.Scanner;
import java.util.*;
import java.lang.Math;
import java.util.Arrays;
import java.util.Random;

public class vsComputer extends Grid{
	public static void hardcomp(){
		int numCols = Grid.getCols2();
		int numRows = Grid.getRows2();
		setCount( Count2 );
		int [][]grid  = Grid.createGrid(grid2);
		computer(grid);
	}


	public static void easycomp(){
		int numCols = Grid.getCols();
		int numRows = Grid.getRows();
		setCount( Count);
		int[][] grid = Grid.createGrid( agrid);
		computer(grid);
		
	}
	public static void computer(int [][]grid){
		String[][] array = new String[numRows][numCols];
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
			for(int i = 0;((score1 + score2)<((numRows * numCols)/2));i++) {
				// m = 1 is player 1, m = 2 is player 2
				if (m%2==0)
		    		m=2;
		    	else
		    		m=1;
				if (m == 1){
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
				if ( a != c || b!= d){
					if (value1 == value2) {
						//System.out.println("They Match!");
						// score1 = score for player 1
						score1=score1+1;
						System.out.println("Player " + m + " score is: "+score1);
						System.out.println("Computer  score is: "+score2);

						String v1=Integer.toString(value1);
						array[a][b]=v1; 
						String v2=Integer.toString(value2);
						array[c][d]=v2;
						m++;
					
					}
				
				
				
				else 
					{
					System.out.println();
					System.out.println("They do not Match!");
					System.out.println("Player " + m + " score is: "+score1);
					System.out.println("Computer  score is: "+score2);
					m++;	

					}
				
				}
				}
			
				}

			}  
				Random rand = new Random();	
				int prob = rand.nextInt(100); 
				System.out.println("probabiliry is " + prob);
				System.out.println("m is " + m);
			
				if (m ==2){
					//System.out.println("pass gate 1");
					// coding for robot starts
	
					// these will go from 0 to numCols - 1 or numRows - 1
					int n = 0; // row of the first random number 
					int c = 0; // column of the first random number
					int n2 = 0; // row of the second random number
					int c2 = 0; // column of the second random number
					for(int o = 0; o<numRows; o++){
						for(int j = 0; j<numCols; j++){
							while(array[n][c] != "*"){
								n = rand.nextInt(numRows);
								c = rand.nextInt(numCols);
							}
							while((array[n2][c2] != "*")){
								n2 = rand.nextInt(numRows);
								c2 = rand.nextInt(numCols);
							}
							
						}
					}
					
					System.out.println("n is " + n + "c is" + c +"n2 is"+ n2+"c2 is" + c2);

					// prob will go from 0 to 99 
					if (prob >= 0 && ((prob <= 49 && numRows == 4) || (prob <= 24 && numRows == 6))){
						//System.out.println("pass gate 2");
						int value3 = grid[n][c];
						System.out.println("The computer has picked: " + value3);
						int value4 = grid[n2][c2];

						System.out.println("The second number the computer has picked is: " + value4);
						if (value3 == value4 &&((n != n2) || (c != c2) )){
							//System.out.println("pass gate 3");
							System.out.println("The computer has matched 2 cards");
							score2+=1;
							String v3=Integer.toString(value3);
							array[n][c]=v3; 
							String v4=Integer.toString(value4);
							array[n2][c2]=v4;
							System.out.println("Computer Score is: " + score2	);
							m--;
						}
						if (value3 != value4) {
							//System.out.println("pass gate 4");
							System.out.println();
							int value5 = grid[n][c];
							System.out.println("The computer has picked: " + value5);
							int value6 = grid[n2][c2];
							System.out.println("The second number the computer has picked is: " + value6);
							System.out.println("They do not Match!");
							
							System.out.println("Computer Score is: " + score2);
							
							m--;
						}						
						}
					
	
				}

					int tracker = 0; // will recrod the number 
					int q = 0; // row of the first number the computer will pick 
					int r = 0;// column of the first number the computer will pick
					int s = 0;// row of the second number the computer will pick
					int t = 0;// column of the second number the computer will pick
					int track = 0;
					int got = 0;
					if ( m == 2){
						if (((prob >= 50 && numRows == 4) || (prob>= 75 && numRows == 6)	) && prob <= 99){	
							//System.out.println("pass gate 5");
							for(int p = 0; p<numRows; p++){
								for(int z = 0; z<numCols; z++){
									if (!array[p][z].equals("" + grid[p][z]))
										tracker += 1;

								}
							}
							tracker = tracker /2;

							int ran = rand.nextInt(tracker);
							tracker = 0;
						
							for(int p = 0; p<numRows; p++){
								for(int z = 0; z<numCols; z++){
									//System.out.println("pass gate 6");
									if (tracker != ran);
										if (array[p][z].equals("" + grid[p][z]))
											tracker += 1;
											
									else
										got = grid[p][z];
									
								}
							}
									
							for(int k = 0; k<numRows; k++){
								for(int w = 0; w<numCols; w++){
									if ( grid[k][w] == got){
										track += 1;
										if (track ==1){
											q = k;
											r = w;
										}
									
										if (track == 2 ){
											s = k;
											t = w;
											System.out.print("track is" + track);
										}	
									}
									//System.out.println("pass gate 7");
									}
								}
							
							int value5 = grid[q][r];
							System.out.println("The computer has picked: " + value5);
							int value6 = grid[s][t];
							System.out.println("The second number the computer has picked is: " + value6);
							if (value5 == value6 && ((q != s)||(r!= t))){
								//System.out.println("pass gate 8");								
								System.out.println("The computer has matched 2 cards");
								score2 += 1;
								String v5=Integer.toString(value5);
								array[q][r]=v5; 
								String v6=Integer.toString(value6);
								array[s][t]=v6;
								m--;
								System.out.println("Computer Score is: " + score2);
							}
								
						}
					}
				for(int o = 0; o<numRows; o++){
					for(int j = 0; j<numCols; j++){
						System.out.print("|" + array[o][j]);
						}
						System.out.println();
					}
			}

				System.out.println("Game Over\nMatch Summary\n\n");

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
}