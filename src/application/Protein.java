package application;

public class Protein extends Food implements FoodRegulation{
	private static int dailyProtein = 0;
	private static final int  maxTargetPerMeal = 2;
	
	//Constructor
	Protein(String name, int calories){
		super(name, calories);
	}

	//Return max target for control in Meal Generator
	public static int getMaxTarget() {
		return maxTargetPerMeal;
	}

	@Override
	public boolean canEat() {
		if (dailyProtein < maxDailyProtein) {
			dailyProtein ++;
			return true;
		}
		else{
			return false;
		}
	}
}



