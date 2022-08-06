package application;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MealGeneratorController {
	
	User gainer = new User();
	Stage applicationStage;
	
	
	@FXML
	private Label greetMsgLabel;
    
    @FXML
    private Label heightLabel;

    @FXML
    private Label sexLabel;

    @FXML
    private Label bMRLabel;
    
    @FXML
    private Label weightLabel;

    @FXML
    private Label bMILabel;
    
    @FXML
    private Label ageLabel;
    
    @FXML
    private Label nameLabel;
  
    private Label mealEnterErrorLabel;
    


    @FXML
    private Button generateBFButton;
    
    @FXML
    private Button reGenerateBFButton;
    
    @FXML
    private Button generateLunchButton;
    
    @FXML
    private Button regenLunchButton;
    
    @FXML
    private Button generateDinnerButton;

    @FXML
    private Button regenDinnerButton;
    
    @FXML
    private Button addSnackButton;

    

    @FXML
    private TextField bFCalTextField;
    
    @FXML
    private TextField lunchCalTextField;
    
    @FXML
    private TextField snackCalTextField;

    @FXML
    private TextField dinnerCalTextField;

    










    //ignore the methods, feel free to replace it with right methods.
    
    @FXML
    void userGenerateBF(ActionEvent addMealEvent) {
    	Scene mainScene = applicationStage.getScene();//mainScene, which is the gainerScene.
    	Scene addMealScene;
    	VBox mealFoodHolder = new VBox(10);
    	HBox mealHolder = new HBox(10);
    	HBox foodHolder = new HBox(10);

    	//attributes for mealHolder
    	Label mealName = new Label("Name of Meal:");
    	TextField mealNameTextField = new TextField();
    	Button addMeal = new Button("Add meal!");
    	boolean mealFlag = false;//flag used for when user pressed done. 
    	
    	//attributes for foodHolder;
    	
    	mealEnterErrorLabel = new Label();
    	mealEnterErrorLabel.setText("");
    	
    	mealHolder.getChildren().addAll(mealName,mealNameTextField,addMeal);
    	mealHolder.setPadding(new Insets(20));
    	mealHolder.setPrefHeight(70);
    	mealFoodHolder.getChildren().addAll(mealHolder,mealEnterErrorLabel);
    	
    	//while(!mealFlag) {
    		
    	//}
    	
    	
    	addMealScene = new Scene(mealFoodHolder,800,800);
    	applicationStage.setTitle("Add meal");
    	applicationStage.setScene(addMealScene);

    }
    
    
    @FXML
    void userRegenBF(ActionEvent event) {

    }

    @FXML
    void userGenerateLunch(ActionEvent event) {
    	
    }
    
    @FXML
    void userRegenLunch(ActionEvent regenLunch) {
    	
    }
    
    @FXML
    void userGenerateDinner(ActionEvent event) {

    }

    @FXML
    void userRegenDinner(ActionEvent event) {

    }


    @FXML
    void userAddSnack(ActionEvent event) {

    }

    

    void setGreetingMsg() {
    	if(greetMsgLabel==null);
    	else {
    	greetMsgLabel.setText("Hello " + gainer.getName() +",\nYour body data are displayed on the right:\nYou can generate"
    			+ " 3 different meals by stating designated\ncalories per meal then pressing the generate breakfast\n"
    			+ "/lunch/supper below. Also you could always re-generate a meal\n if you are discontented with given meal."
    			+ "\nSame with adding snack, by entering snacks calories,\nit would be stored on total calories consumed on the right.\n"
    			+ "Please enter calories with respect to your goal\n(gaining weight or losing weight)and enjoy the app!");
    }
    }
}

