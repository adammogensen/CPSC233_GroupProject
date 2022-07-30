package application;

public class Food {
	//Create parameters for food objects
	private String nameOfFood = "";
	private double caloriesPerServing = 0.0;
	private double proteinPerServing = 0.0;
	private double fatPerServing = 0.0;
	private double carbPerServing = 0.0;
	private boolean loseWeightFood = false;
	private boolean gainWeightFood = false;
	private boolean bothTypesFood = false;
	
	
	//Creating food constructor
	Food (String name, double calories, double protein, double fats, double carbohydrates, boolean loseWeight, boolean gainWeight, boolean bothTypes){
		nameOfFood = name;
		caloriesPerServing = calories;
		proteinPerServing = protein;
		fatPerServing = fats;
		carbPerServing = carbohydrates;
		loseWeightFood = loseWeight;
		gainWeightFood = gainWeight;
		bothTypesFood = bothTypes;
	}
	
	Food (Food toCopy){
		this.nameOfFood = toCopy.nameOfFood;
		this.caloriesPerServing = toCopy.caloriesPerServing;
		this.proteinPerServing = toCopy.proteinPerServing;
		this.fatPerServing = toCopy.fatPerServing;
		this.carbPerServing = toCopy.carbPerServing;
		this.loseWeightFood = toCopy.loseWeightFood;
		this.gainWeightFood = toCopy.gainWeightFood;
		this.bothTypesFood = toCopy.bothTypesFood;
	}
	//Create Getters and Setters of each food parameter
		String getNameOfFood() {
			return nameOfFood;
		}
		void setNameOfFood(String nameOfFood) {
			this.nameOfFood = nameOfFood;
		}
		double getCaloriesPerServing() {
			return caloriesPerServing;
		}
		void setCaloriesPerServing(double caloriesPerServing) {
			this.caloriesPerServing = caloriesPerServing;
		}
		double getProtein() {
			return proteinPerServing;
		}
		void setProtein(double proteinPerServing) {
			this.proteinPerServing = proteinPerServing;
		}
		double getFat() {
			return fatPerServing;
		}
		void setFatPer(double fatPerServing) {
			this.fatPerServing = fatPerServing;
		}
		double getCarb() {
			return carbPerServing;
		}
		void setCarb(double carbPerServing) {
			this.carbPerServing = carbPerServing;
		}
		boolean isLoseWeightFood() {
			return loseWeightFood;
		}
		void setLoseWeightFood(boolean loseWeightFood) {
			this.loseWeightFood = loseWeightFood;
		}
		boolean isGainWeightFood() {
			return gainWeightFood;
		}
		void setGainWeightFood(boolean gainWeightFood) {
			this.gainWeightFood = gainWeightFood;
		}
		boolean isBothTypesFood() {
			return bothTypesFood;
		}
		void setBothTypesFood(boolean bothTypesFood) {
			this.bothTypesFood = bothTypesFood;
		}
}
