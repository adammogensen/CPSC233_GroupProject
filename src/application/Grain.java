package application;


public class Grain extends Food implements FoodRegulation{
	private static int grainInMeal = 0;

	
	//Constructor
	Grain(String name, int calories){
		super(name, calories);
	}
	
	//Return max target for control in Meal Generator
	public static int getMaxTarget() {
		return MAXMEALGRAIN;
	}

	//Meal generator will use this to control the number of grain objects put into each meal.
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

	public void resetGrain() {
		grainInMeal = 0;

	}
}

