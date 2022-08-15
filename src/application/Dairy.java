package application;


public class Dairy extends Food implements FoodRegulation{
 	private static int dairyInMeal = 0;
	//Constructor
	Dairy(String name, int calories){
		super(name, calories);
	}

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
	public void resetDairy() {
		dairyInMeal = 0;
	}
}




