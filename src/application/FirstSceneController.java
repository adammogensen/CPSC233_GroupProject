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
	boolean isEmpty = true;
	boolean fileFoundFlag = false;

	
	
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
    private ChoiceBox<String> userSexChoiceBox;
    
    @FXML
    private Button firstSceneDone;
    
    @FXML
    private Label fileMissingErrorLabel;
    
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
    	//setting a loader for all 3 choices.
    	FXMLLoader loader = new FXMLLoader();
    	

    	
        //SecondScene secondAppliStage = new Stage();
    	//secondAppliStage = applicationStage;
    	
    	//try..catch method for possible error 
    	try {
    	   
    	VBox root = loader.load(new FileInputStream("src/application/MealGeneratorTracker.fxml"));
		MealGeneratorController mealGenController = (MealGeneratorController)loader.getController();
		mealGenController.applicationStage = applicationStage;//connect gainControllerStage to primary stage.
		storeUserData(mealGenController.gainer);
		mealGenController.setGreetingMsg();
    	
    	//setting stage and scene
    	if(isEmpty) {
    		fileMissingErrorLabel.setText("You need to enter all required data!");
    	    return;
    	}
    	else if(!isValidInput)
    		return;
    	else{
        Scene MealGenScene = new Scene(root,800,800);
    	applicationStage.setTitle("Meal Generator");
    	applicationStage.setScene(MealGenScene);
    	}

    	
    	}
    	catch(IOException e) {
        	fileMissingErrorLabel.setText("Your fxml file is missing, please make sure they are under src/application .");    	
        	}
    }
    
    void storeUserData(User u) {
    	
    	isValidInput = true;
    	isEmpty = true;


    	//name
    	if(userNameTextField.getText().equals("")) {
        	nameError.setText("You need to enter a name.");
        	isValidInput = false;
    	}
    	else {
        	nameError.setText("");
        	isEmpty = false;
    		u.setName(userNameTextField.getText());
    	}
    	
    	//age
    	if(!isInt(userAgeTextField.getText())) {
    		ageError.setText(getError());
    		isValidInput = false;
    	}
    	else if(userAgeTextField.getText()==null) {
    		ageError.setText(getError());
        	isValidInput = false;
    	}
    	else {
    		ageError.setText("");
    		isEmpty = false;
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
    		isEmpty = false;
    		u.setMale(true);
    		
    	}
    	else {
    		sexError.setText("");
    		isEmpty = false;
    		u.setMale(false);
    	}
    	
    	
    	//weight
    	if(!isDouble(userWeightTextField.getText())) {
    		weightError.setText(getError());
        	isValidInput = false;
    	}
    	else if(userWeightTextField.getText()==null) {
    		isValidInput = false;
    	}
    	else {
    		weightError.setText("");
    		isEmpty = false;
        	u.setWeight(Double.parseDouble(userWeightTextField.getText()));
    	}
    	
    	//height
    	if(!isDouble(userHeightTextField.getText())) {
    		heightError.setText(getError());
        	isValidInput = false;
    	}
    	else if(userHeightTextField.getText()==null) {
    		isValidInput = false;
    	}
    	else {
    		heightError.setText("");
    		isEmpty = false;
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
