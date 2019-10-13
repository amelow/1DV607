package Model;

/*
 * The Boat class gets the methods to implement from the BoatInterface
 */
public class Boat implements BoatInterface {
	private double length;
	private BoatTypes type;

	// Constructors for the BoatClass
	public Boat() {

	}

	public Boat(BoatTypes Type, double Length) {
		this.type = Type;
		this.length = Length;
	}

	/*
	 * Getters and Setters for the boatinformation: The type of boat and the length
	 * of the boat
	 */
	@Override
	public void setLength(double Length) {
		if (Length > 0) { // Minimum value of boat is 0
			this.length = Length;
		}
	}

	@Override
	public double getLength() {
		return this.length;
	}

	@Override
	public void setType(BoatTypes Type) {
		this.type = Type;
	}

	@Override
	public BoatTypes getType() {
		return this.type;
	}
}
