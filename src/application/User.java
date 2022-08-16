package application;
/**
 * User stores user inputed data; name, weight, height, age, isMale.
 * its has method to calculate the BMI and daily recommended calories using the stored data in the user class.
 * 
 * @author Mun Seok Suh,Haoping(Ryan) Zheng, Adam Mogensen
 *
 */
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
	
	/**
	 * This is the constructors of user class
	 */
	public User(){
		
	}
	
	/**
	 * This method is a constructors that score the parameters value 
	 * into the instance variables of name, weight, height, age and Male
	 * 
	 * @param name represents string data that will be passed into the name of user instance.
	 * @param inputWeight represents the double value data of the user that will be passed 
	 * into the weight of user instance.
	 * @param inputHeight represents double value data that will be passed into the height of user instance.
	 * @param inputAge represents integer value data that will be passed into the age of user instance.
	 * @param Male represents boolean data that will be passed into the Male of user instance.
	 */
	public User(String name,double inputWeight, double inputHeight, int inputAge, boolean Male){
		this.setName(name);
		weight = inputWeight;
		height = inputHeight;
		age = inputAge;
		isMale = Male;
	}
	
	
	//Getters and Setters for instance variables
	
	/**
	 * This gets name String data from the user instance.
	 * 
	 * @return returns name of the User.
	 */
	public String getName() {
		return name;
	}

	/**
	 * sets the name of user instance by using parameter name.
	 * 
	 * @param name this String value would be set as name of user instance.
	 */
	public void setName(String name) {
		this.name = name;
	}
	

	
	/**
	 * This gets the double weight data from the user instance.
	 * 
	 * @return returns weight of the User.
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * sets the weight of user instance by using parameter weight as its greater than 0.
	 * 
	 * @param weight this double value would be set as weight of user instance if its greater than 0.
	 */
	public void setWeight(double weight) {
		if(weight > 0) {
			this.weight = weight;
		}
	}

	/**
	 * This gets the double height data from the user instance.
	 * 
	 * @return returns height of the User.
	 */
	public double getHeight() {
		return height;
	}
	
	/**
	 * sets the height of user instance by using parameter height as its greater than 0.
	 * 
	 * @param height this double value would be set as height of user instance if its greater than 0.
	 */
	public void setHeight(double height) {
		if(height> 0) {
			this.height = height;
		}
	}

	/**
	 * This gets the integer age data from the user instance.
	 * 
	 * @return returns age of the User.
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * sets the age of user instance by using parameter age as its greater than 0.
	 * 
	 * @param age this integer value would be set as age of user instance if its greater than 0.
	 */
	public void setAge(int age) {
		if (age>0) {
			this.age = age;
		}
	}

	/**
	 * This gets the boolean isMale data from the user instance
	 * 
	 * @return returns true if user's sex is male, false if it's not.
	 */
	boolean isMale() {
		return isMale;
	}
	
	/**
	 * Uses boolean parameter to set user instance's isMale boolean result.
	 * 
	 * @param isMale this boolean's result would be set as the result of isMale in the user instance.
	 */
	void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	/**
	 * This gets the requiredDailycalories data from the user instance.
	 * 
	 * @return required calories of the User.
	 */
	public int getDailyCalories() {
		return requiredCalories;
	}
	
	/**
	 * sets the dailyCalories of user instance by using parameter dailyCalories as its greater than 0.
	 * 
	 * @param dailyCalories this integer value would be set as dailyCalories of 
	 * user instance if its greater than 0.
	 */
	public void setDailyCalories(int dailyCalories) {
		if (dailyCalories > 0) {
			this.requiredCalories = dailyCalories;
		}
	}
	
	/**
	 * Calculates user BMI according to a formula found on the website:
	 * https://www.nhlbi.nih.gov/health/educational/lose_wt/BMI/bmi-m.htm
	 * 
	 * @param height represents the height double value of the user.
	 * @param weight represents the weight double value of the user.
	 * @return returns the BMI value and text description.
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
	 * 
	 * @param age integer that represents age of the user
	 * @param height represents the height double value of the user.
	 * @param weight represents the weight double value of the user.
	 * @return the daily recommended calories of the user.
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

