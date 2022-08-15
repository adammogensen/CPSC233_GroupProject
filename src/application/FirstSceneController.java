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

/**
 * This method is used for controller the first scene interacting with the user, it would store user-entered data and 
 * passing data into next scene if user-entered data are all valid.It would output error message depending on different
 * errors user had made.
 * 
 * @author Haoping(Ryan) Zheng, Adam Mogenson
 *
 */
public class FirstSceneController {
	//setting up variables
	Stage applicationStage;
	private String errorMessage;
	private boolean isValidInput = true;
	private boolean isEmpty = true;

	
	//setting up interactive parts created in FXML
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
     * This method is for getting into the meal generator scene, press this button would collect user-entered data
     * and parse it to the meal generator scene.
     * 
     * @param collectDataEvent parameter that indicates the button is interacting with
     * an action of collecting user data .
     */
    void firstSceneDoneButton(ActionEvent collectDataEvent) {
    	FXMLLoader loader = new FXMLLoader();
    	//try..catch method for possible error 
    	try {
    	//setting up data and root for meal generator scene.
    	VBox root = loader.load(new FileInputStream("src/application/MealGeneratorTracker.fxml"));
		MealGeneratorController mealGenController = (MealGeneratorController)loader.getController();
		mealGenController.applicationStage = applicationStage;//connect gainControllerStage to primary stage.
		storeUserData(mealGenController.getUser());
		mealGenController.setGreetingMsg();
		mealGenController.setCalLabel();
		mealGenController.setName();
        mealGenController.setAge();
        mealGenController.setSex();
        mealGenController.setHeight();
        mealGenController.setWeight();
        mealGenController.setDailyRecomCalories();
        mealGenController.setBMI();
        
        //error when user entered nothing.
    	if(isEmpty) {
    		fileMissingErrorLabel.setText("You need to enter all required data!");
    	    return;
    	}
    	//error when user entered invalid value.
    	else if(!isValidInput)
    		return;
    	else{
        Scene MealGenScene = new Scene(root,950,1000);
    	applicationStage.setTitle("Meal Generator");
    	applicationStage.setScene(MealGenScene);
    	}
    	}
    	catch(IOException e) {
        	fileMissingErrorLabel.setText("Your fxml file is missing, please make sure they are under src/application .");    	
        	}
    }
    
    /**
     * This method is used for storing user-entered data into given class user parameter. It would also
     * check if user entered valid entry or empty entry and set the correct error messages with respect to 
     * user entries.
     * 
     * @param u This class User parameter is used for storing user-entered data.
     */
    void storeUserData(User u) {
    	isValidInput = true;
    	isEmpty = true;
    	
    	//setting name with error handling.
    	if(userNameTextField.getText().equals("")) {
        	nameError.setText(noEntryError());
        	isValidInput = false;
    	}
    	else {
        	nameError.setText("");
        	isEmpty = false;
    		u.setName(userNameTextField.getText());
    	}
    	//setting age with error handling. 
    	if(userAgeTextField.getText().isEmpty()) {
    		ageError.setText(noEntryError());
        	isValidInput = false;
    	}
    	else if(!isInt(userAgeTextField.getText())) {
    		ageError.setText(getError());
    		isValidInput = false;
    	}
    	else {
    		ageError.setText("");
    		isEmpty = false;
        	u.setAge(Integer.parseInt(userAgeTextField.getText()));
    	}
    	//setting sex with error handling.
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
    	//setting weight with error handling.
    	if(userWeightTextField.getText().isEmpty()) {
    		weightError.setText(noEntryError());    	
    		isValidInput = false;
    	}
    	else if(!isDouble(userWeightTextField.getText())) {
    		weightError.setText(getError());
        	isValidInput = false;
    	}
    	else {
    		weightError.setText("");
    		isEmpty = false;
        	u.setWeight(Double.parseDouble(userWeightTextField.getText()));
    	}
    	
    	//Setting height with error handling.
    	if(userHeightTextField.getText().isEmpty()) {
    		heightError.setText(noEntryError());
    		isValidInput = false;
    	}
    	else if(!isDouble(userHeightTextField.getText())) {
    		heightError.setText(getError());
        	isValidInput = false;
    	}
    	else {
    		heightError.setText("");
    		isEmpty = false;
        	u.setHeight(Double.parseDouble(userHeightTextField.getText()));
    	}
    }

    /**
     * This method is to check if user-entry is an integer or not.
     * 
     * @param str A string parameter that is getting checked by this method.
     * @return return true if str passed test,false when str doesn't.
     */
    boolean isInt(String str) {
    	try {
    		Integer.parseInt(str);
    		return true;
    		
    	}
    	catch(NumberFormatException e) {
    		return false;
    	}
    }
    
    /**
     * This method is to check if user-entry is a double or not.
     * 
     * @param str A string parameter that is getting checked by this method.
     * @return return true if str passed test,false when str doesn't.
     */	
   boolean isDouble(String str) {
	try {
		Double.parseDouble(str);
		return true;
		
	}
	catch(NumberFormatException e) {
		return false;
	}
  }
    
   /**
    * This method is used for setting error message when user's entry doesn't pass 
    * an integer/double test.
    * 
    * @return An error message that tell user they've entered invalid value and try again.
    */
    String getError() {
    	errorMessage = "Error: Please enter an Integer/real number and try again.";    	
    	return errorMessage;
    }
 
    /**
     * This method is used for setting error message when user left the text field blank 
     * or they entered/chose nothing.
     * 
     * @return An error message that tell user they've entered nothing.
     */
    String noEntryError() {
    	String error = "Error: Nothing is entered.";
    	return error;
    }
    }//end class
