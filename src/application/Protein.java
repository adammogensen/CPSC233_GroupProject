package application;

/**
 * This is a subclass of Food that is used to create Protein objects and track 
 * the number of Protein objects in a meal.
 * @author Adam Mogensen
 *
 */
public class Protein extends Food implements FoodRegulation{
	//Track number of Protein items in each meal
	private static int proteinInMeal = 0;
	
	/**
	 * Constructor
	 * @param name name of Protein object
	 * @param calories number of calories in Protein object
	 */
	Protein(String name, int calories){
		super(name, calories);
	}
	
	/**
	 * Flag for the generateMeal() method in the Meal class, returns true if the 
	 * number of Protein objects in the meal is less than the maximum Protein 
	 * allowance in each meal (from the Food Regulation interface)
	 * 
	 * @return true if the number of Protein objects in the meal is less than the maximum Protein 
	 * @return false if the number of Protein objects in the meal is more than the maximum Protein. 
	 */
	@Override
	public boolean canEat() {
		if (proteinInMeal < MAXMEALPROTEIN) {
			proteinInMeal ++;
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Used after each method call of generateMeal() in the Meal Class.
	 * Used to reset the Protein in meal counter for next meal.
	 */
	public void resetProtein() {
		proteinInMeal = 0;

	}
}



