package application;

public class Fruit extends Food implements FoodRegulation{
	private static int dailyFruit = 0;
	private static final int  maxTargetPerMeal = 4;
	
	//Constructor
	Fruit(String name, int calories){
		super(name, calories);
	}
	
	//Return max target for control in Meal Generator
	public static int getMaxTarget() {
		return maxTargetPerMeal;
	}
	
	@Override
	public boolean canEat() {
		if (dailyFruit < maxDailyFruit) {
			dailyFruit ++;
			return true;
		}
		else{
			return false;
		}
	}
}
