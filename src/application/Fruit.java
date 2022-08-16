package application;

public class Fruit extends Food implements FoodRegulation{
	
	//Track number of Fruit items in each meal
	private static int fruitInMeal = 0;
	
	//Constructor
	Fruit(String fruitName, int fruitCalories){
		super(fruitName, fruitCalories);
	}
	
	/**
	 * Flag for the generateMeal() method in the Meal class, returns true if the 
	 * number of Fruit objects in the meal is less than the maximum Fruit 
	 * allowance in each meal (from the Food Regulation interface)
	 */
	@Override
	public boolean canEat() {
		if (fruitInMeal < MAXMEALFRUIT) {
			fruitInMeal ++;
			return true;
		}
		else{
			return false;
		}

	}	
	/**
	 * Used after each method call of generateMeal() in the Meal Class.
	 * Used to reset the Fruit in meal counter for next meal.
	 */
	public void resetFruit() {
		fruitInMeal = 0;
	}
}
