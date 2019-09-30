package theYachtClub;

import java.util.Scanner;

public class Controller {
	private String userIn;
	private long userLong;
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
			view.AddName();
			userIn = scan.next();
			System.out.println("Name:" + userIn);
			view.AddPersonNum();
			userLong = scan.nextLong();
			System.out.println("Personal number:" + userLong);
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

		/*
		 * switch(userIn) { case("1"): if(MR.getMemberList() == 0) { v.error();
		 * v.mainMenu(); } else { v.compactList(); v.mainMenu(); } break;
		 * 
		 * case("2"): if(MR.getMemberList() == 0) { v.error(); v.mainMenu(); } else {
		 * v.verboseList(); v.mainMenu; } break;
		 * 
		 * case("3"): v.addMember(); break;
		 * 
		 * case("Q") : v.saveQuit(); break;
		 * 
		 * default: v.invalid(); startM(); break; }
		 */
	}

}
