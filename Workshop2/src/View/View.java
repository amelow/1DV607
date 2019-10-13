package View;

import java.util.ArrayList;

import Model.Member;

/*
 * The view class handles most of the outprints the user gets in the console
 */
public class View {

	public void welcome() {
		String hi = "Hi and Welcome!" + "\n";
		System.out.println(hi);

	}

	public void mainMenu() {
		String choose = "What do you want to do?";
		String alt1 = "To add a member, enter (1)";
		String alt2 = "To change member info, enter(2)";
		String alt3 = "To show the compactlist, enter(3)";
		String alt4 = "To show the verboselist, enter(4)";
		String quit = "To quit the application, enter (Q)";

		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(quit);
	}

	public void AddName() {
		System.out.println("Please enter your name: ");

	}

	public void AddPersonNum() {
		System.out.println("Please enter your personal-number: YYYYMMDDXXXX");
	}

	public void correctName(String str) {
		String nameQ = "Is this correct? Your name is: " + str + " (y/n)";

		System.out.println(nameQ);
	}

	public void correctPersonNum(long id) {
		String idPer = "Is this correct? Your person number is: " + id + " (y/n)";

		System.out.println(idPer);
	}

	public void saveMember(String str, long id) {
		String save = "Do you want to save the member with name " + str + " and personal number " + id + "?(y/n)";
		System.out.println(save);
	}
	public void memberSaved() {
		String saved = "--The member is now saved--";
		System.out.println(saved + "\n");

	}

	public void typeID() {
		String chooseID = "Select the member ID of the member that should be changed";
		System.out.println(chooseID);

	}

	public void changeMem() {
		String choose = "What do you want to do?";
		String alt1 = "To add a boat, enter(1)";
		String alt2 = "To delete a boat, enter(2)";
		String alt3 = "To change the boat info, enter(3)";
		String alt4 = "To change your name, enter(4)";
		String alt5 = "To delete a member, enter(5)";
		String quit = "To quit the application, enter(Q)";

		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(alt5);
		System.out.println(quit);

	}

	public void printMemListForChange(ArrayList<Member> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			String name = arrayList.get(i).getName();
			int id = arrayList.get(i).getID();
			String change = "Name: " + name + " Memberid: " + id;
			System.out.println(change);
		}

	}

	public void noChanges() {
		String no = "No changes made, prints the list of members again";

		System.out.println(no);
	}

	public void changes() {
		String yes = "Changes made, will show the start menu";

		System.out.println(yes);
	}

	public void noUser() {
		String noUser = "No user with that MemID, select again";

		System.out.println(noUser);
	}

	public void wrongFormat() {
		System.out.println("Wrong format should be YYYYMMDDXXXX");

	}

	public void userExist() {
		System.out.println("Person number exist - returns to start menu");

	}

}