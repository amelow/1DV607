package model;

public class Boat {
	private BoatLength length;
	private BoatTypes type;

	public Boat(BoatTypes type, BoatLength lengthOfBoat) {
		this.type = type;
		this.length = lengthOfBoat;
	}

	public void setLength(BoatLength length) {
		if (length.getLengthInMeters() >= 0) {
			this.length = length;
		}
	}

	public BoatLength getLength() {
		return this.length;
	}

	public void setType(BoatTypes type) {
		this.type = type;
	}

	public BoatTypes getType() {
		return this.type;
	}

}
