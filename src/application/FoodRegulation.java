package application;


public interface FoodRegulation {

	static final int  MAXMEALGRAIN = 4;
	static final int  MAXMEALFRUIT = 5;
	static final int  MAXMEALDAIRY = 4;
	static final int  MAXMEALPROTEIN = 2;
	
	boolean canEat();
	

}
