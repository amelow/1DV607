package view;

import java.util.Iterator;
import java.util.Scanner;

import model.Boat;
import model.BoatTypes;
import model.Member;
import model.MemberRegister;

public class SwedishView implements IView {

	private MemberRegister memberRegistry;
	private Scanner scan;

	public SwedishView(MemberRegister memberRegistry) {
		this.scan = new Scanner(System.in);
		this.memberRegistry = memberRegistry;
	}

	@Override
	public void welcomeMessage() {
		System.out.println(" ____________________");
		System.out.println("|                    |");
		System.out.println("| Hej och Välkommen! |");
		System.out.println("|____________________|");
		System.out.println();
	}

	@Override
	public MainMenuOptions mainMenu() {
		String choose = "Vad vill du göra?";
		String alt1 = "För att spara och stänga av, tryck (1)";
		String alt2 = "För att ändra en medlems information, tryck (2)";
		String alt3 = "För att lägga till en medlem, tryck (3)";
		String alt4 = "För att visa compact-listan, tryck (4)";
		String alt5 = "För att visa verbose-listan, tryck (5)";

		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(alt5);

		String userIn = scan.next();
		switch (userIn) {
		case ("5"):
			return MainMenuOptions.showVerbose;
		case ("4"):
			return MainMenuOptions.showCompact;
		case ("3"):
			return MainMenuOptions.addMember;
		case ("2"):
			return MainMenuOptions.changeMember;
		case ("1"):
			return MainMenuOptions.quitApp;
		}
		return MainMenuOptions.others;

	}

	@Override
	public void addName() {
		System.out.println("Skriv in ditt namn (avsluta med att trycka enter och -1:)");
	}

	@Override
	public void changName() {
		System.out.println("Skriv in ditt nya namn (avsluta med att trycka enter och -1)");
	}

	@Override
	public void addPersonNum() {
		System.out.println("Skriv in ditt personnummer (YYYMMDD-XXXX)");
	}

	@Override
	public void correctBoatInfo(String typeOfBoat, double lengthOfBoat) {
		System.out.println("Är detta korrekt? Båt med längd:" + lengthOfBoat + " tryck (y/n)| y= ja,n=nej");
	}

	@Override
	public void saveMember(String name, long id) {
		String save = "Spara medlemmen  med personnumret " + id + "och namnet: " + name + "? tryck (y/n)| y= ja,n=nej";
		System.out.println(save);
	}

	@Override
	public void memberSaved() {
		String saved = "---Medlemmen är nu sparad---";
		System.out.println(saved + "\n");
	}

	@Override
	public void memberDeleted() {
		System.out.println("---Medlemmen har raderats---");
		System.out.println("\n");
	}

	@Override
	public void deletedBoat(boolean deletedBoat) {
		if (deletedBoat)
			System.out.println("Båten är borttagen");
		else
			System.out.println("Båten är INTE borttagen");
	}

	@Override
	public void changeBoat() {
		System.out.println("Vilken båt vill du ändra på?(Skriv in siffran framför båtarna i listan för att välja)");
	}

	@Override
	public String typeOfBoat() {
		System.out.println("Vilken typ av båt? Välj mellan: Segelbåt, Motorbåt, Kajak, Kanot och Annan");
		String userIn = scan.next();
		return bat2boat(userIn);
	}

	private String bat2boat(String b) {
		switch (b) {
		case ("Segelbåt"):
			return "Sailboat";
		case ("Motorbåt"):
			return "Motorsailer";
		case ("Kajak"):
			return "Kayak";
		case ("Kanot"):
			return "Canoe";
		default:
			return "Other";
		}
	}

	private String boat2bat(BoatTypes boatTypes) {
		String b = "" + boatTypes;
		switch (b) {
		case ("Sailboat"):
			return "Segelbåt";
		case ("Motorsailer"):
			return "Motorbåt";
		case ("Kayak"):
			return "Kajak";
		case ("Canoe"):
			return "Kanot";
		default:
			return "Annan";
		}
	}

