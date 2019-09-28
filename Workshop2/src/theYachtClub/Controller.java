package theYachtClub;

import java.util.Scanner;
import Controller.java;

public class Controller {
	private String userIn;
	private Scanner SC = new Scanner(System.in);
	public static View v = new View();
	
	/**
	 * The menu for the user
	 */
	
	public static void welcomeM() {
		v.welcome();
		startM();
	}
	
	public static void startM() {
		v.mainMenu();
		userIn = scan.next();
		
		switch(userIn) {
			case("1") {
				v.compactList();
				break;
			}
			case("2") {
				v.verboseList();
				break;
			}
			case("3") {
				v.addMember();
				break;
			}
			case("Q") {
				v.saveQuit();
				break;
			}
			default {
				v.invalid();
				break;
			}
		}
	}

}