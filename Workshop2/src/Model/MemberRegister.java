package model;

import java.util.ArrayList;
import java.util.Iterator;

public class MemberRegister {
	private int id = 1040; // start at 1040 and not 1 so i cannot be so easily guessed
	private ArrayList<Member> memList = new ArrayList<Member>();

	public MemberRegister() {
		this.memList = new ArrayList<Member>();
	}

	public void CreateMember(String name, String num) {
		Member member = new Member(name, num, id);
		addMember(member);
	}

	public void addMember(Member member) {
		addMember(member, id);
	}

	public void addMember(Member member, int memberId) {
		memList.add(member);
		id = memberId;
		id++;
	}

	public void deleteMember(int memberId) {
		int memberIndex = getMemberIndex4Id(memberId);
		memList.remove(memberIndex);
	}

	public Member getMember(int memberId) {
		for (Member m : memList) {
			if (m.getId() == memberId) {
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

	public boolean existsMemberIndex(int memberId) {
		for (int i = 0; i < memList.size(); i++) {
			if (memberId == memList.get(i).getID()) {
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

	public void changeName(int memberId, String newName) {
		int memberIndex = getMemberIndex4Id(memberId);
		memList.get(memberIndex).setName(newName);
	}

	public boolean addBoatToMember(int memberId, double lengthOfBoat, String boatType) {
		int memberIndex = getMemberIndex4Id(memberId);
		try {
			Member member = memList.get(memberIndex);
			member.addBoat(BoatTypes.getBoatType(boatType), lengthOfBoat);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean deleteBoatFromMember(int memberId, int boatIndex) {
		int memberIndex = getMemberIndex4Id(memberId);
		try {
			Member member = memList.get(memberIndex);
			member.deleteBoat(boatIndex - 1);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public boolean changeBoatMember(int memberId, int boatIndex, int lengthOfBoat, String boatType) {
		int memberIndex = getMemberIndex4Id(memberId);
		try {
			Member member = memList.get(memberIndex);
			member.deleteBoat(boatIndex - 1);
			member.addBoat(BoatTypes.getBoatType(boatType), lengthOfBoat);
			return true;
		} catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	private int getMemberIndex4Id(int memberId) {
		for (int i = 0; i < memList.size(); i++) {
			if (memberId == memList.get(i).getID()) {
				return i;
			}
		}
		return -1;
	}
}