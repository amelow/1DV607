package theYachtClub;

public class Boat {
	private int length;
	private String type;

	public Boat() {

	}

	public Boat(String Type, int Length) {
		this.type = Type;
		this.length = Length;
	}

	public void setLength(int Length) {
		this.length = Length;
	}

	public int getLength() {
		return this.length;
	}
	

}
