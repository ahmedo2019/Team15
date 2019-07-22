import java.util.Scanner;

public class newtest4 {

	public static void main(String[] args) {
    	System.out.println("\n******Welcome to the Card Match Memory Game******\n");

		
		System.out.print("Enter 1 for Easy Level or Enter 2 for Hard Level: ");
	    Scanner input = new Scanner(System.in);
	    int levelNum = input.nextInt(); 
	    
	    if (levelNum == 1 || levelNum == 2) {
	    	if (levelNum == 1) {
		    	System.out.println("\nLEVEL DIFFICULTY: EASY :\n");
	    		gridPlayEasy();
	    	}
	    	else if (levelNum == 2) {
		    	System.out.println("\nLEVEL DIFFICULTY: HARD :\n");
	    		gridPlayHard();
	    	}
	    }
	    else if (levelNum < 1 || levelNum >2) {
	    	while (levelNum < 1 || levelNum > 2) {
	    	System.out.println("\nPlease Choose a valid level of difficulty");
			System.out.print("\nEnter 1 for Easy Level or Enter 2 for Hard Level: ");
		    Scanner inputTwo = new Scanner(System.in);
		    levelNum = inputTwo.nextInt(); 
		    
		    if (levelNum == 1) {
	    	System.out.println("\nLEVEL DIFFICULTY: EASY :\n");
	    	gridPlayEasy();}
		    
		    else if(levelNum == 2) {
	    	System.out.println("\nLEVEL DIFFICULTY: HARD :\n");
	    	gridPlayHard();}
	    	}
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

public static void gridPlayEasy() {
	String[][] array = {{"1","4","3","2"},
						{"1","3","2","4"},
						{"4","2","3","1"},
						{"3","4","2","1"}};

    System.out.println("Before: ");
    printArray(array);
    
    int m=1;
    for (int k=0;k<4;k++) {
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
	      ||(array[b][a]=="4" && array[d][c]=="4")){
	    	System.out.println("\n------------------------------\nThe coordinates entered are :"+"("+a+","+b+") & ("+c+","+b+")\n\nTHESE CARDS MATCH!. \nGREAT JOB!.");
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
public static void gridPlayHard() {
	String[][] array = {{"1","5","3","2","4"},
						{"5","3","2","4","1"},
						{"4","2","3","1","5"},
						{"3","4","5","1","2"},
						{"3","4","2","1","5"}};

    System.out.println("Before: ");
    printArray(array);
    
    for (int k=0;k<4;k++) {
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
	      ||(array[b][a]=="4" && array[d][c]=="4")){
	    	System.out.println("The coordinates entered are :"+"("+a+","+b+") & ("+c+","+b+")\nTHESE CARDS MATCH!. \nGREAT JOB!.");
	    	array[b][a] = "-";
	    	array[d][c] = "-";
	    		}
	    else {
	    	System.out.println("\nTHESE CARDS DO NOT MATCH. \nPLEASE TRY AGAIN.");	}
	    System.out.println("\nAfter: ");
	    printArray(array);
    
    }
    
    
}

}


