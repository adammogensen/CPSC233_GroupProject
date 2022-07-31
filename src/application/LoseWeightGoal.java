package application;

public class LoseWeightGoal extends User{
	
	private Meal recommendedLossFoods;
	
	
	int calculateDailyCalories(double BMI, int age, int activityLevel) {
		//formula for calc - weightLoss differential
		return 0;
	}
	void getFoodItems(Meal masterList) {
		recommendedLossFoods = new Meal("WeightLoss");
		for(Food lose: masterList.getFoodInMeal()) {
			if(lose.isLoseWeightFood() || lose.isBothTypesFood()) {
					recommendedLossFoods.addFood(lose);
			}
		}
	}
}
