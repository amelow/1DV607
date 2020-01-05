package Model;

/*
 * The Boat class gets the methods to implement from the BoatInterface
 */
public class Boat {
	private double length;
	private BoatTypes type;

	// Constructors for the BoatClass
//	public Boat() {

//	}

	public Boat(BoatTypes Type, double Length) {
		this.type = Type;
		this.length = Length;
	}

	public void setLength(double Length) {
		if (Length > 0) { // Minimum value of boat is 0
			this.length = Length;
		}
	}

	public double getLength() {
		return this.length;
	}

	public void setType(BoatTypes Type) {
		this.type = Type;
	}

	public BoatTypes getType() {
		return this.type;
	}

}
