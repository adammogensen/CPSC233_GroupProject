package application;

/**
 * This is the parent class of the 'Food Group Classes - Protein, Dairy, Grain, Fruit' and is used to 
 * create food objects and has the canEat() method which will be overridden by the food group classes.
 * @author Adam Mogensen
 *
 */
public class Food implements FoodRegulation{
	//Create parameters for food objects
	private String nameOfFood = "";
	private int caloriesPerServing = 0;
	
	/**
	 * Constructors
	 */
	Food(){
	}
	
	Food(String name, int calories){
		this.nameOfFood = name;
		this.caloriesPerServing  = calories;
	}
	
	/**
	 * Retrieves instance variable nameOfFood of food object
	 * @return nameOfFood String value
	 */
	public String getNameOfFood() {
		return nameOfFood;
	}
	/**
	 * Retrieves instance variable caloriesPerServing of food object
	 * @return caloriesPerServing integer value
	 */
	public int getCaloriesPerServing() {
		return caloriesPerServing;
	}
	
	/**
	 * To be overridden by the 'food group' classes' canEat() method
	 */
	public boolean canEat() {
		return true;
	}
}
