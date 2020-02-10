package model;

public class BoatLength {

	public double feetToMeters(double feet) {
		double meters = feet * 0.3048;
		return meters;
		
	}
	public double metersToFeet(double meters) {
		double feet= meters/0.3048;
		return feet;
	}
}
