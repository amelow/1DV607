package Model;

import java.util.ArrayList;

public class MemberRegister {
	// Declaring/Initiating the variables
	private int id = 1040; // start at 1040 and not 1 so i cannot be so easily guessed
	private ArrayList<Member> memList = new ArrayList<Member>();// the memlist that saves the members

	public MemberRegister() {
		this.memList = new ArrayList<Member>();
		// this.id = 0;
	}

	public void CreateMember(String name, String num) {
		Member member = new Member(name, num, id);
		addMember(member);
	}

	public void addMember(Member member) {
		memList.add(member);
		id++;// incrementing the Id so next member has a new ID
	}

	/*
	 * public void addMemberList(Member m, int idM) { memList.add(m); id = idM;
	 * id++; }
	 */
	public void deleteMember(int id) {
		memList.remove(id);// removes the member with the right Id

	}

	public Member GetMember(int a_id) {
		for (Member m : memList) {
			if (m.GetId() == a_id) {
				return m;
			}
		}

		return null;
	}

	/*
	 * public Member getMember(int id) { // get the member by the id int index = -1;
	 * for (int i = 0; i < memList.size(); i++) { Member testmem = memList.get(i);
	 * if (testmem.getID() == id) { index = i; } } if (index == -1) { return null; }
	 * else { return memList.get(index); } }
	 */
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
				return true;
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
		for (int i = 0; i < memList.size(); i++) {
			if (i == id) {
				memList.get(i).addBoat(BoatTypes.getBoatType(typeOfBoat), Integer.parseInt(lengthOfBoat));
			}
		}

	}

	public String boatFromMemberList(int userIndex) {
		String listOfBoats = "";
		for (int i = 0; i < memList.get(userIndex).getBoatList().size(); i++) {
			listOfBoats = listOfBoats + i + " " + memList.get(userIndex).getBoatList().get(i).getType() + " "
					+ memList.get(userIndex).getBoatList().get(i).getLength() + "\n";
		}
		return listOfBoats;
	}

	public String deleteBoatFromMember(int index, int deleteBoat) {
		for (int i = 0; i < memList.get(index).getBoatList().size(); i++) {
			String c = i + " " + memList.get(index).getBoatList().get(i);
			String r = deleteBoat + " " + memList.get(index).getBoatList().get(i);
			if (c.equals(r)) {
				memList.get(index).deleteBoat(i);
				return "Boat is deleted";

			}

		}
		return "Boat is not deleted";
	}

	public String changeBoatMember(int index, int boat, int length, String userIn) {
		memList.get(index).getBoatList().get(boat).setLength(length);
		memList.get(index).getBoatList().get(boat).setType(BoatTypes.getBoatType(userIn));
		return "Updated";

	}

}