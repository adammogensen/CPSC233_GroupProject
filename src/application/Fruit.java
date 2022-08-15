package application;

public class Fruit extends Food implements FoodRegulation{
	private static int fruitInMeal = 0;
	
	//Constructor
	Fruit(String fruitName, int fruitCalories){
		super(fruitName, fruitCalories);
	}
	
	@Override
	public boolean canEat() {
		if (fruitInMeal < MAXMEALFRUIT) {
			fruitInMeal ++;
			return true;
		}
		else{
			return false;
		}

	}	
	public void resetFruit() {
		fruitInMeal = 0;
	}
}
