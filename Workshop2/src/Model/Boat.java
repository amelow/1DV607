package model;

public class Boat {
	private double length;
	private BoatTypes type;

	public Boat(BoatTypes type, double lengthOfBoat) {
		this.type = type;
		this.length = lengthOfBoat;
	}

	public void setLength(int length) {
		if (length >= 0) {
			this.length = length;
		}
	}

	public double getLength() {
		return this.length;
	}

	public void setType(BoatTypes type) {
		this.type = type;
	}

	public BoatTypes getType() {
		return this.type;
	}
	
	public double feetToMeters(double feet) {
		double meters = feet * 0.3048;
		return meters;
		
	}
	public double metersToFeet(double meters) {
		double feet= meters/0.3048;
		return feet;
	}

}
