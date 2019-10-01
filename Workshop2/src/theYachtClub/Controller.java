package theYachtClub;

import java.util.Scanner;

public class Controller {
	private String userIn;
<<<<<<< HEAD
	private String yesNo;
=======
	private int boats = 0;
>>>>>>> refs/heads/master
	private long userLong;
	private String yesNo;
	private char checkYN;
	private String personNumberAsString;
	private Scanner scan = new Scanner(System.in);
	public static View view = new View();
	public static MemberRegister MR = new MemberRegister();
	public static Boat boat = new Boat();

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
			caseFour();
			break;
		case ("Q"):
			caseFive();
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
				if(personNumberAsString.length() != 12) {
					view.wrongFormat();
				}
				for(int i = 0; i < MR.getMemberList().size(); i++) {
					if(personNumberAsString.equals(MR.getMemberList().get(i).getPersonNum())) {
						view.userExist();
						startM();
					}
				}
				int legthOfPersonNum = personNumberAsString.length();
				if (checkYN == 'y' && legthOfPersonNum == 12) {
					view.added();
					number = true;
				}
			}
			view.addBoat();
			boats = scan.nextInt();
			MR.getBoats(boats);
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
		view.printMemListForChange(MR.getMemberList());
		;
		view.typeID();
		userIn = scan.next();
		
		for (int i = 0; i < MR.getMemberList().size(); i++) {
			String t = ""+MR.getMemberList().get(i).getID();
			if (userIn.contentEquals(t)) {
				view.changeMem();
				userIn = scan.next();
				switch (userIn) {
				case ("1"):
					addBoat();
					break;
				case ("2"):
					break;
				case ("3"):
					changeName(i);
					break;
				}
			}
		}
		view.noUser();
		caseTwo();
	}

	

	private void addBoat() {
		System.out.println("Type of boat?:");
		userIn = scan.next();
		String typeOfBoat = userIn;
		System.out.println("length of boat?");
		userIn = scan.next();
		String lengthOfBoat = userIn;
		System.out.println("Is " + typeOfBoat + " and length " + lengthOfBoat + " correct?");
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if(checkYN == 'Y') {
	//		boat.setLength(lengthOfBoat);
		}
		
	} 

	private void caseThree() {
		view.printListMenu();
		MR.CompactList();
		userIn = scan.next();
		switch (userIn) {
		case ("1"):
			caseFour();
			break;
		case ("2"):
			startM();
			break;
		}

	}
<<<<<<< HEAD
	
	private void changeName(int i) {
		view.AddName();
		userIn = scan.next();
		view.correctName(userIn);
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'y') {
		MR.getMemberList().get(i).setName(userIn);
		view.changes();
		startM();
		}
		else {
			view.noChanges();
			caseTwo();
		}
		
	}
=======

	private void caseFour() {

	}

	private void caseFive() {

	}

>>>>>>> refs/heads/master
}
