package view;

import java.util.Iterator;
import java.util.Scanner;

import model.Boat;
import model.BoatLength;
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
	public void listMembersBoats(int memberId) {
		Member member = memberRegistry.getMember(memberId);
		StringBuffer listOfBoats = new StringBuffer();
		int i = 1;
		Iterator<Boat> boats = member.getBoatList();
		while (boats.hasNext()) {
			Boat boat = boats.next();
			listOfBoats.append(i++);
			listOfBoats.append(" " + boat2bat(boat.getType()));
			listOfBoats.append(" " + boat.getLength().getLengthInMeters());
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
				verboseList.append("\t Båttyp: " + boat2bat(boat.getType()));
				verboseList.append("\t Båtens längd: " + boat.getLength().getLengthInMeters()+" m");
				verboseList.append("\n");
			}
			verboseList.append("\n");
		}
		System.out.println(verboseList.toString());
	}

	private BoatTypes bat2boat(String b) {
		switch (b) {
		case ("Segelbåt"):
			return BoatTypes.Sailboat;
		case ("Motorbåt"):
			return BoatTypes.Motorsailer;
		case ("Kajak"):
			return BoatTypes.Kayak;
		case ("Kanot"):
			return BoatTypes.Canoe;
		default:
			return BoatTypes.Other;
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
	public void addName() {
		System.out.println("Skriv in ditt namn (avsluta med att trycka enter och -1 )");
	}

	@Override
	public void changeName() {
		System.out.println("Skriv in ditt nya namn (avsluta med att trycka enter och -1)");
	}

	@Override
	public long addPersonNum() {
		System.out.println("Skriv in ditt personnummer (YYYMMDD-XXXX)");
		long userIn = scan.nextLong();
		return userIn;
	}

	@Override
	public BoatLength getBoatLength() {
		System.out.println("Längd av båten?(Ange i meter)");
		double userIn = scan.nextDouble();
		BoatLength boatLength = new BoatLength();
		boatLength.setLengthInMeters(userIn);
		return boatLength;
	}

	@Override
	public int changeBoat() {
		System.out.println("Vilken båt vill du ändra på?(Skriv in siffran framför båtarna i listan för att välja)");
		int userIn = scan.nextInt();
		return userIn;
	}

	@Override
	public void changeTheBoat(String whatToChange) {
		System.out.println(whatToChange);

	}

	@Override
	public BoatTypes changeBoatType() {
		System.out.println(
				"Skriv in en ny båttyp: (Segelbåt, Motorbåt, Kajak, Kanot och Annan)");
		String userIn = scan.next();
		return BoatTypes.getBoatType(userIn);

	}

	@Override
	public BoatLength changeBoatLength() {
		System.out.println("Skriv in en ny längd i meter:");
		double userIn = scan.nextDouble();
		BoatLength boatLength = new BoatLength();
		boatLength.setLengthInMeters(userIn);
		return boatLength;
	}

	@Override
	public void deletedBoat(boolean deletedBoat) {
		if (deletedBoat)
			System.out.println("Båten är borttagen");
		else
			System.out.println("Båten är INTE borttagen");
	}

	@Override
	public void boatUpdated(boolean updated) {
		if (updated)
			System.out.println("Båten är uppdaterad");
		else
			System.out.println("Båten är INTE uppdaterad");
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
	public void boatAdded() {
		System.out.println("---Båten har lagts till---");
		System.out.println("\n");
	}

	@Override
	public BoatTypes getBoatType() {
		System.out.println("Vilken typ av båt? Välj mellan: Segelbåt, Motorbåt, Kajak, Kanot och Annan");
		String userIn = scan.next();
		BoatTypes boatType = bat2boat(userIn);
		return boatType;
	}

	@Override
	public int selectID() {
		String chooseID = "Välj medlemmens id nummer för att ändra hens information";
		System.out.println(chooseID);
		int userIn = scan.nextInt();
		return userIn;
	}

	@Override
	public int selectBoatToDelete() {
		System.out.println("Vilken båt vill du ta bort?(Skriv in siffran framför båtarna i listan för att välja)");
		int userIn = scan.nextInt();
		return userIn;
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
				"Fel format! Personnumret ska vara på följande sätt: YYYYMMDD-XXXX ");
	}

	@Override
	public void userExist() {
		System.out.println("Personen med det personnumret finns redan - Tillbaka till startmenyn");
	}
}