	@Override
	public void selectID() {
		String chooseID = "Välj medlemmens id nummer för att ändra hens information";
		System.out.println(chooseID);
	}

	@Override
	public void selectBoatToDelete() {
		System.out.println("Vilken båt vill du ta bort?(Skriv in siffran framför båtarna i listan för att välja)");
	}

	@Override
	public ChangeMemberOptions changeMember() {
		String choose = "Vad vill du göra?";
		String alt1 = "För att lägga till en båt, tryck(1)";
		String alt2 = "För att ta bort en båt, tryck(2)";
		String alt3 = "För att ändra en båts information, tryck(3)";
		String alt4 = "För att byta ditt namn, tryck(4)";
		String alt5 = "För att ta bort en medlem, tryck(5)";

		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(alt5);

		String userIn = scan.next();
		switch (userIn) {
		case ("5"):
			return ChangeMemberOptions.deleteMember;
		case ("4"):
			return ChangeMemberOptions.changeName;
		case ("3"):
			return ChangeMemberOptions.changeBoat;
		case ("2"):
			return ChangeMemberOptions.deleteBoat;
		case ("1"):
			return ChangeMemberOptions.addBoat;
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
			listOfMembers.append("Medlems id: " + id + "|");
			listOfMembers.append(" Namn: " + name + "\n");
			listOfMembers.append("\n");
		}
		System.out.println(listOfMembers.toString());
	}

	@Override
	public void noChanges() {
		String noChange = "Inga ändringar gjorda";
		System.out.println(noChange);
	}

	@Override
	public void noUser() {
		String noUser = "Ingen medlem med det id numret, välj igen";
		System.out.println(noUser);
	}

	@Override
	public void wrongFormat() {
		System.out.println(
				"Fel format! Personnumret ska vara på följande sätt: YYYYMMDD-XXXX(tryck någon tangent för att komma tillbaka till menyn)");
	}

	@Override
	public void userExist() {
		System.out.println("Personen med det personnumret finns redan - Tillbaka till startmenyn");
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
			listOfBoats.append(" " + boat2bat(boat.getType()));
			listOfBoats.append(" " + boat.getLength());
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
			compactList.append("Namn: " + member.getName() + " | ");
			compactList.append("Medlems Id: " + member.getID() + " | ");
			compactList.append("Hur många båtar: " + member.getAmountOfBoats() + " | ");
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
			verboseList.append("Namn: " + member.getName() + " | ");
			verboseList.append("Medlems Id: " + member.getID() + " | ");
			verboseList.append("Personnummer: " + member.getPersonNum() + " | ");
			verboseList.append("Hur många båtar: " + member.getAmountOfBoats() + " | ");
			verboseList.append("\n");
			int i = 1;
			Iterator<Boat> boatsList = member.getBoatList();
			while (boatsList.hasNext()) {
				Boat boat = boatsList.next();
				verboseList.append(i++);
				verboseList.append("\t Båtens längd: " + boat.getLength() + " meter");
				verboseList.append("\t Båttyp: " + boat2bat(boat.getType()));
				verboseList.append("\n");
			}
			verboseList.append("\n");
		}
		System.out.println(verboseList.toString());
	}

	@Override
	public double addBoatLength() {
		System.out.println("Längd av båten?(Ange i meter)");
		double userIn = scan.nextDouble();
		return userIn;
	}

	@Override
	public void changeTheBoat(String whatToChange) {
		System.out.println(whatToChange);

	}

	@Override
	public void changeBoatTypeLength() {
		System.out.println(
				"Skriv in en ny längd och båttyp: (Segelbåt, Motorbåt, Kajak, Kanot och Annan) tryck enter och sedan Längden (i meter)");

	}

	@Override
	public void boatUpdated(boolean updated) {
		if (updated)
			System.out.println("Båten är uppdaterad");
		else
			System.out.println("Båten är INTE uppdaterad");
	}

}
