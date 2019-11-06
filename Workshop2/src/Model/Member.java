package Model;

import java.util.ArrayList;
import java.util.List;

/*
 * The member class, handles all of the information that a member needs to get added into the register
 */
public class Member implements MemberInterface {
	// Declaring and Initializing the variables
	private String name;
	private String personNum;
	private int memberId;
	private List<Boat> boatList = new ArrayList<Boat>(); // the list for saving the amount of boats

	public Member(String Name, String num, int id) {
		this.name = Name;
		this.personNum = num;
		this.memberId = id;
	}

	public Member() {

	}

	@Override
	public void setName(String Name) { // adding a name
		this.name = Name;

	}

	@Override
	public String getName() { // getting the name
		return this.name;
	}

	@Override
	public void setPersonNum(String num) { // adding the personal number
		this.personNum = num;

	}

	@Override
	public String getPersonNum() { // getting the personal number
		return personNum;
	}

//	@Override
//	public void setID(int memberID) { // Setting the users personal id number
//		this.memberId = memberID;
//
//	}

	@Override
	public int getID() { // Getting the users personal id number
		return memberId;
	}

	@Override
	public int getAmountOfBoats() { // getting the boatlist size
		return boatList.size();
	}

	public void addBoat(BoatTypes t, int l) {
		Boat boat = new Boat(t, l);// new boat with a type and length
		boatList.add(boat); // adding it to the arraylist so it gets saved

	}

	public void deleteBoat(int removeBoat) { // Deleting the boat
		boatList.remove(removeBoat);// removing it from the boatlist register

	}

	public List<Boat> getBoatList() {
		return new ArrayList<Boat>(boatList);// returns the boat register list
	}
}