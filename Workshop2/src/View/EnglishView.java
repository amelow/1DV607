package view;

import java.util.Iterator;
import java.util.Scanner;

import model.Boat;
import model.Member;
import model.MemberRegister;

/*
 * The view class handles most of the printouts the user gets in the console
 */
public class EnglishView implements IView {

	private MemberRegister memberRegistry;
	private Scanner scan;

	public EnglishView(MemberRegister memberRegistry) {
		this.scan = new Scanner(System.in);
		this.memberRegistry = memberRegistry;
	}
	

	public void welcomeMessage() {
		System.out.println(" ____________________");
		System.out.println("|                    |");
		System.out.println("|  Hi and Welcome!   |");
		System.out.println("|____________________|");
		System.out.println();
	}

	public MainMenuOptions mainMenu() {
		String choose = "What do you want to do?";
		String alt1 = "To show the verboselist, enter(a)";
		String alt2 = "To show the compactlist, enter(b)";
		String alt3 = "To add a member, enter (c)";
		String alt4 = "To change member info, enter(d)";
		String alt5 = "To save and quit the application, enter (q)";

		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(alt5);
		String userIn = scan.next();
		switch (userIn) {
		case ("a"):
			return MainMenuOptions.showVerbose;
		case ("b"):
			return MainMenuOptions.showCompact;
		case ("c"):
			return MainMenuOptions.addMember;
		case ("d"):
			return MainMenuOptions.changeMember;
		case ("q"):
			return MainMenuOptions.quitApp;
		}
		return MainMenuOptions.others;
	}

	public void addName() {
		System.out.println("Please enter your name (end with enter and -1: )");

	}

	public void changName() {
		System.out.println("Please enter your new name (end with enter and -1: )");

	}

	public void addPersonNum() {
		System.out.println("Please enter your personal-number: (YYYYMMDD-XXXX)");
	}

	public void correctBoatInfo(String typeOfBoat, double lengthOfBoat) {
		System.out.println("Is " + typeOfBoat + " and length: " + lengthOfBoat + " feet correct? (y/n)");

	}

	public void saveMember(String str, long id) {
		String save = "Do you want to save the member with name " + str + " and personal number " + id + "?(y/n)";
		System.out.println(save);
	}

	public void memberSaved() {
		String saved = "---The member is now saved---";
		System.out.println(saved + "\n");
	}


	public void memberDeleted() {
		System.out.println("---The member gets deleted---");
		System.out.println("\n");
	}

	public void deletedBoat(boolean deletedBoat) {
		if (deletedBoat)
			System.out.println("Boat is deleted");
		else
			System.out.println("Boat is NOT deleted");
	}

	public void changeBoat() {
		System.out.println("Which boat should be changed? select the number infront of the boat type");
	}

	public String typeOfBoat() {
		System.out.println("Type of boat? Choose between: Sailboat, Motorsailer, Kayak, Canoe and Other");
		String userIn = scan.next();

		return userIn;
	}

	public void selectID() {
		String chooseID = "Select the member ID of the member that should be changed";
		System.out.println(chooseID);

	}

	public void selectBoatToDelete() {
		System.out.println("Which boat do you want to delete? Select the number infront of boat type");

	}

	public ChangeMemberOptions changeMember() {
		String choose = "What do you want to do?";
		String alt1 = "To change your name, enter(a)";
		String alt2 = "To delete a member, enter(b)";
		String alt3 = "To add a boat, enter(c)";
		String alt4 = "To delete a boat, enter(d)";
		String alt5 = "To change the boat info, enter(e)";

		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(alt5);
		String userIn = scan.next();
		switch (userIn) {
		case ("a"):
			return ChangeMemberOptions.changeName;
		case ("b"):
			return ChangeMemberOptions.deleteMember;
		case ("c"):
			return ChangeMemberOptions.addBoat;
		case ("d"):
			return ChangeMemberOptions.deleteBoat;
		case ("e"):
			return ChangeMemberOptions.changeBoat;
		}
	}

	

	public void listMembers() {
		StringBuffer listOfMembers = new StringBuffer();
		Iterator<Member> membersList = memberRegistry.getMemberList();
		while (membersList.hasNext()) {
			Member member = membersList.next();
			String name = member.getName();
			int id = member.getID();
			listOfMembers.append("Name: " + name + " | ");
			listOfMembers.append(" Member id: " + id);
			listOfMembers.append("\n");
		}
		System.out.println(listOfMembers.toString());
	}

	public void noChanges() {
		String no = "No changes made, prints the list of members again";
		System.out.println(no);
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


	public void listMembersBoats(int memberId) {
		Member member = memberRegistry.getMember(memberId);
		StringBuffer listOfBoats = new StringBuffer();
		int i = 1;
		Iterator<Boat> boats = member.getBoatList();
		while (boats.hasNext()) {
			Boat boat = boats.next();
			listOfBoats.append(i++);
			listOfBoats.append(" " + boat.getType());
			listOfBoats.append(" " + boat.getLength());
			listOfBoats.append("\n");
		}
		System.out.println(listOfBoats.toString());

	}

	public void compactListView() {
		Iterator<Member> membersList = memberRegistry.getMemberList();
		StringBuffer compactList = new StringBuffer();
		while (membersList.hasNext()) {
			Member member = membersList.next();
			compactList.append("Member Id: " + member.getID() + " | ");
			compactList.append("Name: " + member.getName() + " | ");
			compactList.append("Amount of Boats: " + member.getAmountOfBoats() + " | ");
			compactList.append("\n");

		}

		System.out.println(compactList.toString());
	}

	public void verboseListView() {
		Iterator<Member> membersList = memberRegistry.getMemberList();
		StringBuffer verboseList = new StringBuffer();
		System.out.println("-----------------------------------------------------------------------\n");
		while (membersList.hasNext()) {
			Member member = membersList.next();
			verboseList.append("Member Id: " + member.getID() + " | ");
			verboseList.append("Name: " + member.getName() + " | ");
			verboseList.append("Personal Number: " + member.getPersonNum() + " | ");
			verboseList.append("Amount of Boats: " + member.getAmountOfBoats() + " | ");
			verboseList.append("\n");
			int i = 1;
			Iterator<Boat> boatsList = member.getBoatList();
			while (boatsList.hasNext()) {
				Boat boat = boatsList.next();
				verboseList.append(i++);
				verboseList.append("\t Type of Boat: " + boat.getType() + " | ");
				verboseList.append("\t Length of Boat: " + meter2Feet(boat.getLength()) + " ft");
				verboseList.append("\n");
			}
			verboseList.append("\n");
		}
		System.out.println(verboseList.toString());
	}

	public double addBoatLength() {
		System.out.println("Length of boat? (In feet)");
		double userIn = scan.nextDouble();
		return userIn;

	}

	private double meter2Feet(double boatLength) {
		//boatLength = boatLength * 3.2808;
		return boatLength;

	}

	public void changeTheBoat(String whatToChange) {
		System.out.println(whatToChange);

	}

	public void changeBoatTypeLength() {
		System.out.println("Set new type and length for the boat ");
	}

	public void boatUpdated(boolean updated) {
		if (updated)
			System.out.println("Boat is updated");
		else
			System.out.println("Boat is NOT updated");
	}
	
}