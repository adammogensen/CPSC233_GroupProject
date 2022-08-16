package application;


/**
 * This is a subclass of Food that is used to create Dairy objects and track 
 * the number of Dairy objects in a meal.
 * @author Adam Mogensen
 *
 */
public class Dairy extends Food implements FoodRegulation{
	//Track number of Dairy items in each meal
 	private static int dairyInMeal = 0;
	/**
	 * Constructor
	 * @param name name of Dairy object
	 * @param calories number of calories in Dairy object
	 */
	Dairy(String name, int calories){
		super(name, calories);
	}

	/**
	 * Flag for the generateMeal() method in the Meal class, returns true if the 
	 * number of Dairy objects in the meal is less than the maximum Dairy 
	 * allowance in each meal (from the Food Regulation interface)
	 * 
	 * @return true if the number of Dairy objects in the meal is less than the maximum Dairy
	 * allowance in each meal.
	 * @return false if the number of Dairy objects in the meal is more than or equal to the maximum Dairy
	 * allowance in each meal.
	 */
	@Override
	public boolean canEat(){
		if (dairyInMeal < MAXMEALDAIRY) {
			dairyInMeal ++;
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Used after each method call of generateMeal() in the Meal Class.
	 * Used to reset the Dairy in meal counter for next meal.
	 */
	public void resetDairy() {
		dairyInMeal = 0;
	}
}




