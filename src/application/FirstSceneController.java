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
	String errorMessage;
	boolean isValidInput = true;

	
	
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
    private ChoiceBox<String> userSexChoiceBox;
    
    @FXML
    private Button firstSceneDone;
    
    @FXML
    private Label chooseNothingErrorLabel;
    
    @FXML
    private Label nameError;

    @FXML
    private Label sexError;

    @FXML
    private Label ageError;
    
    @FXML
    private Label heightError;
    
    @FXML
    private Label weightError;

    @FXML
    /**
     * This method is for getting into new scene according to user's choice, he/she would have four choices;
     * activist,intermediate,beginner or blank. Blank would give user a message saying you can't choose nothing
     * for using this calculator. All other choices would jump to a new scene that fits the choice.
     * 
     * @param chooseActiveEvent parameter that indicates user picking active level of fitness.
     */
    void firstSceneDoneButton(ActionEvent chooseActiveEvent) {
    	//user choice stored in this string for picking the right scene.
    	String userChoice = goalChoiceBox.getValue();    	
    	//setting a loader for all 3 choices.
    	FXMLLoader loader = new FXMLLoader();
    	

    	
        //SecondScene secondAppliStage = new Stage();
    	//secondAppliStage = applicationStage;
    	
    	//try..catch method for possible error and 
    	try {
    	   if(userChoice==null) {
    			chooseNothingErrorLabel.setText("You've picked nothing, please try again.");
        	}
    	   
    	else if(userChoice.equals("Gain weight!")) {
    		
    		//connecting first stage with the second stage, so we could do further scene-changing.
    	VBox root = loader.load(new FileInputStream("src/application/GainTracker.fxml"));
		GainerController gainController = (GainerController)loader.getController();
		gainController.applicationStage = applicationStage;//connect gainControllerStage to primary stage.
		storeUserData(gainController.gainer);
    	
    	//setting stage
    	if(!isValidInput) 
    	return;
    	else{
        Scene gainScene = new Scene(root,800,800);
    	applicationStage.setTitle("Gain weight calories tracker");
    	applicationStage.setScene(gainScene);
    	}

    	}
    	
    	else if(userChoice.equals("Lose weight!")) {
        	VBox root = loader.load(new FileInputStream("src/application/LoseTracker.fxml"));
    		LoseController loseController = (LoseController)loader.getController();
    		loseController.applicationStage = applicationStage;
    		
    		
    		storeUserData(loseController.loser);
    		
        	//setting scene
        	Scene loseScene = new Scene(root,800,800);
        	
        	//setting stage
        	if(isValidInput) {
        	applicationStage.setTitle("Lose weight calories tracker");
        	applicationStage.setScene(loseScene);
    	}
    	}

		else if(userChoice.equals("")) {
			chooseNothingErrorLabel.setText("You've picked nothing, please try again.");
		}
    	} catch(IOException e) {
    		chooseNothingErrorLabel.setText("Your fxml file is missing, please make sure they are under src/application .");
    	}
    	
    }
    
    void storeUserData(User u) {
    	
    	isValidInput = true;



    	//name
    	if(userNameTextField.getText().equals("")) {
        	nameError.setText("You need to enter a name.");
        	isValidInput = false;
    	}
    	else {
        	nameError.setText("");
    		u.setName(userNameTextField.getText());
    	}
    	
    	//age
    	if(!isInt(userAgeTextField.getText())) {
    		ageError.setText(getError());
    		isValidInput = false;
    	}
    	else {
    		ageError.setText("");
        	u.setAge(Integer.parseInt(userAgeTextField.getText()));
    	}
    	
    	//sex
    	if(userSexChoiceBox.getValue()==null) {
    		sexError.setText("You can't chose nothing for sex.Please try again.");
        	isValidInput = false;
    	}
    	else if(userSexChoiceBox.getValue().equals("")){
    		sexError.setText("You can't chose nothing for sex.Please try again.");
        	isValidInput = false;
    	}
    	else if(userSexChoiceBox.getValue().equals("Male")) {
    		sexError.setText("");
    		u.setMale(true);
    		
    	}
    	else {
    		sexError.setText("");
    		u.setMale(false);
    	}
    	
    	
    	//weight
    	if(!isDouble(userWeightTextField.getText())) {
    		weightError.setText(getError());
        	isValidInput = false;
    	}
    	else {
    		weightError.setText("");
        	u.setWeight(Double.parseDouble(userWeightTextField.getText()));
    	}
    	
    	//height
    	if(!isDouble(userHeightTextField.getText())) {
    		heightError.setText(getError());
        	isValidInput = false;
    	}
    	else {
    		heightError.setText("");
        	u.setHeight(Double.parseDouble(userHeightTextField.getText()));
    	}
    	
    	

    	    	

    	
    
    }
    	
    boolean isInt(String str) {
    	try {
    		Integer.parseInt(str);
    		return true;
    		
    	}
    	catch(NumberFormatException e) {
    		return false;
    	}
    }
    
	
   boolean isDouble(String str) {
	try {
		Double.parseDouble(str);
		return true;
		
	}
	catch(NumberFormatException e) {
		return false;
	}
  }
    
    String getError() {

    		errorMessage = "Error:Please enter an Integer/real number and try again.";
    	
    	
    	return errorMessage;
    }
    	
    }
