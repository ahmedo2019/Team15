import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import loopmusicjavaupdated.GUI;
import loopmusicjavaupdated.musicStuff;

import java.util.Random;

/*************************************************************************
 * The purpose of this GUI.java class is to show the GUI or Graphics User
 * Interface in the Card Match Memory Game. The GUI is using the
 * imported Application called the java.fx or java.swing. The GUI is
 * not yet fully connected to the other classes rather it presents a
 * menu screen and allows for the menu and the game to be displayed by
 * running the Game.java class.
 * ***********************************************************************
 */

public class newGUI extends Application {

    //The Tile object is used for this GUI to show the function of the game.
    private Tile selected = null;
    private int numOfClicks = 2;
   
    
    //This will introduce the Grid creation into the tiles so that each tile is made according
    //to the Grid.java file.
	public static int[][] createGrid() {
		int numRows =4;
		int numCols =4; 
		int []Count = new int[numCols * numRows];
		int [][]grid = new int[numRows][numCols]; 
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
			return (grid);
	}
    
	//Using the Grid creation method createGrid to make the tiles array to display the text
	//The value of each tile has been displayed from the value of the grid.
	public Parent createContent() {
        Pane gameWindow = new Pane();
        gameWindow.setPrefSize(802,802);
	
    	/*Initializing the number of Cards with each pair of cards so for the 
    	 *easy level there would be a total of 16 cards with 8 cards that show 
    	 *the same image which can be matched.
    	 */
		int numCols = 4;
		int numRows = 4;
		
		int[][] grid = createGrid();  
			List<Tile> cards = new ArrayList<>();
			for(int y = 0; y<numRows; y++){
				for(int e = 0; e<numCols; e++){
					cards.add(new Tile(String.valueOf(grid[y][e])));
					//tiles.add(new Tile(String.valueOf(c)));
				}
			}

			for (int i = 0; i < cards.size(); i++) {
				Tile tile = cards.get(i);
				tile.setTranslateX(200 * (i % numRows));
				tile.setTranslateY(200 * (i / numRows));
				gameWindow.getChildren().add(tile);
			


		}
		return gameWindow;
	}
	
	
	/*This method is the stage that sets the window itself. It calls the method
	 * to run the createContent method to create the grid of tiles with the text.
	 * 
	 */

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
        //primaryStage.setFullScreen(true);
        primaryStage.setTitle("CARD MATCH MEMORY GAME");
       
    
        
        //To be used for images....
        //FileInputStream cardBack = new FileInputStream("C:\\Users\\joshu\\eclipse-workspace\\CardMatchMemoryGame\\src\\PokemonCard.png");
        
        
    }
	
    //A method to show the card display, flipping functionality, equality checking and returning the proper results.
    private class Tile extends StackPane {

        private Text text = new Text();
        Rectangle border = new Rectangle(200, 200);

        //A method to show the initial display of the tiles and the border with different colors.
        //Positioning of the tiles and the font of the card value has also been set by this method.
        public Tile(String firstCard) {
            border.setStroke(Color.MEDIUMTURQUOISE);
            border.setFill(Color.BLACK);

            text.setText(firstCard);
            text.setFont(Font.font(100));
            text.setStroke(Color.MEDIUMTURQUOISE);

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(this::cardClickedByMouse);
            hideCard();
        }

        /*This method reads the MouseEvent and looks at the user clicks and performs what is necessary
         * in the code to check for equality between the two cards.
         * 
         * If the cards are equal then the cards will become the same color as to show equality.
         * If the cards are NOT equal then the cards will go back to its "flipping" mechanism.
         * 
         */
        public void cardClickedByMouse(MouseEvent event) {
            if (cardClicked() || numOfClicks == 0) {
            	return;
            }
            numOfClicks--;

            if (selected == null) {
                selected = this;
                showCard(() -> {});
            }
            else {
                showCard(() -> {
                    if (!equalCards(selected)) {
                        selected.hideCard();
                        this.hideCard();
                    }
                    else if (equalCards(selected)) {
                		selected.border.setFill(Color.MEDIUMTURQUOISE);
                		this.border.setFill(Color.MEDIUMTURQUOISE);
                    }
                    selected = null;
                    numOfClicks--;
                });
            }
        }

        //This method will check if the card is open and return the opacity to 1 to indicate that the card
        //has been opened as to show the user not to pick the same card again.
        public boolean cardClicked() {
            return text.getOpacity() == 1;
        }

        /*This method will fade the card to show it and runs the action to show the card to view it separately
         * from the background stroke color.
         */
        public void showCard(Runnable action) {
            FadeTransition flip = new FadeTransition(Duration.seconds(0.5), text);
            flip.setToValue(1);
            flip.setOnFinished(e -> action.run());
            flip.play();
        }

        //This method will close the card by performing a fade transition to hide the card
        public void hideCard() {
            FadeTransition ft = new FadeTransition(Duration.seconds(0.5), text);
            ft.setToValue(0);
            ft.play();
        }

        //This method checks if both the values of the text are the same. EQUALITY TO CHECK TO HIDE CARDS OR REVEL THEM.
        public boolean equalCards(Tile secondCard) {
            return text.getText().equals(secondCard.text.getText());
        }
    }
    
    public static void run() {
        
    	String filepath = ("C:\\Users\\Aaron\\eclipse-workspace\\CardMatchMemoryGame\\src\\loopmusicjavaupdated\\Poketheme.wav");
        musicStuff musicObject = new musicStuff();
        musicObject.playMusic(filepath);
    }

    /*This is called as the GUI.java class extends to the Application class in
     * java.fx so the launch(args) is also extended by the Application class.
     */
    public static void main(String[] args) {
    	run(); //runs the music from the other class. 
    	launch(args);
    	
    }
}