package application;

import java.util.ArrayList;

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
	{
		ArrayList<Food> fruitList = new ArrayList <Food> ();
		Fruit banana = new Fruit("Banana",105);
		fruitList.add(banana);
		Fruit strawberry = new Fruit("Strawberry",32);
		fruitList.add(strawberry);
		Fruit grapes = new Fruit("Grapes",67);
		fruitList.add(grapes);
		Fruit apple = new Fruit("Apple",95);
		fruitList.add(apple);
		Fruit watermelon = new Fruit("Watermelon",30);
		fruitList.add(watermelon);
	}
}
