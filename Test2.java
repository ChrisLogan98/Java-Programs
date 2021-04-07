/* Jennifer Dust
 * 2/20/18
 * Test 2 - This is an application that reads in a file, then sorts based on 
 * the amount bid for a searched item
 * 
 * Modified By:
 * Date:
 */
package test2;

//Required imports
import java.io.IOException;
import java.util.*;
import java.util.logging.*;
import javafx.application.Application;
import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Test2 extends Application  {
     
    @Override
    public void start(Stage primaryStage){
        
         //Create BorderPane
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10, 20, 10, 20));
        
        //Create VBox to hold item and labels
        VBox topBox = new VBox(10);
       
        //HBox to hold items shown
        HBox itemBox = new HBox(20);
        itemBox.setAlignment(Pos.CENTER);
        
        //Formating text
        Label itemLabel = new Label("Item:");
        TextField listedItem = new TextField ();
            
        //Display buttons
        itemBox.getChildren().addAll(itemLabel,listedItem);
        
        //Second HBox to hold titles
        HBox labelBox = new HBox(30);
        labelBox.setAlignment(Pos.TOP_CENTER);

        //Who is the bidder label
        Text names = new Text();
        names.setText("Bidder");
        
        //What is the amount label
        Text bidAmmount = new Text();
        bidAmmount.setText("Amount bid");

        //Add Names and amount bid to label box
        labelBox.getChildren().add(names);
        labelBox.getChildren().add(bidAmmount);
        
        //Add label box and item box to top HBox
        topBox.getChildren().add(itemBox);
        topBox.getChildren().add(labelBox);
     
        //Add text to top of Borderpane
        root.setTop(topBox);
        
        //Search Button
        Button searchBtn = new Button();
        searchBtn.setText("Search");
        //searchBtn.setOnAction(new searchInput());
        
        //Button handler for search button
        //SEARCH BUTTON - TEST 2
        //YOU MUST FILL IN THE MISSING METHODS, STATEMENTS, AND DISPLAY
        //SEE EXAMPLE FORMAT IN PAPER
        searchBtn.setOnAction((ActionEvent event) -> {
            //Try to read in given file
            try {
                //Create a list to hold given searched data for display
                ArrayList<Bidder> searchingList;
                
                //Create Sorting object to be utilized
                Sorting givenData = new Sorting();
                
                //Call method to read in file
                givenData.readFile();
                
                //Get searched text from user input
                String checkInput = listedItem.getText();
                
                //Removes all non-character symbols, convert to lower case
                checkInput = checkInput.toLowerCase().replaceAll("[^A-Za-z]+", "");
                
                //Populate item list in Sorting Class
                givenData.search(checkInput);
                
                //Sort the determined list
                searchingList = givenData.sortList();
                
                //Create and format a gridpane for display view
                GridPane gridPane = new GridPane();                
                
                //Create LEFT SIDE vertical box for NAMES
                VBox lvbox = new VBox(10);
                primaryStage.setScene(new Scene(gridPane));
                primaryStage.show();
                
                //Add sorted list to the display
                
                
                //Create RIGHT SIDE vertical box for BIDS
                VBox rvbox = new VBox(10);
                primaryStage.setScene(new Scene(gridPane));
                primaryStage.show();
                
                //Add sorted list to the display
                
                
                //Add both names and bid list to the grid
              
                
                //Add grid to center of Borderpane
                gridPane.setAlignment(Pos.CENTER);
               
            } 
            //If file fails display custom error message in the console
            //MODIFY THIS TO CREATE YOUR OWN ERROR MESSAGE FOR THE USER
            catch (IOException ex) {
                Logger.getLogger(Test2.class.getName()).log(Level.SEVERE, null, ex);                
            }
        });
                
        
        //Close Button
        Button closeBtn = new Button();
        closeBtn.setText("Close");
        closeBtn.setOnAction(new closeProgram());
        
        //HBox to hold buttons
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        
        //Display buttons
        buttonBox.getChildren().add(searchBtn);
        buttonBox.getChildren().add(closeBtn);
        
        //Add buttons to bottom of Borderpane
        root.setBottom(buttonBox);        
        
        //Create scene
        Scene scene = new Scene(root, 300, 400);
        
        //Set title and stage
        //ADD YOUR NAME TO THE TITLE 
        primaryStage.setTitle("Test 2 By: Chris Logan ");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Main method
    public static void main(String[] args) {
        launch(args);
    }
    
   
   //Button Handler class to close the program
   class closeProgram implements EventHandler<ActionEvent>
   {
       @Override
      public void handle(ActionEvent event)
      {
          //Close the program
          System.exit(0);
      }
   }
         
}
