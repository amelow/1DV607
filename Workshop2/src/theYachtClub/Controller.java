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
	
	public static void startM() {
		String selection = v.mainMenu();
	}
	
	
}