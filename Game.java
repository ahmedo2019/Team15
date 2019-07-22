import java.util.ArrayList;
import java.util.Random;

public class Game {

	public static void main(String[]args) {
		
		
		// Variables 
		int x = 6; 
		int number;
		
		// Number Generator 
		
		Random numberGenerator = new Random();  
		number = numberGenerator.nextInt(x); // Generations numbers up to X - 1. 
		
		System.out.println("Random Number Generated: " + number);
		
		String n = Integer.toString(number);
		
		String [][] Position = {{n,n,"3","6"},
								{"4","1","2","3"},
								{"4","5","6","5"}};
		
		for (int i = 0; i < 3; i++) { 			//Tracks outer Array. 
			for (int j = 0; j < 4; j++) {		//Tracks inner Array. 
				
				System.out.print(Position[i][j]+" ");
			}
			
			System.out.println();
		}


	}

}
	