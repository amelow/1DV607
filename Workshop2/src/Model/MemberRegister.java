package Model;

import java.util.ArrayList;

/*
 * Member register handles all of the member-related actions,
 * for example CreateMember,AddMember,DeleteMember, GetMember etc
 */
public class MemberRegister {
	// Declaring/Initiating the variables
	private int id = 1040; // start at 1040 and not 1 so i cannot be so easily guessed
	private ArrayList<Member> memList = new ArrayList<Member>();// the memlist that saves the members
	private int firstId = 1040;

	/*
	 * Creating a member with a name and a personal number, then calling the add
	 * member method
	 */
	public void CreateMember(String name, String num) {
		Member member = new Member(name, num, id);
		addMember(member);
	}

	/*
	 * Method that adds the new member to the list with a unique Id. Id starts at
	 * 1040
	 */
	public void addMember(Member member) {
		memList.add(member);
		id++;// incrementing the Id so next member has a new ID
	}

	/*
	 * Method that handles the delete member functionality
	 */
	public void deleteMember(int number) {
		memList.remove(number);// removes the member with the right Id

	}

	/*
	 * Method for prepping the Compact List with the members Name, Member id and
	 * Number of boats, gets printed in the view
	 */
	public ArrayList<Object> CompactList() {
		ArrayList<Object> memberCompact = new ArrayList<Object>();
		for (int i = 0; i < memList.size(); i++) {// loops thru the register
			memberCompact.add("Name: " + memList.get(i).getName() + " " + "ID: " + memList.get(i).getID() + " "
					+ "Boats: " + memList.get(i).getAmountOfBoats());
		}
		return memberCompact;
	}

	/*
	 * Method for prepping the Verbose List with the members Name, Personal number,
	 * Member id and Boats with boat information, gets printed in the view
	 */
	public ArrayList<Object> verboseList() {
		ArrayList<Object> verbose = new ArrayList<Object>();
		String lineBreak = ("---------------------------------------\n");
		for (int i = 0; i < memList.size(); i++) {// loops thru the register and prints the information
			verbose.add(lineBreak + " Name: " + memList.get(i).getName() + " Personal Number: "
					+ memList.get(i).getPersonNum() + " ID: " + memList.get(i).getID() + " Number of Boats: "
					+ memList.get(i).getAmountOfBoats());
			if (memList.get(i).getAmountOfBoats() > 0) {// checks if user has 1 or more boats
				for (int j = 0; j < memList.get(i).getAmountOfBoats(); j++) { // loops thru the boats
					verbose.add(lineBreak + " Type: " + memList.get(i).getBoatList().get(j).getType() + " Length: "
							+ memList.get(i).getBoatList().get(j).getLength());
				}
			}
		}
		return verbose;
	}

	public long getID() { // returns the members id
		return id;
	}

	public Member getMember(int id) { // get the member by the id
		int index = -1;
		for (int i = 0; i < memList.size(); i++) {
			Member testmem = memList.get(i);
			if (testmem.getID() == id) {
				index = i;
			}
		}
		if (index == -1) {
			return null;
		} else {
			return memList.get(index);
		}
	}

	public ArrayList<Member> getMemberList() { // returns the entire member registry list
		return memList;
	}

	public String getMemberListAsString() {
		String listOfMembers = "";
		for (int i = 0; i < memList.size(); i++) {
			String name = memList.get(i).getName();
			int id = memList.get(i).getID();
			listOfMembers = listOfMembers + "\n" + "Name: " + name + " Memberid: " + id;
		}
		return listOfMembers;
	}

	public boolean checkIfPersonNumExists(String personNumberAsString) {
		for (int i = 0; i < memList.size(); i++) { // checks the personal number if user exists
			if (personNumberAsString.equals(memList.get(i).getPersonNum())) {
				return false;
			}

		}
		return false;
	}

	public boolean checkLengthOfPersonNum(int lengthOfPersonNum) {
		if (lengthOfPersonNum == 12) {
			return true;
		}
		return false;

	}

	public String changeName(int i, String newName) {
		memList.get(i).setName(newName);
		return newName;
	}

	public void addBoatToMember(int id, String typeOfBoat, String lengthOfBoat) {
				memList.get(id-this.firstId).addBoat(BoatTypes.getBoatType(typeOfBoat), Integer.parseInt(lengthOfBoat));
	}

}