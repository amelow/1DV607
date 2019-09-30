package theYachtClub;

import java.util.Scanner;

public class Controller {
	private String userIn;
	private String yesNo;
	private long userLong;
	private char checkYN;
	private Scanner scan = new Scanner(System.in);
	public static View view = new View();
	public static MemberRegister MR = new MemberRegister();

	/**
	 * The menu for the user
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
			System.out.println("Change mem");
			break;
		case ("3"):
			System.out.println("compact");
			break;
		case ("4"):
			System.out.println("Verbose");
			break;
		case ("Q"):
			System.out.println("quit");
		}

	}

	public void caseOne() {

		view.AddName();
		userIn = scan.next();
		System.out.println("Is this correct? Your name is: " + userIn + " (y/n)");
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'y') {
			boolean number = false;
			while(number == false){
				view.AddPersonNum();
				userLong = scan.nextLong();
				System.out.println("Is this correct? Is your personal number following: " + userLong + " (y/n)");
				yesNo = scan.next();
				checkYN = yesNo.charAt(0);
				if(checkYN == 'y') {
					System.out.print("Added");
					number = true;
				}
			String save = "Do you want to save the member with name" + userIn + "and personal number" + userLong + "?";
			yesNo = scan.next();
			checkYN = yesNo.charAt(0);
			if(checkYN == 'y') {
				MR.CreateMember(userIn, userLong);
				System.out.print("Member saved ");
				startM();
				}
			}
			
			


		} else {
			caseOne();
		}

	}
}
