package application;

public class Dairy extends Food implements FoodRegulation{
	private static int dailyDairy = 0;
	private static final int  maxTargetPerMeal = 3;
	
	//Constructor
	Dairy(String name, int calories){
		super(name, calories);
	}
	
	//Return max target for control in Meal Generator
	public static int getMaxTarget() {
		return maxTargetPerMeal;
	}

	@Override
	public boolean canEat() {
		if (dailyDairy < maxDailyDairy) {
			dailyDairy ++;
			return true;
		}
		else{
			return false;
		}
	}
}




