package View;

import java.util.ArrayList;

import Model.Member;

/*
 * The view class handles most of the printouts the user gets in the console
 */
public class View {

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
		System.out.println("Please enter your name: ");

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

	public void deletedBoat() {
		System.out.println("---Boat is deleted, back to the main menu---");
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

	public void printMemListForChange(ArrayList<Member> arrayList) {
		for (int i = 0; i < arrayList.size(); i++) {
			String name = arrayList.get(i).getName();
			int id = arrayList.get(i).getID();
			String change = "Name: " + name + " Memberid: " + id;
			System.out.println(change);
		}

	}
	public void compactListView(ArrayList<Object> compact) {
        compact.forEach(System.out::println);
       
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

	public void saveAndQuit() {
		System.out.println("Are you sure? Do you want to save and exit the application? (y/n)");
	}

	public void listMembersBoats(String listOfBoatsPrintOuts) {
		System.out.println(listOfBoatsPrintOuts);

	}

}