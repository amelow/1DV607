package view;

import java.util.Iterator;
import java.util.Scanner;

import model.Boat;
import model.BoatLength;
import model.BoatTypes;
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

	@Override
	public void welcomeMessage() {
		System.out.println(" ____________________");
		System.out.println("|                    |");
		System.out.println("|  Hi and Welcome!   |");
		System.out.println("|____________________|");
		System.out.println();
	}

	@Override
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

	@Override
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
		return ChangeMemberOptions.others;
	}

	@Override
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

	@Override
	public void listMembersBoats(int memberId) {
		Member member = memberRegistry.getMember(memberId);
		StringBuffer listOfBoats = new StringBuffer();
		int i = 1;
		Iterator<Boat> boats = member.getBoatList();
		while (boats.hasNext()) {
			Boat boat = boats.next();
			listOfBoats.append(i++);
			listOfBoats.append(" " + boat.getType());
			listOfBoats.append(" " + boat.getLength().getLengthInFeet());
			listOfBoats.append("\n");
		}
		System.out.println(listOfBoats.toString());

	}

	@Override
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

	@Override
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
				verboseList.append("\t Length of Boat: " + boat.getLength().getLengthInFeet() + " ft");
				verboseList.append("\n");
			}
			verboseList.append("\n");
		}
		System.out.println(verboseList.toString());

	}

	@Override
	public void addName() {
		System.out.println("Please enter your name (end with enter and -1: )");

	}

	@Override
	public void changeName() {
		System.out.println("Please enter your new name (end with enter and -1: )");

	}

	@Override
	public long addPersonNum() {
		System.out.println("Please enter your personal-number: (YYYYMMDD-XXXX)");
		long userIn = scan.nextLong();
		return userIn;

	}

	@Override
	public BoatLength getBoatLength() {
		System.out.println("Length of boat? (In feet)");
		double userIn = scan.nextDouble();
		BoatLength boatLength = new BoatLength();
		boatLength.setLengthInFeet(userIn);
		return boatLength;
	}

	@Override
	public void deletedBoat(boolean deletedBoat) {
		if (deletedBoat)
			System.out.println("Boat is deleted");
		else
			System.out.println("Boat is NOT deleted");

	}

	@Override
	public int changeBoat() {
		System.out.println("Which boat should be changed? Select the number infront of the boat type");
		int userIn = scan.nextInt();
		return userIn;

	}

	@Override
	public void changeTheBoat(String whatToChange) {
		System.out.println(whatToChange);

	}

	@Override
	public BoatTypes changeBoatType() {
		System.out.println("Set new type of the boat ");
		String userIn = scan.next();
		return BoatTypes.getBoatType(userIn);
	}

	@Override
	public void boatUpdated(boolean updated) {
		if (updated)
			System.out.println("Boat is updated");
		else
			System.out.println("Boat is NOT updated");
	}

	@Override
	public void memberSaved() {
		String saved = "---The member is now saved---";
		System.out.println(saved + "\n");

	}

	@Override
	public void memberDeleted() {
		System.out.println("---The member gets deleted---");
		System.out.println("\n");

	}

	@Override
	public void boatAdded() {
		System.out.println("---Boat is now added---");
		System.out.println("\n");
	}

	@Override
	public BoatTypes getBoatType() {
		System.out.println("Type of boat? Choose between: Sailboat, Motorsailer, Kayak, Canoe and Other");
		String userIn = scan.next();
		return BoatTypes.getBoatType(userIn);
	}

	@Override
	public int selectID() {
		String chooseID = "Select the member ID of the member that should be changed";
		System.out.println(chooseID);
		int userIn = scan.nextInt();
		return userIn;

	}

	@Override
	public int selectBoatToDelete() {
		System.out.println("Which boat do you want to delete? Select the number in front of the boat ");
		int userIn = scan.nextInt();
		return userIn;

	}

	@Override
	public void noChanges() {
		String no = "No changes made, prints the list of members again";
		System.out.println(no);

	}

	@Override
	public void noUser() {
		String noUser = "No user with that MemID, select again";
		System.out.println(noUser);

	}

	@Override
	public void wrongFormat() {
		System.out.println("Wrong format!It should be like: YYYYMMDDXXXX");

	}

	@Override
	public void userExist() {
		System.out.println("Person number exist - returns to start menu");

	}

	@Override
	public BoatLength changeBoatLength() {
		System.out.println("Set new length of the boat (in feet)");
		double userIn = scan.nextDouble();
		BoatLength boatLength = new BoatLength();
		boatLength.setLengthInFeet(userIn);
		return boatLength;
	}
}
