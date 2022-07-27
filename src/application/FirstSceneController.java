package application;
import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class FirstSceneController {
	Stage applicationStage;
	
    @FXML
    private TextField userNameTextField;

    @FXML
    private TextField userWeightTextField;

    @FXML
    private TextField userAgeTextField;

    @FXML
    private TextField userHeightTextField;

    @FXML
    private TextField userSexTextField;

    @FXML
    private ChoiceBox<String> goalChoiceBox;
    
    @FXML
    private Button firstSceneDone;
    
    @FXML
    private Label chooseNothingErrorLabel;

    @FXML
    /**
     * This method is for getting into new scene according to user's choice, he/she would have four choices;
     * activist,intermediate,beginner or blank. Blank would give user a message saying you can't choose nothing
     * for using this calculator. All other choices would jump to a new scene that fits the choice.
     * 
     * @param chooseActiveEvent parameter that indicates user picking active level of fitness.
     */
    void FirstSceneDoneButton(ActionEvent chooseActiveEvent) {
    	//user choice stored in this string for picking the right scene.
    	String userChoice = goalChoiceBox.getValue();    	
    	//setting a loader for all 3 choices.
    	FXMLLoader loader = new FXMLLoader();
    	
        //SecondScene secondAppliStage = new Stage();
    	//secondAppliStage = applicationStage;
    	
    	//try..catch method for possible error and 
    	try {
    	if(userChoice.equals("Gain weight!")) {
    	VBox root = loader.load(new FileInputStream("src/application/GainTracker.fxml"));
    	
    	//setting scene
    	Scene gainScene = new Scene(root,1000,1000);
    	
    	//setting stage
    	applicationStage.setTitle("Gain weight calories tracker");
    	applicationStage.setScene(gainScene);
    

    	}
    	else if(userChoice.equals("Lose weight!")) {
        	VBox root = loader.load(new FileInputStream("src/application/LoseTracker.fxml"));
        	
        	//setting scene
        	Scene loseScene = new Scene(root,1000,1000);
        	
        	//setting stage
        	applicationStage.setTitle("Lose weight calories tracker");
        	applicationStage.setScene(loseScene);
    	}
    	
    	else if(userChoice.equals("")){
    		chooseNothingErrorLabel.setText("You've picked nothing, please try again.");
    	}
    	} catch(IOException e) {
    		chooseNothingErrorLabel.setText("Your fxml file is missing, please make sure they are under src/application .");
    	}
    	
    }
}