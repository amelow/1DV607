package theYachtClub;

import java.util.Scanner;

public class Controller {
	private String userIn;
	// private int userInt;
	private String yesNo;
	private long userLong;
	private char checkYN;
	private String personNumberAsString;
	private Scanner scan = new Scanner(System.in);
	public static View view = new View();
	public static MemberRegister MR = new MemberRegister();

	/**
	 * TODO/ Fix: 1,member is saved before entering it in the switchcase 2,no output
	 * to the user of wrong personnum 3,Adding boat 4, getting the ID number
	 */

	public void welcomeM() {
		view.welcome();
		startM();
	}

	public void startM() {
		view.mainMenu();
		userIn = scan.next();
		switch (userIn) {
		case ("1"):
			caseOne();
			break;
		case ("2"):
			caseTwo();
			break;
		case ("3"):
			caseThree();
			break;
		case ("4"):
			System.out.println("Verbose");
			break;
		case ("Q"):
			System.out.println("quit");
		default:
			startM();
		}

	}

	public void caseOne() {
		view.AddName();
		userIn = scan.next();
		view.correctName(userIn);
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'y') {
			boolean number = false;
			while (number == false) {
				view.AddPersonNum();
				userLong = scan.nextLong();
				view.correctPersonNum(userLong);
				yesNo = scan.next();
				checkYN = yesNo.charAt(0);
				personNumberAsString = String.valueOf(userLong);
				int legthOfPersonNum = personNumberAsString.length();
				if (checkYN == 'y' && legthOfPersonNum == 12) {
					view.added();
					number = true;
				}
			}
//			MR.getID();
//			view.printID();
			view.saveMember(userIn, userLong);
			yesNo = scan.next();
			checkYN = yesNo.charAt(0);
			if (checkYN == 'y') {
				MR.CreateMember(userIn, personNumberAsString);
				view.memberSaved();
				startM();
			}
		} else {
			caseOne();
		}

	}

	private void caseTwo() {
		view.printMemList();
		view.typeID();
		userIn = scan.next();
		for (int i = 0; i < MR.getMemberList().size(); i++) {
			if (userIn.contentEquals(MR.getMemberList().get(i).getName())) {
				view.changeMem();
				userIn = scan.next();
				switch (userIn) {
				case ("1"):
					break;
				case ("2"):
					break;
				case ("3"):
					userIn = scan.next();
					view.correctName(userIn);
					MR.getMemberList().get(i).setName(userIn);
					break;
				}
			}

		}
	}

	private void caseThree() {
		view.printListMenu();
		MR.CompactList();
		userIn = scan.next();
		switch (userIn) {
		case ("1"):
			System.out.print("VERBOSE");
			break;
		case ("2"):
			startM();
			break;
		}

	}
}
