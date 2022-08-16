package application;

import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
/**
 * This class is used as a controller of meal generator Scene, it would parse data entered by user from
 * previous scene and implements them in the correct place of the UI, it contains method used for generate/regenerate
 * different meals also add snack that will interact with user entered data(between 100 and 1000).It would display 
 * different error message when user made either invalid entry or entered nothing.
 * 
 * @author Haoping(Ryan) Zheng, Adam Mogenson, Mun Seok Suh
 *
 */
public class MealGeneratorController {
	
	//setting up instance variables and object used in this class.
	private User appUser = new User();
	Stage applicationStage;
	private int breakfastCals = 0;
	private int lunchCals = 0;
	private int dinnerCals = 0;
	
    //setting up interactive parts created in FXML
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

    
    /**
     * This method is used to generate a Breakfast meal, with respect to user-entered calories. It creates a
     * number of HBoxes relative to the number of food objects generated in the meal and adds them to the VBox
     * then displays the total calories of the meal. Then it updates the Daily Calorie Counter.
     * It also sets an error message when user entered invalid entry.
     * 
     * @param bFGenEvent event that represents a breakfast-generated event.
     */
    @FXML
    void userGenerateBF(ActionEvent bFGenEvent) {
    	//Try...catch method to check if user entry is an integer.
        try {
            //Check if user entered nothing.
        	if(bFCalTextField.getText().isEmpty()){
        		bFVBox.getChildren().clear();
        		Label error = new Label(noEntryError("breakfast"));
        		error.setTextFill(Color.RED);
        		bFVBox.getChildren().add(error);
        		}
        	//Check if user-entered data is in the range between 100 and 1000.
        	else if(Integer.parseInt(bFCalTextField.getText())>1000||Integer.parseInt(bFCalTextField.getText())<=100) {
        		bFVBox.getChildren().clear();
        		Label error = new Label(caloryError());
        		error.setTextFill(Color.RED);
        		bFVBox.getChildren().add(error);
        		}
        	//Regenerate breakfast.
        	else {
        		bFVBox.getChildren().clear();
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
        		regenBFButton.setVisible(true);
        		generateBFButton.setVisible(false);
        		
        		//Adding calories from meal to the daily total
        		mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText())+ breakfastCals));
        		} 
        	//Catch invalid entry(when entry is not an integer)
        	}catch(NumberFormatException e) {
        		bFVBox.getChildren().clear();
        		Label error = new Label(entryNotIntError());
        		error.setTextFill(Color.RED);
        		bFVBox.getChildren().add(error);
        		}
        }
    
    /**
     * This method is used to regenerate the Breakfast meal, with respect to user-entered calories. It clears the current
     * VBox and re-adds HBoxes to the VBox in respect to the number of Food objects in the generated meal. It re-updates the
     * Daily Calorie Counter. It also sets an error message when user entered invalid entry.
     * 
     * @param regenBFEvent Parameter that indicates it's a breakfast-regenerate Event.
     */
    @FXML
    void userRegenBF(ActionEvent regenBFEvent) {
    	//Try...catch method to check if user entry is an integer.
    	try {
    	    //Check if user entered nothing.
            if(bFCalTextField.getText().isEmpty()){
                bFVBox.getChildren().clear();
                Label error = new Label(noEntryError("breakfast"));
                error.setTextFill(Color.RED);
                bFVBox.getChildren().add(error);
            }
            //Check if user-entered data is in the range between 100 and 1000.
            else if(Integer.parseInt(bFCalTextField.getText())>1000||Integer.parseInt(bFCalTextField.getText())<=100) {
                bFVBox.getChildren().clear();
                Label error = new Label(caloryError());
                error.setTextFill(Color.RED);
                bFVBox.getChildren().add(error);
            }
            //Regenerate breakfast.
         
          else{
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
        	  //Display total calories of breakfast and add the breakfast calories to Total calories of all meals.
        	  Label totalCalsLabel = new Label("Total Meal Calories: " + String.valueOf(breakfastCals));
        	  bFVBox.getChildren().add(totalCalsLabel);
        	  mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) + breakfastCals));
        	  }
            //Catch invalid entry(when entry not an integer) 
            }catch(NumberFormatException e) {
            	bFVBox.getChildren().clear();
                Label error = new Label(entryNotIntError());
                error.setTextFill(Color.RED);
                bFVBox.getChildren().add(error);
                }
    	}
    	
    /**
     * This method is used to generate a Lunch meal, with respect to user-entered calories. It creates a
     * number of HBoxes relative to the number of food objects generated in the meal and adds them to the VBox
     * then displays the total calories of the meal. Then it updates the Daily Calorie Counter.
     * It also sets an error message when user entered invalid entry.
     *
     * @param lunchGenEvent this parameter indicates this method would generate a lunch.
     */ 
    @FXML
    void userGenerateLunch(ActionEvent lunchGenEvent) {
    	//Try...catch method to check if user entry is an integer.
    	 try {
     	       //Check if user entered nothing.
    	       if(lunchCalTextField.getText().isEmpty()){
    	           lunchVBox.getChildren().clear();
    	           Label error = new Label(noEntryError("lunch"));
    	           error.setTextFill(Color.RED);
    	           lunchVBox.getChildren().add(error);
    	        }           
       	        //Check if user-entered data is in the range between 100 and 1000.
    	        else if(Integer.parseInt(lunchCalTextField.getText())>1000||Integer.parseInt(lunchCalTextField.getText())<=100) {
    	            lunchVBox.getChildren().clear();
    	            Label error = new Label(caloryError());
    	            error.setTextFill(Color.RED);
    	            lunchVBox.getChildren().add(error);
    	        }
                //Generate lunch.
    	        else {    	
    	        	lunchVBox.getChildren().clear();
    	    	    Label mealName = new Label ("Lunch");
    	    	    //New Meal object based on calorie goal input
    	    	    Meal lunch = new Meal("Lunch", Integer.parseInt(lunchCalTextField.getText()));
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
    	    	    regenLunchButton.setVisible(true);
    	    	    generateLunchButton.setVisible(false);
    	    	    
    	    	    //Adding calories from meal to the daily total
    	    	    mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) + lunchCals));
    	    	    }
    	       }catch(NumberFormatException e) {
    	    	   lunchVBox.getChildren().clear();
                   Label error = new Label(entryNotIntError());
                   error.setTextFill(Color.RED);
                   lunchVBox.getChildren().add(error);
                   }
    }
    

    /**
     * This method is used for regenerating the Lunch meal, with respect to user-entered calories. It clears the current
     * VBox and re-adds HBoxes to the VBox in respect to the number of Food objects in the generated meal. It re-updates the
     * Daily Calorie Counter. It also sets an error message when user entered invalid entry.
     *
     * @param regenLunchEvent Parameter that indicates it's a lunch-regenerate Event.
     */
    @FXML
    void userRegenLunch(ActionEvent regenLunchEvent) {
    	try {
 	       if(lunchCalTextField.getText().isEmpty()){
 	           lunchVBox.getChildren().clear();
 	           Label error = new Label(noEntryError("lunch"));
 	           error.setTextFill(Color.RED);
 	           lunchVBox.getChildren().add(error);
 	        }
 	        else if(Integer.parseInt(lunchCalTextField.getText())>1000||Integer.parseInt(lunchCalTextField.getText())<=100) {
 	            lunchVBox.getChildren().clear();
 	            Label error = new Label(caloryError());
 	            error.setTextFill(Color.RED);
 	            lunchVBox.getChildren().add(error);
 	        }
 	        else {
 	        	//Reset the value/items in the VBox of the previous meal
 	        	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) - lunchCals));
 	        	lunchCals = 0;
 	        	lunchVBox.getChildren().clear();
    	
 	        	Label mealName = new Label ("Lunch");
 	        	lunchVBox.getChildren().add(mealName);
 	        	Meal lunch = new Meal("Lunch", Integer.parseInt(lunchCalTextField.getText()));
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
 	       }catch(NumberFormatException e) {
 	    	   lunchVBox.getChildren().clear();
 	    	   Label error = new Label(entryNotIntError());
 	    	   error.setTextFill(Color.RED);
 	    	   lunchVBox.getChildren().add(error);
 	    	   }
    	}
    	
    /**
     * This method is used to generate a Dinner meal, with respect to user-entered calories. It creates a
     * number of HBoxes relative to the number of food objects generated in the meal and adds them to the VBox
     * then displays the total calories of the meal. Then it updates the Daily Calorie Counter.
     * It also sets an error message when user entered invalid entry.
     * 
     * @param dinnerGenEvent event that represents a dinner-generated event.
     */
    @FXML
    void userGenerateDinner(ActionEvent dinnerGenEvent) {
    	try {
 	       if(dinnerCalTextField.getText().isEmpty()){
 	           dinnerVBox.getChildren().clear();
 	           Label error = new Label(noEntryError("dinner"));
 	           error.setTextFill(Color.RED);
 	           dinnerVBox.getChildren().add(error);
 	        }
 	        else if(Integer.parseInt(dinnerCalTextField.getText())>1000||Integer.parseInt(dinnerCalTextField.getText())<=100) {
 	            dinnerVBox.getChildren().clear();
 	            Label error = new Label(caloryError());
 	            error.setTextFill(Color.RED);
 	            dinnerVBox.getChildren().add(error);
 	        }
 	        else {
 	        	dinnerVBox.getChildren().clear();
 	        	Label mealName = new Label ("Dinner");
 	        	//New Meal object based on calorie goal input
 	        	Meal dinner = new Meal("Dinner", Integer.parseInt(dinnerCalTextField.getText()));
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
 	        	regenDinnerButton.setVisible(true);
 	        	generateDinnerButton.setVisible(false); 	

 	        	//Adding calories from meal to the daily total
 	        	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) + dinnerCals));
 	        	}
 	       }catch(NumberFormatException e) {
 	    	   dinnerVBox.getChildren().clear();
 	    	   Label error = new Label(entryNotIntError());
 	    	   error.setTextFill(Color.RED);
 	    	   dinnerVBox.getChildren().add(error);
 	    	   }
    	}
    
    
    /**
     * This method is used for regenerating the Dinner meal, with respect to user-entered calories. It clears the current
     * VBox and re-adds HBoxes to the VBox in respect to the number of Food objects in the generated meal. It re-updates the
     * Daily Calorie Counter. It also sets an error message when user entered invalid entry.
     * 
     * @param regenDinnerEvent Parameter that indicates it's a dinner-regenerate Event.
     */
    @FXML
    void userRegenDinner(ActionEvent regenDinnerEvent) {
    	try {
  	       if(dinnerCalTextField.getText().isEmpty()){
  	           dinnerVBox.getChildren().clear();
  	           Label error = new Label(noEntryError("dinner"));
  	           error.setTextFill(Color.RED);
  	           dinnerVBox.getChildren().add(error);
  	        }
  	        else if(Integer.parseInt(dinnerCalTextField.getText())>1000||Integer.parseInt(dinnerCalTextField.getText())<=100) {
  	            dinnerVBox.getChildren().clear();
  	            Label error = new Label(caloryError());
  	            error.setTextFill(Color.RED);
  	            dinnerVBox.getChildren().add(error);
  	        }
  	        else {
  	        	//Reset the value/items in the VBox of the previous meal
  	        	mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText()) - dinnerCals));
  	        	dinnerCals = 0;
  	        	dinnerVBox.getChildren().clear();
    	
  	        	Label mealName = new Label ("Dinner");
  	        	dinnerVBox.getChildren().add(mealName);
  	        	Meal dinner = new Meal("Dinner", Integer.parseInt(dinnerCalTextField.getText()));
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
  	       }catch(NumberFormatException e) {
  	    	   dinnerVBox.getChildren().clear();
  	    	   Label error = new Label(entryNotIntError());
  	    	   error.setTextFill(Color.RED);
  	    	   dinnerVBox.getChildren().add(error);
  	    	   }
    	}
    	
    /**
     * This method takes the value of the TextField and converts it to an integer, then adds it to the Total
     * Daily Calories Counter. 
     *
     * @param addSnackEvent Parameter that indicates it's an addSnackEvent.
     */
    @FXML
    void userAddSnack(ActionEvent addSnackEvent) {
    	try {
            if(snackCalTextField.getText().isEmpty()){
                snackEnterLabel.setText(noEntryError("snack"));
                snackEnterLabel.setTextFill(Color.RED);
            }
            else if(Integer.parseInt(snackCalTextField.getText())>1000||Integer.parseInt(snackCalTextField.getText())<=100) {
            	snackEnterLabel.setText(caloryError());
                snackEnterLabel.setTextFill(Color.RED);
            }
            else {
                mealTotalCalLabel.setText(String.valueOf(Integer.parseInt(mealTotalCalLabel.getText())+ Integer.parseInt(snackCalTextField.getText())));
            	snackEnterLabel.setText(snackCalTextField.getText() + " Calories added to your total.");
            }
    	}
            catch(NumberFormatException e) {
                snackEnterLabel.setText(entryNotIntError());
                snackEnterLabel.setTextFill(Color.RED);
            }
    	}

    /**
     * Sets TotalCalLabel to 0 so that String.getValue() will have a valid parameter (instead of "")
     */
    void setCalLabel() {
    	mealTotalCalLabel.setText("0");
    }

    /** 
     * Greeting message displayed at top of winder to instruct user on how to use application
     */
    void setGreetingMsg() {
    	if(greetMsgLabel==null);
    	else {
        	greetMsgLabel.setText("Hello " + appUser.getName() +",\nYour body data is displayed on the right:\nYou can generate"
        			+ " 3 different meals by entering a calorie goal for each meal then pressing \nthe generate Breakfast"
        			+ "/Lunch/Dinner below. Also you can always regenerate a meal\nif you are unhappy with the generated meal."
        			+ " You can also add a custom snack by \n entering its calories. Total calories consumed are displayed "
        			+ "at bottom of the window. \nPlease enter calories with respect to your goal (Gaining weight or Losing weight) "
        			+ "and Enjoy the App!");
    	}
    }
    
    /**
     * Getter method for user class
     * @return User object appUser.
     */
    User getUser() {
    	return appUser;
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
   void setDailyRecomCalories() {
       dailyCalLabel.setText(String.valueOf(appUser.calculateDailyCalories(appUser.getAge(),appUser.getHeight(), appUser.getWeight())));
   }

   /**
    * This method is used for setting BMI indication using user-inputed data.
    */
   void setBMI() {
       bMILabel.setText(appUser.getBMI(appUser.getHeight(), appUser.getWeight()));
   }
   
   /**
    * This method is used for setting an error message when user entered a value that is not between the 
    * range of 100 and 1000.
    *
    * @return error message when user entered a number that is not between 100 and 1000.
    */
   String caloryError() {
	   String error = "Error: Calories must be between 100 and 1000 (Does not include 100).";
	   return error;
   }
   
   /**
    * This method is used for setting an error message when user entered nothing.
    * The parameter mealName represents different meals.
    *
    * @param mealName this parameter represents different meal's name when this method is called.
    * @return error message when user entered nothing.
    */
   String noEntryError(String mealName) {
	   String error = "Error: Can't generate " + mealName +" without a calories entry.";
	   return error;
   }
   
  /**
   * This method is used for setting an error message when user entered a value that
   * is not a integer.
   *
   * @return error message when user entered a non-integer value.
   */
   String entryNotIntError() {
	  String error =  "Error: Can't generate a Meal with non-integer value.";
	  return error;
   }
}

