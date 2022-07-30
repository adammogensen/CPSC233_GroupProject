package application;

public class MacroCalculator {
	
	//Class to add/update daily calories or daily macronutrient totals.
	
	double updateDailyCalories (Meal mealToCalculate) {
		//Iterate through each food item in meal ArrayList and add values to a tracker
		double caloriesCalculated = 0.0;
		Meal Copy = new Meal (mealToCalculate);
		
		for(Food track: Copy.getFoodInMeal()) {
			caloriesCalculated += track.getCaloriesPerServing();
		} return caloriesCalculated;
	}
	double updateDailyProtein (Meal mealToCalculate) {
		double proteinCalculated = 0.0;
		Meal Copy = new Meal (mealToCalculate);
		
		for(Food track: Copy.getFoodInMeal()) {
			proteinCalculated += track.getProtein();
		} return proteinCalculated;
	}
	double updateDailyFats (Meal mealToCalculate) {
		double fatsCalculated = 0.0;
		Meal Copy = new Meal (mealToCalculate);
		
		for(Food track: Copy.getFoodInMeal()) {
			fatsCalculated += track.getFat();
		} return fatsCalculated;
	}
	double updateDailyCarbs (Meal mealToCalculate) {
		double carbsCalculated = 0.0;
		Meal Copy = new Meal (mealToCalculate);
		for(Food track: Copy.getFoodInMeal()) {
			carbsCalculated += track.getCarb();
		} return carbsCalculated;
	}
	
	
	//Adding method for if user wants to "quick add" calories/macronutrients without selecting a food
	double addCustomCalories(double caloriesToAdd) {
		if(caloriesToAdd > 0) {
		 return caloriesToAdd;
		}
		else {
			//Error Message
			return 0;
		}
	}
	double addCustomProtein(double proteinToAdd) {
		if(proteinToAdd > 0) {
		 return proteinToAdd;
		}
		else {
			//Error Message
			return 0;
		}
	}
	double addCustomFats(double fatsToAdd) {
		if(fatsToAdd > 0) {
		 return fatsToAdd;
		}
		else {
			//Error Message
			return 0;
		}
	}
	double addCustomCarbs(double carbsToAdd) {
		if(carbsToAdd > 0) {
		 return carbsToAdd;
		}
		else {
			//Error Message
			return 0;
		}
	}
}
