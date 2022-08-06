package application;

public class Grain extends Food implements FoodRegulation{
	private static int dailyGrain = 0;
	private static final int  maxTargetPerMeal = 3;
	
	//Constructor
	Grain(String name, int calories){
		super(name, calories);
	}
	
	//Return max target for control in Meal Generator
	public static int getMaxTarget() {
		return maxTargetPerMeal;
	}

	//Meal generator will use this to control the number of grain objects put into each meal.
	@Override
	public boolean canEat() {
		if (dailyGrain < maxDailyGrain) {
			dailyGrain ++;
			return true;
		}
		else{
			return false;
		}
	}
}

