package application;

import javafx.stage.Stage;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GainerController {

	Stage applicationStage;

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
    
    
    /**
     * This method is called when pressing the 'done' button in the 'Add Activity' screen.
     * It creates a new activity object and assigns it the intensity and duration values
     * that were inputted by the user.
     * @param intensity - from actIntenseChoiceBox
     * @param time - from actDurationTextField
     * @param homeScreen - stored main calorie tracker scene
     */
    @FXML
    void activitySceneGetData(String intensity, String time, Scene homeScreen, Label error) {
    
    	if (!intensity.equals("Select an Intensity") && !time.equals(null)) {
    		int timeInt = Integer.parseInt(time);
    	
	    	Activity addActivity = new Activity();
	    	
	    	if(intensity.equals("Low Intensity")) {
	    		addActivity.setLow();
	    	}
	    	else if(intensity.equals("Medium Intensity")) {
	    		addActivity.setMedium();
	    	}
	    	else if(intensity.equals("High Intensity")) {
	    		addActivity.setHigh();
	    	}
	    	addActivity.setDuration(timeInt);
	    	
	    	System.out.print(addActivity.getDuration());
	    	System.out.print(addActivity.isHigh());
	    	applicationStage.setScene(homeScreen);
    	}
    	else {
    		error.setText("Please select an Intensity and enter a Duration");
    	}
    }

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
    	//new Scene to retrieve old scene
    	Scene mainScene = applicationStage.getScene();
    	
    	//new VBox container and elements within
    	VBox addActivityBox = new VBox(10);
    	
    	Label title = new Label ("Add an Activity");
    	
    	HBox activityIntensity = new HBox();
    	Label actIntenseLabel = new Label ("Select an Activity Intensity: ");
    	ChoiceBox <String> actIntenseChoiceBox = new ChoiceBox <String> ();
    	actIntenseChoiceBox.setValue("Select an Intensity");
    	ObservableList <String> choiceBoxItems = actIntenseChoiceBox.getItems();
    	choiceBoxItems.add("Low Intensity");
    	choiceBoxItems.add("Medium Intensity");
    	choiceBoxItems.add("High Intensity");
    	    	
    	activityIntensity.getChildren().addAll(actIntenseLabel, actIntenseChoiceBox);
    	
    	HBox activityDuration = new HBox();
    	Label actDurationLabel = new Label ("Duration of Activity (minutes)");
    	TextField actDurationTextField = new TextField();
    	activityDuration.getChildren().addAll(actDurationLabel, actDurationTextField);
    	
    	Label errorLabel = new Label();
    	
    	Button activityDoneButton = new Button ("Done");
    	
    	activityDoneButton.setOnAction(doneEvent -> activitySceneGetData(actIntenseChoiceBox.getValue(), actDurationTextField.getText(), mainScene, errorLabel));
    		
    	//activityDoneButton.setOnAction(doneEvent -> errorLabel.setText("Select an Intensity and enter a Duration"));
    	addActivityBox.getChildren().addAll(title, activityIntensity, activityDuration, activityDoneButton, errorLabel);
    	
    	//Set scene to VBox scene
    	Scene activityScene = new Scene(addActivityBox);
    	applicationStage.setScene(activityScene);

    }

}

