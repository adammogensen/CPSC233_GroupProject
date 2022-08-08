package application;

public class Food implements FoodRegulation{
	//Create parameters for food objects
	private String nameOfFood = "";
	private int caloriesPerServing = 0;
	
	//Constructors
	Food(){
	}
	
	Food(String name, int calories){
		this.nameOfFood = name;
		this.caloriesPerServing  = calories;
	}
	
	Food(Food toCopy){
		this.nameOfFood = toCopy.nameOfFood;
		this.caloriesPerServing = toCopy.caloriesPerServing;
	}
	
	public String getNameOfFood() {
		return nameOfFood;
	}
	public int getCaloriesPerServing() {
		return caloriesPerServing;
	}
	
	//Will be overridden
	public boolean canEat() {
		return true;
	}
}
