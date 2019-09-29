package theYachtClub;

import java.util.ArrayList;

public class MemberRegister {
	private long id;
	private int amountOfMembers;
	private ArrayList<Member> memList = new ArrayList<Member>();

	public void AddMember(Member member) {
		memList.add(member);
		amountOfMembers++;

	}

	public void DeleteMember() {

	}

	public void GetMember() {

	}

	public void SaveMember() {

	}
}
