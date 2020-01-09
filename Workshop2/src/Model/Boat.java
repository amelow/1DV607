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

}
