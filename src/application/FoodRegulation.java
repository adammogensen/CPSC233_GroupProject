package application;

public interface FoodRegulation {
	final static int maxDailyProtein = 5;
	final static int maxDailyGrain = 12;
	final static int maxDailyFruit = 8;
	final static int maxDailyDairy = 6;
	final static int minTargetFood = 1;
	
	boolean canEat();

}
