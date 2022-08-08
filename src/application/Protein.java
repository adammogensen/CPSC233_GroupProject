package application;

import java.util.ArrayList;

public class Protein extends Food implements FoodRegulation{
	private static int dailyProtein = 0;
	private static final int  maxTargetPerMeal = 2;
	private ArrayList<Food>proteinList;
	
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
	
	public ArrayList<Food>createList(){
		proteinList = new ArrayList <Food> ();
		Protein chickenbreast = new Protein("Chicken Breast",284);
		proteinList.add(chickenbreast);
		Protein chickenthigh = new Protein("Chicken Thigh",351);
		proteinList.add(chickenthigh);
		Protein steak = new Protein("Steak",500);
		proteinList.add(steak);
		Protein salmon = new Protein("Salmon",255);
		proteinList.add(salmon);
		Protein scramblegg = new Protein("Scramble Eggs",91);
		proteinList.add(scramblegg);
		Protein boiledegg = new Protein("Boiled Eggs",78);
		proteinList.add(boiledegg);
		Protein friedeggs = new Protein("Fried Eggs",90);
		proteinList.add(friedeggs);
		return proteinList;
	}
}



