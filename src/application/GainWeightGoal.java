package application;

public class GainWeightGoal {
	private Meal recommendedGainerFoods;

	int calculateDailyCalories(double BMI, int age, int activityLevel) {
		//formula for calc + weightGain differential
		return 0;
	}
	
	void getFoodItems(Meal masterList) {
		recommendedGainerFoods = new Meal("WeightGain");
		for(Food gain: masterList.getFoodInMeal()) {
			if(gain.isLoseWeightFood() || gain.isBothTypesFood()) {
					recommendedGainerFoods.addFood(gain);
			}
		}
	}
}
