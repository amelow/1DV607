package theYachtClub;

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

	public void added() {
		String added = "--The member is now added--";
		System.out.println(added);

	}

	public void memberSaved() {
		String saved = "--The member is now saved--";
		System.out.println(saved);

	}

	public void typeID() {
		String chooseID = "Select the member ID of the member that should be changed";
		System.out.println(chooseID);

	}

	public void changeMem() {
		String choose = "What do you want to do?";
		String alt1 = "To add a boat, enter(1)";
		String alt2 = "To delete a boat, enter(2)";
		String alt3 = "To change your name, enter(3)";
		String quit = "To quit the application, enter(Q)";

		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(quit);

	}

	public void printMemList() {
		System.out.print("Should print a list - TO BE DONE");

	}
	
	public void printListMenu() {
		System.out.println("The Compact list:" + "\n");
		System.out.println("To see the verboselist, enter(1)");
		System.out.println("To go back to the main menu,enter(2)");
	}

}