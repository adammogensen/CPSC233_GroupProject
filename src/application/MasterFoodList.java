package application;

import java.util.ArrayList;

/**
 * //This class is designed to hold the data of the food objects that we created in an 
 * ArrayList which can be accessed by the Meal class for meal generation
 * @author Adam Mogensen
 *
 */
public class MasterFoodList {
	private ArrayList <Food> masterList = new ArrayList <Food> ();
	
	/**
	 * Constructor
	 */
	MasterFoodList(){
	}
	
	/**
	 * This method holds the Food objects that were created to be added to the generated meals.
	 * Adds all food objects to masterList.
	 */
	void addFoodToList() {
		Fruit banana = new Fruit("Banana",105);
		masterList.add(banana);
		Fruit strawberry = new Fruit("Strawberry",32);
		masterList.add(strawberry);
		Fruit grapes = new Fruit("Grapes",67);
		masterList.add(grapes);
		Fruit apple = new Fruit("Apple",95);
		masterList.add(apple);
		Fruit watermelon = new Fruit("Watermelon",30);
		masterList.add(watermelon);
		Fruit avocado = new Fruit("Avocado", 160);
		masterList.add(avocado);
		Fruit broccoli = new Fruit ("Broccoli", 35);
		masterList.add(broccoli);
		Fruit carrots = new Fruit ("Carrots", 41);
		masterList.add(carrots);
		

		Grain bread = new Grain("Slice of Bread",66);
		masterList.add(bread);
		Grain pasta = new Grain("Pasta",131);
		masterList.add(pasta);
		Grain rice = new Grain("Steamed White Rice",151);
		masterList.add(rice);
		Grain brownRice = new Grain ("Brown Rice", 110);
		masterList.add(brownRice);
		Grain oatmeal = new Grain("Oatmeal",120);
		masterList.add(oatmeal);
		Grain tortilla = new Grain("Flour Tortilla",147);
		masterList.add(tortilla);
		Grain potato = new Grain("Baked Potato", 161);
		masterList.add(potato);
		Grain sweetPotato = new Grain("Sweet Potato", 85);
		masterList.add(sweetPotato);
		
		
		Dairy skimMilk = new Dairy("Skim Milk",103);
		masterList.add(skimMilk);
		Dairy milk2 = new Dairy ("2% Milk", 150);
		masterList.add(milk2);
		Dairy butter = new Dairy("Butter",102);
		masterList.add(butter);
		Dairy cheese = new Dairy("Cheese",104);
		masterList.add(cheese);
		Dairy yogurt = new Dairy("Yogurt",61);
		masterList.add(yogurt);
		Dairy pButter = new Dairy("Peanut Butter", 98);
		masterList.add(pButter);
		

		Protein chickenbreast = new Protein("Chicken Breast",231);
		masterList.add(chickenbreast);
		Protein chickenthigh = new Protein("Chicken Thigh",301);
		masterList.add(chickenthigh);
		Protein steak = new Protein("Steak",371);
		masterList.add(steak);
		Protein salmon = new Protein("Salmon",255);
		masterList.add(salmon);
		Protein scramblegg = new Protein("Scramble Eggs",91);
		masterList.add(scramblegg);
		Protein boiledegg = new Protein("Boiled Eggs",78);
		masterList.add(boiledegg);
		Protein friedeggs = new Protein("Fried Eggs",90);
		masterList.add(friedeggs);	
	}
	
	/**
	 * Used to retrieve the ArrayList of food. Intended to use after .addFoodToList is invoked
	 * @return masterList ArrayList
	 */
	ArrayList <Food> getFoodList (){
		return masterList;
	}
}
