package theYachtClub;

public class Boat {
	private int length;
	private BoatTypes type;

	public Boat() {

	}

	public Boat(BoatTypes Type, int Length) {
		this.type = Type;
		this.length = Length;
	}

	public void setLength(int Length) {
		this.length = Length;
	}

	public int getLength() {
		return this.length;
	}
	public void setType(BoatTypes Type) {
		this.type = Type;
		
	}
	public BoatTypes getType() {
		return this.type;
	}

}
