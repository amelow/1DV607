package theYachtClub;

import java.util.ArrayList;

public class MemberRegister {
	private int id = 1040;
	private int amountOfMembers;
	private Member mem;
	private ArrayList<Member> memList = new ArrayList<Member>();

	public void CreateMember(String name, String num) {
		Member member = new Member(name, num);
		AddMember(member);
	}

	public void AddMember(Member member) {
		member.setID(id);
		memList.add(member);
		amountOfMembers++;
		id++;
		System.out.println("Size of memlist: " + memList.size());
		for (int i = 0; i < memList.size(); i++) {
			System.out.println(memList.get(i).getName());
		}

	}

	public void DeleteMember(int number) {
		memList.remove(number);
		amountOfMembers--;

	}

	/*
	 * “Compact List”; name, member id and number of boats
	 */
	public void CompactList() {
		for (int i = 0; i < memList.size(); i++) {
			System.out.println("Name: " + memList.get(i).getName() + " " + "ID: " + memList.get(i).getID() + " "
					+ "Boats: " + memList.get(i).getAmountOfBoats());

		}

	}

	/*
	 * “Verbose List”; name, personal number, member id and boats with boat
	 * information
	 */
	public void printVerbose() {
		for (int i = 0; i < memList.size(); i++) {
			System.out.println("Name: " + memList.get(i).getName() + "Personal-number: " + memList.get(i).getPersonNum()
					+ "ID: " + memList.get(i).getID() + "Boats: " + memList.get(i).getAmountOfBoats() + "Type: "
					+ memList.get(i));

		}

	}

	public long getID() {
		return id;

	}

	public void getBoats(int boats) {
		//.addBoat(null, amountOfMembers);
	}

	/*
	 * public void GetMember() {
	 * 
	 * }
	 * 
	 * public void SaveMember() {
	 * 
	 * }
	 * 
	 * public void UpdateName() {
	 * 
	 * }
	 * 
	 * public void UpdatePersonNum() {
	 * 
	 * }
	 */
	public ArrayList<Member> getMemberList() {
		return memList;
	}

}
