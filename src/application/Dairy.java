package application;

import java.util.ArrayList;

public class Dairy extends Food implements FoodRegulation{
	private static int dailyDairy = 0;
	private static final int  maxTargetPerMeal = 3;
	private ArrayList<Food>dairyList;
	
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

	public ArrayList<Food>createList(){
		dairyList = new ArrayList <Food> ();
		Dairy milk = new Dairy("Milk",103);
		dairyList.add(milk);
		Dairy butter = new Dairy("Butter",102);
		dairyList.add(butter);
		Dairy cheese = new Dairy("Cheese",104);
		dairyList.add(cheese);
		Dairy yogurt = new Dairy("Yogurt",61);
		dairyList.add(yogurt);
		return dairyList;

	}
}




