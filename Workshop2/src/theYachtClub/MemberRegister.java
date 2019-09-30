package theYachtClub;

import java.util.ArrayList;

public class MemberRegister {
	private long id = 1040;
	private int amountOfMembers;
	private ArrayList<Member> memList = new ArrayList<Member>();

	public void CreateMember(String name, String num) {
		Member member = new Member(name, num);
	}

	public void AddMember(Member member) {
		memList.add(member);
		amountOfMembers++;
		id++;

	}

	public void DeleteMember(int number) {
		memList.remove(number);

	}

	public void GetMember() {

	}

	public void SaveMember() {

	}

	public void UpdateName() {

	}

	public void UpdatePersonNum() {

	}
}
