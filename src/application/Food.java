package application;

public class Food implements FoodRegulation{
	//Create parameters for food objects
	private String nameOfFood = "";
	private int caloriesPerServing = 0;
	
	//Constructors
	Food(){
	}
	
	Food(String name, int calories){
		nameOfFood = name;
		caloriesPerServing = calories;
	}
	
	Food(Food toCopy){
		this.nameOfFood = toCopy.nameOfFood;
		this.caloriesPerServing = toCopy.caloriesPerServing;
	}
	
	public String getNameOfFood() {
		return nameOfFood;
	}
	public double getCaloriesPerServing() {
		return caloriesPerServing;
	}
	
	//Will be overridden
	public boolean canEat() {
		return false;
	}
}
