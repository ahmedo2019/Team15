import java.util.*;
import java.lang.Math;
import java.util.Arrays;
// no comment here
public class Grids {
	// numCols & numRows being changed will change the whole program
	public static int numRows = 4;
    public static int numCols = 4;
	// 2d array to put the 1d values in
    public static int[][] grid = new int[numRows][numCols];
	// 1d array to put values in
	public static int [] Count = new int[ ( ( numRows * numCols))];


	public static void main(String[] args){
    }
	
	public static void createGrid(){
		// makes a 1d list made up of (numCols * numRows) amount of values
		// only 2 of each number allowed
		int counter = 0;
		for( int i = 0; i < ( ( numRows * numCols)); i+= 2){
			if (i == 0 || i ==1)
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
		System.out.println(Arrays.toString(grid[i]));
		}
	}
}
