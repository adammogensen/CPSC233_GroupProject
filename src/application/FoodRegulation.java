package application;


public interface FoodRegulation {
	
	/*Constants to regulate the maximum number of food items from each food group
	that can be added into a meal*/

	static final int  MAXMEALGRAIN = 4;
	static final int  MAXMEALFRUIT = 5;
	static final int  MAXMEALDAIRY = 4;
	static final int  MAXMEALPROTEIN = 2;
	
	/**
	 * Flag that will be used in food classes (Protein, Dairy, Grain, Fruit) to 
	check if current amount of food in a meal exceeds maximum allowance
	 */
	boolean canEat();
	

}
