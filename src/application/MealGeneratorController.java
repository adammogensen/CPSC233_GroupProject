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
import javafx.scene.paint.Color;

public class MealGeneratorController {
	
	User appUser = new User();
	Stage applicationStage;
	int breakfastCals = 0;
	int lunchCals = 0;
	int dinnerCals = 0;
	
	
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
    
    @FXML
    private Label dailyCalLabel;
   
    @FXML
    private Label bfMealLabel;
    
    @FXML
    private Label lunchMealLabel;
    
    @FXML
    private Label dinnerMealLabel;
    
    @FXML
    private Label mealTotalCalLabel;
    
    @FXML
    private Label mealEnterErrorLabel;
    
    @FXML
    private Button generateBFButton;
    
    @FXML
    private Button regenBFButton;
    
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
    private TextField dinnerCalTextField;
    
    @FXML
    private TextField snackCalTextField;
    
    @FXML
    private Label snackEnterLabel;
    
    @FXML
    private VBox bFVBox;
    
    @FXML
    private VBox lunchVBox;
    
    @FXML
    private VBox dinnerVBox;

    @FXML
    void userGenerateBF(ActionEvent addMealEvent) {
    	Label mealName = new Label ("Breakfast");
    	//New Meal object based on calorie goal input
    	Meal breakfast = new Meal("Breakfast", Integer.parseInt(bFCalTextField.getText()));
		breakfast.generateMeal();
		bFVBox.getChildren().add(mealName);
		
		//Display food name and calories in an HBox for each food generated in the meal.
    	for (Food f: breakfast.getFoodInMeal()) {
    		HBox rows = new HBox();
    		Label foodName = new Label("Food: " + f.getNameOfFood());
    		Label foodCals = new Label("\t Calories: " + String.valueOf(f.getCaloriesPerServing()));
    		rows.getChildren().addAll(foodName, foodCals);	
    		bFVBox.getChildren().add(rows);
    		breakfastCals += f.getCaloriesPerServing();
    	}
    	Label totalCalsLabel = new Label("Total Meal Calories: " + String.valueOf(breakfastCals));
    	bFVBox.getChildren().add(totalCalsLabel);
    	
    	//Set to false to encourage user to use the regenerate button
    	generateBFButton.setVisible(false);
    	//Adding calories from meal to the daily total
    	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()+ breakfastCals)));
    	}
    	
    
    
    @FXML
    void userRegenBF(ActionEvent event) {

    	//Reset the value/items in the VBox of the previous meal
    	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText())- breakfastCals));
    	breakfastCals = 0;
    	bFVBox.getChildren().clear();
    	
    	Label mealName = new Label ("Breakfast");
    	bFVBox.getChildren().add(mealName);
    	Meal breakfast = new Meal("Breakfast", Integer.parseInt(bFCalTextField.getText()));
    	breakfast.getFoodInMeal().clear();
		breakfast.generateMeal();
    	
    	for (Food f: breakfast.getFoodInMeal()) {
    		HBox rows = new HBox();
    		Label foodName = new Label("Food: " + f.getNameOfFood());
    		Label foodCals = new Label("\t Calories: " + String.valueOf(f.getCaloriesPerServing()));
    		rows.getChildren().addAll(foodName, foodCals);	
    		bFVBox.getChildren().add(rows);
    		breakfastCals += f.getCaloriesPerServing();
    	}
    	
    	Label totalCalsLabel = new Label("Total Meal Calories: " + String.valueOf(breakfastCals));
    	bFVBox.getChildren().add(totalCalsLabel);
    	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) + breakfastCals));

    }
    
  
    

    @FXML
    void userGenerateLunch(ActionEvent event) {
    	Label mealName = new Label ("Meal 2");
    	//New Meal object based on calorie goal input
    	Meal lunch = new Meal("Meal 2", Integer.parseInt(lunchCalTextField.getText()));
		lunch.generateMeal();
		lunchVBox.getChildren().add(mealName);
		
		//Display food name and calories in an HBox for each food generated in the meal.
    	for (Food f: lunch.getFoodInMeal()) {
    		HBox rows = new HBox();
    		Label foodName = new Label("Food: " + f.getNameOfFood());
    		Label foodCals = new Label("\t Calories: " + String.valueOf(f.getCaloriesPerServing()));
    		rows.getChildren().addAll(foodName, foodCals);	
    		lunchVBox.getChildren().add(rows);
    		lunchCals += f.getCaloriesPerServing();
    	}
    	Label totalCalsLabel = new Label("Total Meal Calories: " + String.valueOf(lunchCals));
    	lunchVBox.getChildren().add(totalCalsLabel);
    	
    	//Set to false to encourage user to use the regenerate button
    	generateLunchButton.setVisible(false);
    	//Adding calories from meal to the daily total
    	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) + lunchCals));
    }
    
    @FXML
    void userRegenLunch(ActionEvent regenLunch) {
    	//Reset the value/items in the VBox of the previous meal
    	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) - lunchCals));
    	lunchCals = 0;
    	lunchVBox.getChildren().clear();
    	
    	Label mealName = new Label ("Meal 2");
    	lunchVBox.getChildren().add(mealName);
    	Meal lunch = new Meal("Meal 2", Integer.parseInt(lunchCalTextField.getText()));
    	lunch.getFoodInMeal().clear();
		lunch.generateMeal();
    	
    	for (Food f: lunch.getFoodInMeal()) {
    		HBox rows = new HBox();
    		Label foodName = new Label("Food: " + f.getNameOfFood());
    		Label foodCals = new Label("\t Calories: " + String.valueOf(f.getCaloriesPerServing()));
    		rows.getChildren().addAll(foodName, foodCals);	
    		lunchVBox.getChildren().add(rows);
    		lunchCals += f.getCaloriesPerServing();
    	}
    	
    	Label totalCalsLabel = new Label("Total Meal Calories: " + String.valueOf(lunchCals));
    	lunchVBox.getChildren().add(totalCalsLabel);
    	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) + lunchCals));

    }
    
    @FXML
    void userGenerateDinner(ActionEvent event) {
    	Label mealName = new Label ("Meal 3");
    	//New Meal object based on calorie goal input
    	Meal dinner = new Meal("Meal 3", Integer.parseInt(dinnerCalTextField.getText()));
		dinner.generateMeal();
		dinnerVBox.getChildren().add(mealName);
		
		//Display food name and calories in an HBox for each food generated in the meal.
    	for (Food f: dinner.getFoodInMeal()) {
    		HBox rows = new HBox();
    		Label foodName = new Label("Food: " + f.getNameOfFood());
    		Label foodCals = new Label("\t Calories: " + String.valueOf(f.getCaloriesPerServing()));
    		rows.getChildren().addAll(foodName, foodCals);	
    		dinnerVBox.getChildren().add(rows);
    		dinnerCals += f.getCaloriesPerServing();
    	}
    	Label totalCalsLabel = new Label("Total Meal Calories: " + String.valueOf(dinnerCals));
    	dinnerVBox.getChildren().add(totalCalsLabel);
    	
    	//Set to false to encourage user to use the regenerate button
    	generateDinnerButton.setVisible(false);
    	//Adding calories from meal to the daily total
    	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) + dinnerCals));
    }

    @FXML
    void userRegenDinner(ActionEvent event) {
    	//Reset the value/items in the VBox of the previous meal
    	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) - dinnerCals));
    	dinnerCals = 0;
    	dinnerVBox.getChildren().clear();
    	
    	Label mealName = new Label ("Meal 3");
    	dinnerVBox.getChildren().add(mealName);
    	Meal dinner = new Meal("Meal 3", Integer.parseInt(dinnerCalTextField.getText()));
    	dinner.getFoodInMeal().clear();
		dinner.generateMeal();
    	
    	for (Food f: dinner.getFoodInMeal()) {
    		HBox rows = new HBox();
    		Label foodName = new Label("Food: " + f.getNameOfFood());
    		Label foodCals = new Label("\t Calories: " + String.valueOf(f.getCaloriesPerServing()));
    		rows.getChildren().addAll(foodName, foodCals);	
    		dinnerVBox.getChildren().add(rows);
    		dinnerCals += f.getCaloriesPerServing();
    	}
    	
    	Label totalCalsLabel = new Label("Total Meal Calories: " + String.valueOf(dinnerCals));
    	dinnerVBox.getChildren().add(totalCalsLabel);
    	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) + dinnerCals));
    }


    @FXML
    void userAddSnack(ActionEvent event) {

        mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText())+ Integer.parseInt(snackCalTextField.getText())));
    	snackEnterLabel.setText(snackCalTextField.getText() + " Calories added to your total.");

}
    void setCalLabel() {
    	mealTotalCalLabel.setText("0");
    }


    void setGreetingMsg() {
    	if(greetMsgLabel==null);
    	else {

        	greetMsgLabel.setText("Hello " + appUser.getName() +",\nYour body data is displayed on the right:\nYou can generate"
        			+ " 3 different meals by stating designated\ncalories per meal then pressing the generate Breakfast\n"
        			+ "/Lunch/Dinner below. Also you can always re-generate a meal\n if you are unhappy with the generated\n meal."
        			+ " You can also add a custom snack by \n entering its calories. Total calories consumed are stored\n"
        			+ "on the right. Please enter calories with respect to your\n goal (Gaining weight or Losing weight) "
        			+ "and Enjoy the App!");
    	}
    }
    
    /**
    * This method is used for setting user-inputed name into Meal generator Scene.
    */
   void setName() {
       nameLabel.setText(appUser.getName());
   }

   /**
    * This method is used for setting user-inputed age into Meal generator Scene.
    */
   void setAge() {
       ageLabel.setText(String.valueOf(appUser.getAge()));
   }

   /**
    * This method is used for setting user-inputed sex into Meal generator Scene.
    */
   void setSex() {
       if(appUser.isMale()) {;
       sexLabel.setText("Male");
       }
       else
           sexLabel.setText("Female");
   }

   /**
    * This method is used for setting user-inputed height into Meal generator Scene.
    */
   void setHeight() {
       heightLabel.setText(String.valueOf(appUser.getHeight())+" cm");
   }

   /**
    * This method is used for setting user-inputed Weight into Meal generator Scene.
    */
   void setWeight() {
       weightLabel.setText(String.valueOf(appUser.getWeight())+" Kg");
   }

   /**
    * This method is used for setting daily recommended calories into Meal generator Scene
    * according to user-inputed body data.
    */
   void setDailyRecomCalroies() {
       dailyCalLabel.setText(String.valueOf(appUser.calculateDailyCalories(appUser.getAge(),appUser.getHeight(), appUser.getWeight())));
   }

   /**
    * This method is used for setting BMI indication using user-inputed data.
    */
   void setBMI() {
       bMILabel.setText(appUser.getBMI(appUser.getHeight(), appUser.getWeight()));
   }
   
   String caloryError() {
	   String error = "Error:Calories must be between 0 and 1000(doesn't include 0).";
	   return error;
   }
   
   String noEntryError(String mealName) {
	   String error = "Error: Can't generate " + mealName +" without a calories entry.";
	   return error;
   }
   
   String entryNotIntError() {
	  String error =  "Error: Can't generate a Meal with non-integer value.";
	  return error;
   }
}

