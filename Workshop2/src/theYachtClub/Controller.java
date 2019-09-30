package theYachtClub;

import java.util.Scanner;

public class Controller {
	private String userIn;
	private Scanner scan = new Scanner(System.in);
	public static View v = new View();
	public static MemberRegister MR = new MemberRegister();

	/**
	 * The menu for the user
	 */

	public void welcomeM() {
		v.welcome();
		startM();
	}

	public void startM() {
		v.mainMenu();
		userIn = scan.next();
		
		switch(userIn) {
			case("1"):
				if(MR.getMemberList() == 0) {
				v.error();
				v.mainMenu();
				}
				else {
					v.compactList();
					v.mainMenu();
				}
				break;
			
			case("2"):
				if(MR.getMemberList() == 0) {
					v.error();
					v.mainMenu();
					}
				else {
					v.verboseList();
					v.mainMenu;
				}
				break;
			
			case("3"):
				v.addMember();
				break;
			
			case("Q") :
				v.saveQuit();
				break;
			
			default:
				v.invalid();
				startM();
				break;
			}
		}
}
