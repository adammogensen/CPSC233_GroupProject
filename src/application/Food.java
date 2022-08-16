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
	
	//Setters and Getters
	public String getNameOfFood() {
		return nameOfFood;
	}
	public int getCaloriesPerServing() {
		return caloriesPerServing;
	}
	
	//To be overridden by the food group classes' canEat() method
	public boolean canEat() {
		return true;
	}
}
