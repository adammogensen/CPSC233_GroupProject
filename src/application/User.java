package application;

public class User {

	
	//Creating instance variables
	private String name;
	private double weight;
	private double height;
	private int age;
	private boolean isMale;
	private int requiredCalories;
	private String bMI;
	private double bMR;

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
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
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
	
	/**
	 * Calculates user BMI according to a formula found on the website:
	 * https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmi-m.htm
	 * @param height Entered by user on FirstSceneController interface
	 * @param weight Entered by user on FirstSceneController interface
	 * @return
	 */
	String getBMI(double height, double weight){
		bMI = "";
		//BMI calculation:
		this.height = height/100;
		double bMICalc = weight / (this.height * this.height);

			if (bMICalc < 18.5)
					bMI = String.format("%.2f: Underweight", bMICalc);
				else if(bMICalc < 25)
					bMI = String.format("%.2f: Normal Weight", bMICalc);
				else if(bMICalc >= 25)
					bMI = String.format("%.2f: Overweight", bMICalc);
			return bMI;
	}
	
	/**
	 * Calculates the hypothetical amount of calories that the User would burn each day
	 * without accounting for activity. Represented as "Daily Recommended Calories"
	 * @param age Entered by user on FirstSceneController interface
	 * @param height Entered by user on FirstSceneController interface
	 * @param weight Entered by user on FirstSceneController interface
	 * @return
	 */
	double calculateDailyCalories(int age, double height, double weight) {
		if (isMale) {
			double bMRHolder = 66 + (13.7 * weight) + (5 * height)-(6.8 * age);
		    bMR = Double.parseDouble(String.format("%.2f", bMRHolder));
		}
		else {
			double bMRHolder = 655 + (9.6*weight)+(1.8*height)-(4.7 * age);
		    bMR = Double.parseDouble(String.format("%.2f", bMRHolder));
		}
		return bMR;
	}

}

