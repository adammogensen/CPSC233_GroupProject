package application;

public class Protein extends Food implements FoodRegulation{
	//Track number of Protein items in each meal
	private static int proteinInMeal = 0;
	
	//Constructor
	Protein(String name, int calories){
		super(name, calories);
	}
	
	/**
	 * Flag for the generateMeal() method in the Meal class, returns true if the 
	 * number of Protein objects in the meal is less than the maximum Protein 
	 * allowance in each meal (from the Food Regulation interface)
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



