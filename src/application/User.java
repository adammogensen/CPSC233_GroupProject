package application;

public class User {

	
	//Creating instance variables
	private double weight;
	private double height;
	private int age;
	private boolean isMale;
	private int requiredCalories;
	private double BMI;

	
	
	//Getters and Setters for instance variables
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	boolean isMale() {
		return isMale;
	}
	void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public int getDailyCalories() {
		return requiredCalories;
	}
	public void setDailyCalories(int dailyCalories) {
		this.requiredCalories = dailyCalories;
	}
	
	
	//Creating constructors
	double getBMI(double height, double weight) {
		//BMI calculation:
		return 0;
	}
	
	int calculateDailyCalories(double BMI, int age, int activityLevel) {
		return 0;
	}

}



