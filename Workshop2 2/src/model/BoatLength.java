package model;

public class BoatLength {
	
	//internally always captured in meters
	double length;
	
	public double getLengthInMeters() {
		return length;
	}

	public void setLengthInMeters(double length) {
		this.length = length;
	}

	public double getLengthInFeet() {
		return metersToFeet(length);
	}

	public void setLengthInFeet(double length) {
		this.length = feetToMeters(length);
	}

	static double feetToMeters(double feet) {
		double meters = (feet * 0.3048);
		return meters;

	}

	static double metersToFeet(double meters) {
		double feet = (meters / 0.3048);
		return feet;
	}
}
