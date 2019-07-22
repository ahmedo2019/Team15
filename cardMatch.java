import java.util.Scanner;

public class cardMatch{

	//This is the main method for introducing the game and allowing the user to choose their level.
	public static void main(String[] args) {
		//This will introduce the user to the game
    	System.out.println("\n-------------------------------------------------\n******Welcome to the Card Match Memory Game******\n-------------------------------------------------\n");
    	
    	//Opens Scanner
	    Scanner input = new Scanner(System.in);
	    
	    //Initializing the integer input values
	    //Creating a boolean value for the do - while loop
	    int levelNum = 0;
	    boolean inputLevel;
	    
	    //Statement for choosing a difficulty level for user
	    System.out.print("Enter 1 for EASY LEVEL\nEnter 2 for MEDIUM LEVEL\nEnter 3 for HARD LEVEL\nPlease choose a LEVEL: ");
	    
	    //Do-While loop will ensure that the input is an integer and while keep asking the user for a valid input
	    //If something other than a valid integer is entered, the while loop will keep asking the user for a valid input
	    //If a valid input is entered, the user will be taken to the statements which allow for the user to go into a difficulty level of choice
	    do {
		    if (input.hasNextInt()) {
			    levelNum = input.nextInt();
			    inputLevel = true;
		    }
		    
		    else {
	    		System.out.println("\nPlease Choose a valid level of difficulty");
	    		System.out.print("\nEnter 1 for EASY LEVEL\nEnter 2 for MEDIUM LEVEL\nEnter 3 for HARD LEVEL\nPlease choose a LEVEL: ");
		    	inputLevel = false;
		    	
		    	//This will remove the value inside the scanner allowing for new user input
		    	input.next();
		    }
		    
	    } 
	    //This while loop will evaluate if the input is a number or not a number
	    //If the input (inputLevel) is NOT a number, the do loop will be executed again
	    while (inputLevel == false);

	    //If the user inputs the correct and valid values, then he user will be taken to the prompt statements to play the level of choice
	    //This is the statements which allow the user to go into their difficulty level.
    	if (levelNum == 1 || levelNum == 2 || levelNum == 3) {
    		
			//Path to Easy level with choice of 
    		if (levelNum == 1) {
    			System.out.println("\nLEVEL DIFFICULTY: EASY :\n");
    			gridPlayEasy();
    		}
    		
			//Path to Medium level with choice of 2   		
    		else if (levelNum == 2) {
    			System.out.println("\nLEVEL DIFFICULTY: MEDIUM :\n");
    			gridPlayMedium();
    		}
    		
			//Path to Hard level with choice of 3    		
    		else if (levelNum == 3) {
    			System.out.println("\nLEVEL DIFFICULTY: HARD :\n");
    			gridPlayHard();
    		}
    		
    	}
    	
    	//If the user inputs values that are less than 1 or greater than 3...
    	//then the user will be asked to input a valid choice of numbers from 1 to 3.
    	else if (levelNum < 1 || levelNum > 3) {
    		System.out.println("\nPlease Choose a valid level of difficulty");
    		System.out.print("\nEnter 1 for EASY LEVEL\nEnter 2 for MEDIUM LEVEL\nEnter 3 for HARD LEVEL\nPlease choose a LEVEL: ");
    		Scanner inputTwo = new Scanner(System.in);
    		levelNum = inputTwo.nextInt();
    		
				//Path to Easy level with choice of 2
    			if (levelNum == 1) {
    				System.out.println("\nLEVEL DIFFICULTY: EASY :\n");
    				gridPlayEasy();
    			}
    			
    			//Path to Medium level with choice of 2
    			else if(levelNum == 2) {
    				System.out.println("\nLEVEL DIFFICULTY: MEDIUM :\n");
    				gridPlayMedium();
    			}
    			
    			//Path to Hard level with choice of 3
    			else if (levelNum == 3) {
    				System.out.println("\nLEVEL DIFFICULTY: HARD :\n");
    				gridPlayHard();}
    	}
	    
	    
	}

	//This method will print array if the grid is to be randomized
	private static void printArray(String[][] array){
	
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[0].length; j++){
                System.out.print(" | "+array[i][j]);
                System.out.print(" | ");        
			}
       
