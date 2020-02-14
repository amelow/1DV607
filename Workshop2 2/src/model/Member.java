package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * The member class, handles all of the information that a member needs to get added into the register
 */
public class Member {
	private String name;
	private String personNum;
	private int memberId;
	private List<Boat> boatList = new ArrayList<Boat>();

	public Member(String Name, String num, int id) {
		this.name = Name;
		this.personNum = num;
		this.memberId = id;
	}

	public Member() {

	}

	public void setName(String Name) {
		this.name = Name;

	}

	public String getName() {
		return this.name;
	}

	public void setPersonNum(String num) {
		this.personNum = num;

	}

	public String getPersonNum() {
		return personNum;
	}

	public int getID() {
		return memberId;
	}

	public int getAmountOfBoats() {
		return boatList.size();
	}

	public void addBoat(BoatTypes type, BoatLength lengthOfBoat) {
		Boat boat = new Boat(type, lengthOfBoat);
		boatList.add(boat);

	}

	public void deleteBoat(int removeBoat) { 
		boatList.remove(removeBoat);

	}

	public Iterator<Boat> getBoatList() {
		return boatList.iterator();
	}

	public int getId() {
		return memberId;
	}
}