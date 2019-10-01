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
			System.out.println("Name: " + memList.get(i).getName() + " " + "ID: " + memList.get(i).getID()+ " "+ "Boats: " + memList.get(i).getAmountOfBoats());
			
		}

	}

	/*
	 * “Verbose List”; name, personal number, member id and boats with boat
	 * information
	 */
	public void printVerbose() {
		for (int i = 0; i < memList.size(); i++) {
			System.out.println("---------------------------------------");
			System.out.println("Name: "+memList.get(i).getName());
			System.out.println("Personal Number: "+memList.get(i).getPersonNum());
			System.out.println("ID: "+memList.get(i).getID());
			System.out.println("Number of Boats: "+memList.get(i).getAmountOfBoats());
			if (memList.get(i).getAmountOfBoats() >0) {
				System.out.println("Registered Boats");
				System.out.println("-----------------------------------");
				for (int j = 0; j <memList.get(i).getAmountOfBoats(); j++) {
					System.out.println("Type: "+memList.get(i).getBoatList().get(j).getType());
					System.out.println("Length: "+memList.get(i).getBoatList().get(j).getLength());
					System.out.println(" ");	
				}
				System.out.println("-----------------------------------");	
			}
			System.out.println("----------------------------------------");
		}

	}

	public long getID() {
		return id;

	}
	
	public Member getMember(int id) {
		int index = -1;
		for (int i = 0; i <memList.size(); i++) {
			Member testmem = memList.get(i);
			if (testmem.getID() == id) {
				index = i;
			}
		}
		if (index == -1) {
			return null;
		}else {
			return memList.get(index);
		}
		
		
	}
	public ArrayList<Member> getMemberList() {
		return memList;
	}

}
