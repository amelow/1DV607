package theYachtClub;

import java.util.Scanner;

public class Controller {
	private String userIn;
	private int boats = 0;

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
		if (checkYN == 'Y' || checkYN == 'y') {
			boolean number = false;
			while (number == false) {
				view.AddPersonNum();
				userLong = scan.nextLong();
				view.correctPersonNum(userLong);
				yesNo = scan.next();
				checkYN = yesNo.charAt(0);
				personNumberAsString = String.valueOf(userLong);
				if (personNumberAsString.length() != 12) {
					view.wrongFormat();
				}
				for (int i = 0; i < MR.getMemberList().size(); i++) {
					if (personNumberAsString.equals(MR.getMemberList().get(i).getPersonNum())) {
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
			view.saveMember(userIn, userLong);
			yesNo = scan.next();
			checkYN = yesNo.charAt(0);
			if (checkYN == 'Y' || checkYN == 'y') {
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
		int userID = Integer.parseInt(userIn);
		int index = -1;

		for (int i = 0; i < MR.getMemberList().size(); i++) {
			if (userID == MR.getMemberList().get(i).getID()) {
				index = i;
			}
		}
		if (index < 0) {
			view.noUser();
			startM();
		} else {
			view.changeMem();
			userIn = scan.next();
			switch (userIn) {
			case ("1"):
				addBoat(userID);
				startM();
				break;
			case ("2"):
				deleteBoat(userID);
				break;
			case ("3"):
				changeBoat(index);
				break;
			case ("4"):
				changeName(index);
				break;
			case ("5"):
				deleteMember(index);
				break;
			}
		}
		view.noUser();
		caseTwo();
	}

	private void caseThree() {
		MR.CompactList();
		startM();
	}

	private void caseFour() {
		MR.printVerbose();
		startM();
	}

	private void caseFive() {
		System.out.println("Are you sure? Do you want to exit the application? (y/n)");
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			System.out.println("Okay! Hope we will see you again");
			System.exit(0);
		}
		System.out.println("Okay! Back to the main menu.");
		startM();
	}

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
		} else {
			view.noChanges();
			caseTwo();
		}
	}

	private void deleteMember(int id) {
		System.out.println("Are you sure? Do you want to delete the member?" + id + "(y/n)");
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			System.out.println("--The member gets deleted--");
			MR.DeleteMember(id);
		} else {
			System.out.println("Okay back to the main menu");
			startM();
		}

	}

	private void addBoat(int id) {
		System.out.println("Type of boat?:");
		userIn = scan.next();
		String typeOfBoat = userIn;
		System.out.println("length of boat?");
		userIn = scan.next();
		String lengthOfBoat = userIn;
		System.out.println("Is " + typeOfBoat + " and length " + lengthOfBoat + " correct?(y/n)");
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			BoatTypes type;
			MR.getMember(id).addBoat(BoatTypes.getBoatType(typeOfBoat), Integer.parseInt(lengthOfBoat));
		}
	}

	private void changeBoat(int userID) {
		
	}

	private void deleteBoat(int userID) {
	//	MR.getMemberList().get(userID).getBoatList();
		int userIndex = 0;
		for(int i = 0; i < MR.getMemberList().size(); i++) {
			if(MR.getMemberList().get(i).getID() == userID) {
				userIndex = i;
			}
		}
		String p;
		for(int i = 0; i < MR.getMemberList().get(userIndex).getBoatList().size(); i++) {
		p =	i +" " + MR.getMemberList().get(userIndex).getBoatList().get(i).getType()+ MR.getMemberList().get(userIndex).getBoatList().get(i);
		System.out.println(p);
		}
		System.out.println("Which boat do you want to delete? select the number infront of boat type");
		String deleteBoat = userIn;
		deleteBoat = scan.next();
		int deleteBoatInt = Integer.parseInt(deleteBoat);
		for(int i = 0; i < MR.getMemberList().get(userIndex).getBoatList().size(); i++) {
			String c =i +" "+ MR.getMemberList().get(userIndex).getBoatList().get(i);
			String r =deleteBoatInt+" "+ MR.getMemberList().get(userIndex).getBoatList().get(i);
			if(c.equals(r)) {
				System.out.println("Se Om jag kommer till c.equals.r");
				System.out.print(MR.getMember(userIndex)); //Prints Null
			//	MR.getMember(userIndex).deleteBoat(i); 
			}
		System.out.print(deleteBoat);

		}
	}
}
