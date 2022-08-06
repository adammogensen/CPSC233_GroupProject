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

public class GainerController {
	
	GainWeightGoal gainer = new GainWeightGoal();
	Stage applicationStage;
	
	
	@FXML
	private Label greetMsgLabel;

    @FXML
    private Button addActivityButton;

    @FXML
    private Button addMealButton;

    @FXML
    private Label gainerCarbHLabel;//set carbonHydrate value to this label

    @FXML
    private Label gainerFatsLabel;//set fat value to this label

    @FXML
    private Label gainerCalLabel;//set calories value to this label

    @FXML
    private Label gainerProteinLabel;//set protein value to this label
    
    private Label mealEnterErrorLabel;
    
    @FXML
    void gainerAddMeal(ActionEvent addMealEvent) {
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
    void gainerAddActivity(ActionEvent event) {
    	gainerCalLabel.setText(String.valueOf(gainer.getAge()));//checking if data get parsed.

    }
    

    void setGreetingMsg() {
    	if(greetMsgLabel==null);
    	else {
    	greetMsgLabel.setText("Hello " + gainer.getName() +",\nYour body datas are displayed on the right side:");
    }
    }
}

