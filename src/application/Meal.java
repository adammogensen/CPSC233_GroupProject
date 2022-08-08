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
	
	Meal(Meal toCopy){
		this.nameOfMeal = toCopy.nameOfMeal;
		this.setGoalCalories(toCopy.getGoalCalories());
		this.foodInMeal = toCopy.foodInMeal;
	}

	//Method to add food items into Meal
	void addFood(Food nameOfFood) {
		Food copyFood = new Food (nameOfFood);
		foodInMeal.add(copyFood);
		
	}
	
	//Getters/Setters
	String getNameOfMeal() {
		return nameOfMeal;
	}

	void setNameOfMeal(String nameOfMeal) {
		this.nameOfMeal = nameOfMeal;
	}

	ArrayList <Food> getFoodInMeal() {
		return foodInMeal;
	}
	
	private int getGoalCalories() {
		return goalCalories;
	}

	public void setGoalCalories(int goalCalories) {
		this.goalCalories = goalCalories;
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
		goalCal parameter is 30 less so that meals will be closer to calorie goal.*/
		while (calories < goalCalories - 30 && counter < 3) {
			int randomFood = random.nextInt(0, masterList.getFoodList().size() - 1);
			Food addFood = masterList.getFoodList().get(randomFood);
			if(addFood.canEat() && !this.getFoodInMeal().contains(addFood)) {
				this.getFoodInMeal().add(addFood);
				calories += addFood.getCaloriesPerServing();
			}	
			else if (!addFood.canEat()) {
				counter++;
			}
		}
		accessProtein.resetProtein();
		accessGrain.resetGrain();
		accessFruit.resetFruit();
		accessDairy.resetDairy();
	}
}


