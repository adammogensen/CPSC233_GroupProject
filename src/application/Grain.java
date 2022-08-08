package application;

import java.util.ArrayList;

public class Grain extends Food implements FoodRegulation,FoodFunctions{
	private static int dailyGrain = 0;
	private static final int  maxTargetPerMeal = 3;
	private ArrayList<Food>grainList;
	
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

	public ArrayList<Food>createList(){
		grainList = new ArrayList <Food> ();
		Grain bread = new Grain("Slice of Bread",66);
		grainList.add(bread);
		Grain pasta = new Grain("Pasta",131);
		grainList.add(pasta);
		Grain rice = new Grain("Steamed Rice",151);
		grainList.add(rice);
		Grain oatmeal = new Grain("Oatmeal",120);
		grainList.add(oatmeal);
		Grain tortilla = new Grain("Flour Tortilla",147);
		grainList.add(tortilla);
		return grainList;
	}
}

