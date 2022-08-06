package application;

import java.util.ArrayList;
import java.util.Random;

public class Meal {
	private String nameOfMeal;
	private ArrayList <Food> foodInMeal;
	private int goalCalories;
	

	//Constructor for Meal Class
	Meal(String name, int goalCals){
		nameOfMeal = name;
		setGoalCalories(goalCals);
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
	void generateMeal(int goalCal){
		int calories = 0;
		int proteinTotal = 0;
		int grainTotal = 0;
		int fruitTotal = 0;
		int dairyTotal = 0;
		Random random = new Random();
		int randomFruit = random.nextInt(0, fruitList.size() + 1);
		int randomGrain = random.nextInt(0, grainList.size() + 1);
		int randomDairy = random.nextInt(0, dairyList.size() + 1);
		int randomProtein = random.nextInt(0, proteinList.size() + 1);
		/*Loop to add food until reach calorie goal
		goalCal parameter is 25 less so that meals will be closer to calorie goal.*/
		while (calories < goalCal - 25) {
		/*canEat checks if there is still a quota for the type of Food
		each food type has a unique maxTarget for each meal. Check to make
		sure a meal has a balance of different food items */
			Food addFruit = new Food(fruitList.get(randomFruit));

			if (addFruit.canEat() && fruitTotal < Fruit.getMaxTarget() && !this.getFoodInMeal().contains(addFruit)) {
				this.getFoodInMeal().add(addFruit);
				fruitTotal ++;
				calories += addFruit.getCaloriesPerServing();
			}
			Food addGrain = new Food(grainList.get(randomGrain));

			if (addGrain.canEat() && grainTotal < Grain.getMaxTarget() && !this.getFoodInMeal().contains(addGrain)) {
				this.getFoodInMeal().add(addGrain);
				grainTotal ++;
				calories += addGrain.getCaloriesPerServing();
			}
			Food addDairy = new Food(dairyList.get(randomDairy));

			if (addDairy.canEat() && dairyTotal < Dairy.getMaxTarget() && !this.getFoodInMeal().contains(addDairy)) {
				this.getFoodInMeal().add(addDairy);
				dairyTotal ++;
				calories += addDairy.getCaloriesPerServing();
			}
			Food addProtein = new Food(proteinList.get(randomProtein));

			if (addProtein.canEat() && proteinTotal < Protein.getMaxTarget() && !this.getFoodInMeal().contains(addProtein)) {
				this.getFoodInMeal().add(addProtein);
				proteinTotal ++;
				calories += addProtein.getCaloriesPerServing();
			}
		}
	}
}


