package theYachtClub;

public class Boat implements BoatInterface {
	private double length;
	private BoatTypes type;

	public Boat() {

	}

	public Boat(BoatTypes Type, double Length) {
		this.type = Type;
		this.length = Length;
	}

	@Override
	public void setLength(double Length) {
		if (Length > 0) {

		}
		this.length = Length;

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
