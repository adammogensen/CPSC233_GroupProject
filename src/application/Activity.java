package application;

public class Activity {

	private boolean low; 
	private boolean medium;
	private boolean high;
	private int duration;
	
	boolean isLow() {
		return low;
	}
	void setLow() {
		high = false;
		medium = false;
		low = true;
	}
	boolean isMedium() {
		return medium;
	}
	void setMedium() {
		high = false;
		low = false;
		medium = true;
	}
	
	boolean isHigh() {
		return high;
	}
	void setHigh() {
		medium = false;
		low = false;
		high = true;
	}
	
	int getDuration() {
		return duration;
	}
	void setDuration(int duration) {
		this.duration = duration;
	}

	int calcCaloriesBurned(int activity, int duration, double BMI) {
		//formula
		return 0;
	}

	
	
}
