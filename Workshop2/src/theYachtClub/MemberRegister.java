package theYachtClub;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemberRegister {
	private long id = 1040;
	private int amountOfMembers;
	private ArrayList<Member> memList = new ArrayList<Member>();

	public void CreateMember(String name, String num) {
		Member member = new Member(name, num);
		AddMember(member);
	}

	public void AddMember(Member member) {
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

	}

	public void GetMember() {

	}

	public void SaveMember() {

	}

	public void UpdateName() {

	}

	public void UpdatePersonNum() {

	}
	
	public ArrayList<Member> getMemberList() {
		return memList;
	}
	
	
}
