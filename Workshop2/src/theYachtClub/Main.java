package theYachtClub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		/*
		 * try { FileInputStream file = new FileInputStream("file.txt"); } catch
		 * (FileNotFoundException e) { e.printStackTrace(); }
		 */
		Controller controller = new Controller();
		controller.welcomeM();

	}

}
