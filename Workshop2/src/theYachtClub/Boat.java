package theYachtClub;

public class Boat {
	private int length;
	private Enum type;

	public Boat() {

	}

	public Boat(Enum Type, int Length) {
		this.type = Type;
		this.length = Length;
	}

	public void setLength(int Length) {
		this.length = Length;
	}

	public int getLength() {
		return this.length;
	}
	//public void 

}
