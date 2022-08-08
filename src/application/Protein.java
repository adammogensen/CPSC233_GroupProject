package application;

public class Protein extends Food implements FoodRegulation{
	private static int proteinInMeal = 0;
	
	//Constructor
	Protein(String name, int calories){
		super(name, calories);
	}

	//Return max target for control in Meal Generator
	public static int getMaxTarget() {
		return MAXMEALPROTEIN;
	}

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
	public void resetProtein() {
		proteinInMeal = 0;
	}
}



