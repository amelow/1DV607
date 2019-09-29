package theYachtClub;

import java.util.ArrayList;

public class MemberRegister {
	private long id = 1040;
	private int amountOfMembers;
	private ArrayList<Member> memList = new ArrayList<Member>();

	public void AddMember(Member member) {
		memList.add(member);
		amountOfMembers++;
		id++;

	}

	public void DeleteMember(Member member) {
		memList.remove(member);

	}

	public void GetMember() {

	}

	public void SaveMember() {

	}
}
