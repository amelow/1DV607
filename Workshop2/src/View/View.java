package View;

import java.util.ArrayList;

import Model.Member;
import Model.MemberRegister;

/*
 * The view class handles most of the printouts the user gets in the console
 */
public class View {

	private MemberRegister model;

	public View(MemberRegister model) {
		this.model = model;
	}

	public void welcomeMessage() {
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

	public void addName() {
		System.out.println("Please enter your name (end with enter and -1: ");

	}

	public void changName() {
		System.out.println("Please enter your new name (end with enter and -1: ");

	}

	public void addPersonNum() {
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

	public void correctBoatInfo(String typeOfBoat, String lengthOfBoat) {
		System.out.println("Is " + typeOfBoat + " and length " + lengthOfBoat + " correct?(y/n)");

	}

	public void saveMember(String str, long id) {
		String save = "Do you want to save the member with name " + str + " and personal number " + id + "?(y/n)";
		System.out.println(save);
	}

	public void memberSaved() {
		String saved = "---The member is now saved---";
		System.out.println(saved + "\n");
	}

	public void deleteMember() {
		System.out.println("Are you sure? Do you want to delete the member? (y/n)");
	}

	public void memberDeleted() {
		System.out.println("---The member gets deleted---");
		System.out.println("\n");
	}

	public void deletedBoat(String deletedBoat) {
		System.out.println(deletedBoat);
	}

	public void changeBoat() {
		System.out.println("Which boat should be changed? select the number infront of the boat type");
	}

	public void typeOfBoat() {
		System.out.println("Type of boat? Choose between: Sailboat, Motorsailer, Kayak, Canoe and Other");
	}

	public void selectID() {
		String chooseID = "Select the member ID of the member that should be changed";
		System.out.println(chooseID);

	}

	public void selectBoatToDelete() {
		System.out.println("Which boat do you want to delete? select the number infront of boat type");

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

	public void printMemListForChange(String listM) { // dependancy to member
		System.out.println(listM);
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
		System.out.println("Wrong format!It should be like: YYYYMMDDXXXX");

	}

	public void userExist() {
		System.out.println("Person number exist - returns to start menu");

	}

	public void saveAndQuit() {
		System.out.println("Are you sure? Do you want to save and exit the application? (y/n)");
	}

	public void listMembersBoats(String listOfBoatsPrintOuts) {
		System.out.println(listOfBoatsPrintOuts);

	}

	public void compactListView() {
		ArrayList<String> compact = new ArrayList<String>();
		ArrayList<Member> memList = model.getMemberList();

		for (int i = 0; i < memList.size(); i++) {// loops thru the register
			compact.add("Name: " + memList.get(i).getName() + " " + "ID: " + memList.get(i).getID() + " " + "Boats: "
					+ memList.get(i).getAmountOfBoats());
		}
		compact.forEach(System.out::println);
	}

	public void verboseListView() {
		ArrayList<String> verbose = new ArrayList<String>();
		ArrayList<Member> memList = model.getMemberList();
		String lineBreak = ("-----------------------------------------------------------------------\n");
		for (int i = 0; i < memList.size(); i++) {// loops thru the register and prints the information
			verbose.add(lineBreak + " Name: " + memList.get(i).getName() + " Personal Number: "
					+ memList.get(i).getPersonNum() + " ID: " + memList.get(i).getID() + " Number of Boats: "
					+ memList.get(i).getAmountOfBoats());
			if (memList.get(i).getAmountOfBoats() > 0) {// checks if user has 1 or more boats
				for (int j = 0; j < memList.get(i).getAmountOfBoats(); j++) { // loops thru the boats
					verbose.add(lineBreak + " Type: " + memList.get(i).getBoatList().get(j).getType() + " Length: "
							+ memList.get(i).getBoatList().get(j).getLength());
				}
			}
		}
		verbose.forEach(System.out::println);

	}

	public void addBoatLength() {
		System.out.println("length of boat?");

	}

	public void changeTheBoat(String whatToChange) {
		System.out.println(whatToChange);

	}

	public void changeBoatTL(String change) {
		System.out.println(change);

	}

	public void boatSel(String userIn) {
		System.out.println("Boat selected is:" + userIn);

	}

	public void boatUpdated(String updated) {
		System.out.println(updated);

	}

}