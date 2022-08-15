package application;

import java.util.ArrayList;
import java.util.Random;

public class Meal {
	private String nameOfMeal;
	private ArrayList <Food> foodInMeal;
	private int goalCalories = 0;
	private Grain accessGrain = new Grain("", 0);
	private Fruit accessFruit = new Fruit("", 0);
	private Dairy accessDairy = new Dairy("", 0);
	private Protein accessProtein = new Protein("", 0);
	

	//Constructor for Meal Class
	Meal(String name, int goalCals){
		nameOfMeal = name;
		goalCalories = goalCals;
		foodInMeal = new ArrayList <Food>();
	}

	ArrayList <Food> getFoodInMeal() {
		return foodInMeal;
	}

	/**
	 * This method produces a meal with randomized food items from the four created food groups.
	 * Each food group has a different maximum number of food items per meal (eg. max 2 proteins per meal).
	 * Meals will be created based on the calorie goal inputed by the user
	 * @param goalCal
	 */
	void generateMeal(){
		MasterFoodList masterList = new MasterFoodList();
		masterList.addFoodToList();
		int counter = 0;
		int calories = 0;
		Random random = new Random();
		/*Loop to add food until reach calorie goal
		goalCal parameter is 30 less so that meals will be closer to calorie goal.
		counter variable is increased whenever */
		while (calories < goalCalories - 30 && counter <= 4) {
			int randomFood = random.nextInt(0, masterList.getFoodList().size() - 1);
			Food addFood = masterList.getFoodList().get(randomFood);
			if(addFood.canEat() && !this.getFoodInMeal().contains(addFood)) {
				this.getFoodInMeal().add(addFood);
				calories += addFood.getCaloriesPerServing();
			}	
			else if (!addFood.canEat()) {
				counter++;
			}
			if(calories >= goalCalories + 200) {
				this.getFoodInMeal().remove(this.getFoodInMeal().size()-1);
				calories -= this.getFoodInMeal().get(this.getFoodInMeal().size()-1).getCaloriesPerServing();
			}
		}
		
		accessProtein.resetProtein();
		accessGrain.resetGrain();
		accessFruit.resetFruit();
		accessDairy.resetDairy();
	}
}


