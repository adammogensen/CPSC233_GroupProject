package application;

import java.util.ArrayList;

public class Meal {
	private String nameOfMeal;
	private ArrayList <Food> foodInMeal;
	
	//Constructor for Meal Class
	Meal(String name){
		nameOfMeal = name;
		foodInMeal = new ArrayList <Food>();
	}
	
	Meal(Meal toCopy){
		this.nameOfMeal = toCopy.nameOfMeal;
		this.foodInMeal = toCopy.foodInMeal;
	}
	
	//Method to add food items into Meal
	void addFood(Food nameOfFood) {
		Food copyFood = new Food (nameOfFood);
		foodInMeal.add(copyFood);
		
	}
	//Method to remove food items from Meal
	void removeFood(Food nameOfFood) {
		foodInMeal.remove(nameOfFood);
	}
	
	//Getters/Setters
	String getNameOfMeal() {
		return nameOfMeal;
	}

	void setNameOfMeal(String nameOfMeal) {
		this.nameOfMeal = nameOfMeal;
	}

	ArrayList <Food> getFoodInMeal() {
		return foodInMeal;
	}
}
