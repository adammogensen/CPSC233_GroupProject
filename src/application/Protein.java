package application;

public class Protein extends Food implements FoodRegulation{
	private static int proteinInMeal = 0;
	
	//Constructor
	Protein(String name, int calories){
		super(name, calories);
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



