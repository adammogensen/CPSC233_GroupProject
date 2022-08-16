package application;

import java.util.ArrayList;
import java.util.Random;

/**
 * This class is responsible for storing food objects in ArrayLists. It also has a method
 * that has a key function in the project which is randomly generating meals.
 * @author Adam Mogensen
 *
 */
public class Meal {
	private String mealName = "";
	private ArrayList <Food> foodInMeal;
	private int goalCalories = 0;
	
	/*These objects provide access to their respective classes and are used
	 * to reset the static integer value of each class
	 */
	
	private Grain accessGrain = new Grain("", 0);
	private Fruit accessFruit = new Fruit("", 0);
	private Dairy accessDairy = new Dairy("", 0);
	private Protein accessProtein = new Protein("", 0);
	

	/**
	 * Constructor for Meal Class
	 * @param name name of Meal
	 * @param goalCals Calorie goal for the meal
	 */
	
	Meal(String name, int goalCals){
		mealName = name;
		goalCalories = goalCals;
		//Create a new ArrayList for each meal
		foodInMeal = new ArrayList <Food>();
	}
	
	/**
	 * Used to retrieve the food items in the meal
	 * @return ArrayList of food items in meal
	 */
	ArrayList <Food> getFoodInMeal() {
		return foodInMeal;
	}

	/**
	 * This method produces a meal with randomized food items from the four created food groups.
	 * Each food group has a different maximum number of food items per meal (eg. max 2 proteins per meal) based
	 * on the constant values in the Food Regulation interface. Meals will be created based on the calorie goal 
	 * inputed by the user. 
	 * @param goalCal provide by the user in a TextField
	 */
	void generateMeal(){
		//Create new masterList object and add food objects to the ArrayList
		MasterFoodList masterList = new MasterFoodList();
		masterList.addFoodToList();
		
		/*Counter variable counts the number of times that a food group has reached it's 'Meal Maximum'
		 * once the counter reaches 4, the loop stops to prevent an infinite loop 
		 */
		int counter = 0;
		
		//Calories variable represents the total calories of the current meal
		int calories = 0;
		
		/*Creating a Random object to use for it's .nextInt() method for producing random
		 * indexing into the masterList
		 */
		
		Random random = new Random();
		
		/*Loop to add food until calories in the meal reaches the calorie goal
		* goalCal parameter is 30 less so that meals will be closer to calorie goal.
		*/
		
		while (calories < goalCalories - 30 && counter <= 4) {
			
			//Random food chosen from the masterList
			int randomFood = random.nextInt(0, masterList.getFoodList().size() - 1);
			Food addFood = masterList.getFoodList().get(randomFood);
			
			/*canEat() method in food class if overridden by one of the Food Group Classes (Protein,Dairy,Grain,Fruit)
			 * Checks to see if food in meal exceeds the maximum number of food per group allowed. Also checks if food is 
			 * already in the meal to prevent overlap
			 */
			
			if(addFood.canEat() && !this.getFoodInMeal().contains(addFood)) {
				this.getFoodInMeal().add(addFood);
				calories += addFood.getCaloriesPerServing();
			}	
			/*When the Food Group has reached it's limit for number of food items in the meal
			 * the counter is incremented up
			 */
			
			else if (!addFood.canEat()) {
				counter++;
			}
			/*This if statement checks to make sure that the last item in the list does not make
			 * the total calories greatly exceed the goal calories. For example, if the goal calories are 
			 * 500, and the current calories are 460, then a 'steak' is added, the meal calories will become
			 * 830.
			 */
			if(calories >= goalCalories + 200) {
				this.getFoodInMeal().remove(this.getFoodInMeal().size()-1);
				calories -= this.getFoodInMeal().get(this.getFoodInMeal().size()-1).getCaloriesPerServing();
			}
		}
		
		/* These instance variable objects were created to access the reset method in each of the
		 * classes so that the 'in Meal' static variable in each class is set back to 0.
		 */
		accessProtein.resetProtein();
		accessGrain.resetGrain();
		accessFruit.resetFruit();
		accessDairy.resetDairy();
	}
}


