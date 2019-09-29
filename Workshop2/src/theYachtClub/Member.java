package theYachtClub;

import java.util.ArrayList;

public class Member implements MemberInterface {

	private String name;
	private String personNum;
	private int amountOfBoats;
	private int memberId;

	private ArrayList<Boat> boatList = new ArrayList<Boat>();

	/*
	 * public Member() { }
	 */

	public Member(String Name, String num) {
		this.name = Name;
		this.personNum = num;
	}

	@Override
	public void setName(String Name) {
		this.name = Name;

	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setPersonNum(String num) {
		this.personNum = num;

	}

	@Override
	public String getPersonNum() {
		return personNum;
	}

	@Override
	public void setID(int memberID) {
		this.memberId = memberID;

	}

	@Override
	public int getID() {
		return memberId;
	}

	@Override
	public void setAmountOfBoats(int amount) {
		this.amountOfBoats = amount;

	}

	@Override
	public int getAmountOfBoats() {
		return amountOfBoats;
	}

	public void addBoat(BoatTypes t, int l) {
		Boat boat = new Boat(t, l);
		boatList.add(boat);
		amountOfBoats++;
	}

	public void deleteBoat(int removeBoat) {
		boatList.remove(removeBoat);
		amountOfBoats--;
	}

	public ArrayList<Boat> getBoatList() {
		return new ArrayList<Boat>(boatList);
	}
}