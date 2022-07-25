package application;

public class Activity {

	private boolean low; 
	private boolean medium;
	private boolean high;
	private int duration;
	
	boolean isLow() {
		return low;
	}
	void setLow(boolean low) {
		this.low = low;
	}
	boolean isMedium() {
		return medium;
	}
	void setMedium(boolean medium) {
		this.medium = medium;
	}
	
	boolean isHigh() {
		return high;
	}
	void setHigh(boolean high) {
		this.high = high;
	}
	
	int getDuration() {
		return duration;
	}
	void setDuration(int duration) {
		this.duration = duration;
	}

	int calcCaloriesBurned(int activity, int duration, double BMi) {
		return 0;
	}

	
	
}