			System.out.println("");         
		}
	}

	//This method will print out a grid for the easy level game-play
	public static void gridPlayEasy() {
		String[][] array = {{"1","4","3","2"},
							{"1","3","2","4"},
							{"4","2","3","1"},
							{"3","4","2","1"}};

		System.out.println("Before: ");
		printArray(array);
    
		int m=1;
		for (int k=0;k<8;k++) {
			if (m%2==0)
				m=2;
			else
				m=1;
				System.out.println("\nPlayer "+ m+" - Please choose your cards:");
				System.out.print("\nEnter a value for your 1ST CARD X coordinate: ");
				Scanner input = new Scanner(System.in);
				int a = input.nextInt();
				System.out.print("Enter a value for your 1ST CARD Y coordinate: ");
				Scanner inputB = new Scanner(System.in);
				int b = inputB.nextInt();
				System.out.print("Enter a value for your 2ND CARD X coordinate: ");
				Scanner inputC = new Scanner(System.in);
				int c = inputC.nextInt();
				System.out.print("Enter a value for your 2ND CARD Y coordinate: ");
				Scanner inputD = new Scanner(System.in);
				int d = inputD.nextInt();
	    
	    if ((array[b][a]=="1" && array[d][c]=="1") 
	      ||(array[b][a]=="2" && array[d][c]=="2")
	      ||(array[b][a]=="3" && array[d][c]=="3")
	      ||(array[b][a]=="4" && array[d][c]=="4")){
	    	System.out.println("\n------------------------------\n"+ "The coordinates entered are :"+"("+a+","+b+") & ("+c+","+d+")\n\nTHESE CARDS MATCH!. \nGREAT JOB!.");
	    	array[b][a] = "-";
	    	array[d][c] = "-";
	    		}
	    else {
	    	System.out.println("\nTHESE CARDS DO NOT MATCH. \nPLEASE TRY AGAIN.");	}
	    	System.out.println("\n------------------------------\nAfter Player "+ m+"'s turn:");
	    	printArray(array);
	    	m++;
		}
    
		System.out.println("\nGame over");
	}
	
	//This method will print out a grid for the medium level game-play
	public static void gridPlayMedium() {
		String[][] array = {{"1","5","3","2","4"},
							{"5","3","2","4","1"},
							{"4","2","3","1","5"},
							{"3","4","5","1","2"},
							{"4","2","1","3","5"},
							{"5","1","4","2","3"}};

		System.out.println("Before: ");
		printArray(array);
    
		int m=1;
		for (int k=0;k<15;k++) {
			if (m%2==0)
	    		m=2;
	    	else
	    		m=1;
			
				System.out.println("\nPlayer "+ m+" - Please choose your cards:");
				
				System.out.print("\nEnter a value for your 1ST CARD X coordinate: ");
				Scanner input = new Scanner(System.in);
				int a = input.nextInt();
			
				System.out.print("Enter a value for your 1ST CARD Y coordinate: ");
				int b = input.nextInt();
				
				System.out.print("Enter a value for your 2ND CARD X coordinate: ");
				int c = input.nextInt();
				
				System.out.print("Enter a value for your 2ND CARD Y coordinate: ");
				int d = input.nextInt();
	    


			if ((array[b][a]=="1" && array[d][c]=="1") 
				||(array[b][a]=="2" && array[d][c]=="2")
				||(array[b][a]=="3" && array[d][c]=="3")
				||(array[b][a]=="4" && array[d][c]=="4")
				||(array[b][a]=="5" && array[d][c]=="5")){
				
				System.out.println("\n------------------------------\nThe coordinates entered are :"+"("+a+","+b+") & ("+c+","+d+")\n\nTHESE CARDS MATCH!. \nGREAT JOB!.");
				array[b][a] = "-";
				array[d][c] = "-";
	    	}
			
			else {
	    	System.out.println("\nTHESE CARDS DO NOT MATCH. \nPLEASE TRY AGAIN.");	}
			System.out.println("\n------------------------------\nAfter Player "+ m+"'s turn:");
			printArray(array);
			m++;
		}
    
	}
	
	//This method will print out a grid for the hard level game-play
	public static void gridPlayHard() {
		String[][] array = {{"1","5","3","2","4"},
							{"5","3","2","4","1"},
							{"4","2","3","1","5"},
							{"3","4","5","1","2"},
							{"4","2","1","3","5"},
							{"5","1","4","2","3"}};
		
		System.out.println("Before: ");
		printArray(array);
    
		int m=1;
		for (int k=0;k<18;k++) {
			if (m%2==0)
	    		m=2;
	    	else
	    		m=1;
			
				System.out.println("\nPlayer "+ m+" - Please choose your cards:");
				
				System.out.print("\nEnter a value for your 1ST CARD X coordinate: ");
				Scanner input = new Scanner(System.in);
				int a = input.nextInt();
			
				System.out.print("Enter a value for your 1ST CARD Y coordinate: ");
				int b = input.nextInt();
				
				System.out.print("Enter a value for your 2ND CARD X coordinate: ");
				int c = input.nextInt();
				
				System.out.print("Enter a value for your 2ND CARD Y coordinate: ");
				int d = input.nextInt();
	    


			if ((array[b][a]=="1" && array[d][c]=="1") 
				||(array[b][a]=="2" && array[d][c]=="2")
				||(array[b][a]=="3" && array[d][c]=="3")
				||(array[b][a]=="4" && array[d][c]=="4")
				||(array[b][a]=="5" && array[d][c]=="5")){
				
				System.out.println("\n------------------------------\nThe coordinates entered are :"+"("+a+","+b+") & ("+c+","+d+")\n\nTHESE CARDS MATCH!. \nGREAT JOB!.");
				array[b][a] = "-";
				array[d][c] = "-";
	    	}
			
			else {
	    	System.out.println("\nTHESE CARDS DO NOT MATCH. \nPLEASE TRY AGAIN.");	}
			System.out.println("\n------------------------------\nAfter Player "+ m+"'s turn:");
			printArray(array);
			m++;
		}
    
	}

}


