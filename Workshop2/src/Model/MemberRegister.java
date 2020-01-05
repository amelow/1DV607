package Model;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberRegister {
	private int id = 1040; // start at 1040 and not 1 so i cannot be so easily guessed
	private ArrayList<Member> memList = new ArrayList<Member>();/

	public MemberRegister() {
		this.memList = new ArrayList<Member>();
	}

	public void CreateMember(String name, String num) {
		Member member = new Member(name, num, id);
		addMember(member);
	}

	public void addMember(Member member) {
		memList.add(member);
		id++; // incrementing the Id so next member has a new ID
	}

	public void addMemberList(Member m, int idM) {
		memList.add(m);
		id = idM;
		id++;
	}

	public void deleteMember(int id) {
		memList.remove(id);
	}

	public Member getMember(int a_id) {
		for (Member m : memList) {
			if (m.getId() == a_id) {
				return m;
			}
		}

		return null;
	}

	public Iterator<Member> getMemberList() {
		return memList.iterator();
	}

	public boolean checkIfPersonNumExists(String personNumberAsString) {
		for (int i = 0; i < memList.size(); i++) {
			if (personNumberAsString.equals(memList.get(i).getPersonNum())) {
				return true;
			}

		}
		return false;
	}

	public int getMemberIndex4Id(int memberId) {
		for (int i = 0; i < memList.size(); i++) {
			if (memberId == memList.get(i).getID()) {
				return i;
			}
		}
		return -1;
	}

	public boolean checkLengthOfPersonNum(int lengthOfPersonNum) {
		if (lengthOfPersonNum == 12) {
			return true;
		}
		return false;
	}

	public void changeName(int i, String newName) {
		memList.get(i).setName(newName);
	}

	public boolean addBoatToMember(int memberIndex, int lengthOfBoat, String boatType) {
		try {
			Member member = memList.get(memberIndex);
			member.addBoat(BoatTypes.getBoatType(boatType), lengthOfBoat);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean deleteBoatFromMember(int memberIndex, int boatIndex) {
		try {
			Member member = memList.get(memberIndex);
			member.getBoatList().remove(boatIndex);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean changeBoatMember(int memberIndex, int boatIndex, int lengthOfBoat, String boatType) {
		try {
			Member member = memList.get(memberIndex);
			Boat boat = member.getBoatList().get(boatIndex);
			boat.setLength(lengthOfBoat);
			boat.setType(BoatTypes.getBoatType(boatType));
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

}