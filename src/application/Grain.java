package application;

/**
 * This is a subclass of Food that is used to create Grain objects and track 
 * the number of Grain objects in a meal.
 * @author Adam Mogensen
 *
 */
public class Grain extends Food implements FoodRegulation{
	//Track number of Grain items in each meal
	private static int grainInMeal = 0;

	
	/**
	 * Constructor
	 * @param name name of Grain object
	 * @param calories number of calories in Grain object
	 */
	Grain(String name, int calories){
		super(name, calories);
	}

	/**
	 * Flag for the generateMeal() method in the Meal class, returns true if the 
	 * number of Grain objects in the meal is less than the maximum Grain 
	 * allowance in each meal (from the Food Regulation interface)
	 */
	@Override
	public boolean canEat() {
		if (grainInMeal < MAXMEALGRAIN) {
			grainInMeal ++;
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Used after each method call of generateMeal() in the Meal Class.
	 * Used to reset the Grain in meal counter for next meal.
	 */
	public void resetGrain() {
		grainInMeal = 0;

	}
}

