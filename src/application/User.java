package application;

public class User {
	
	//Creating instance variables
	private double weight;
	private double height;
	private int age;
	private int activityLevel; //Average activity level
	private int dailyCalories;
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
	public int getActivity() {
		return activityLevel;
	}
	public void setActivity(int activity) {
		this.activityLevel = activity;
	}
	public int getDailyCalories() {
		return dailyCalories;
	}
	public void setDailyCalories(int dailyCalories) {
		this.dailyCalories = dailyCalories;
	}
	
	
	//Creating constructors
	double getBMI(double height, double weight) {
		//BMI calculation:
		return 0;
	}
	
	int calculateDailyCalories(double BMI, int age, int activityLevel) {
		return 0;
	}
	
	void addActivity() {
		
	}
	
	int addMealEaten(int caloriesEaten) {
		return dailyCalories;
	}
}
