package theYachtClub;

import java.util.ArrayList;

public class Member {
	private String name;
	private String personNum;
	private int amountOfBoats;
	private int memberId;

	ArrayList<Boat> boats = new ArrayList<Boat>();

	/*
	 * Constructors
	 */
	public Member() {
	}

	public Member(String Name, String num) {
		this.name = Name;
		this.personNum = num;
	}

	// Getter and Setter for Name
	public void setName(String Name) {
		this.name = Name;
	}

	public String getName() {
		return this.name;
	}

	// Getter and Setter for Personal number
	public void setPersonNum(String num) {
		this.personNum = num;

	}

	public String getPersonNum() {
		return personNum;
	}

	// Getter and Setter for The amount of Boats
	public void setAmountOfBoats(int amount) {
		this.amountOfBoats = amount;
	}

	public int getAmountOfBoats() {
		return amountOfBoats;
	}

	// Getter and Setter for Id number
	public void setID(int id) {
		this.memberId = id;
	}

	public int getID() {
		return memberId;
	}

	public void addBoat() {
		amountOfBoats++;

	}

	public void deleteBoat() {
		amountOfBoats--;
	}

}
