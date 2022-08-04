package application;

public class User {

	
	//Creating instance variables
	private String name;
	private double weight;
	private double height;
	private int age;
	private boolean isMale;
	private int requiredCalories;
	private double BMI;

	//Constructors
	
	public User(){
		
	}
	
	public User(String name,double inputWeight, double inputHeight, int inputAge, boolean Male){
		this.setName(name);
		weight = inputWeight;
		height = inputHeight;
		age = inputAge;
		isMale = Male;
	}
	
	//Getters and Setters for instance variables
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		if(weight > 0) {
			this.weight = weight;
		}
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		if(height> 0) {
			this.height = height;
		}
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if (age>0) {
			this.age = age;
		}
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
		if (dailyCalories > 0) {
			this.requiredCalories = dailyCalories;
		}
	}
	
	
	//Methods
	String getBMI(double height, double weight){
		String bMI = "";
		//BMI calculation:
		this.height = height/100;
		double BMI = weight / (height * height);

			if (BMI < 18.5)
					bMI = "underweight";
				else if(BMI < 25)
					bMI = "normal weight";
				else if(BMI >= 25)
					bMI = "Obese";
			return bMI;
	}
	
	int calculateDailyCalories(double BMI, int age, int activityLevel) {
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

