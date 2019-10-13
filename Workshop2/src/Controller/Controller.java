package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.BoatTypes;
import Model.Member;
import Model.MemberRegister;
import View.View;

/*
	* The Controller class is the main class that handles the functionality of the application.
	*  It fetches the users input and saves it in a txt file.
	* If the user already has previously saved a file it loads the saved members info as well as the registered boats
 */
public class Controller {
	// Declaring and Initializing the variables
	private String userIn; // handles the user input
	private long userLong;// handles the user input
	private String checkYesNoAnswer; // checks the console input if it is (y/n)
	private char checkYN; // checks the console input if it is (y/n)
	private String personNumberAsString; // personal number
	private Scanner scan = new Scanner(System.in); // scanner handles the conole inputs
	private View view = new View();
	private MemberRegister memReg = new MemberRegister();

	/*
	 * Prints the viewer class welcome message, initializes a file and calls the
	 * main menu method
	 */
	public void welcomeMessage() {
		initFile();
		view.welcome();
		startMenu();
	}

	/*
	 * Main menu, giving the different options, reads the users input then calls
	 * upon the option chosen. If wrong input it calls the main again
	 */
	public void startMenu() {
		view.mainMenu();
		userIn = scan.next();
		switch (userIn) {
		case ("1"):
			caseAddMember();
			break;
		case ("2"):
			caseChangeMember();
			break;
		case ("3"):
			caseShowCompact();
			break;
		case ("4"):
			caseShowVerbose();
			break;
		case ("Q"):
			caseQuitApp();
		default:
			startMenu();
		}

	}

	/*
	 * Add member method that handles the member info such as Name and Personal
	 * Number. If correct it adds it to the member registry
	 */
	public void caseAddMember() {
		view.AddName();
		userIn = scan.next();
		view.correctName(userIn);
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			boolean number = false;
			while (number == false) {
				view.AddPersonNum();
				userLong = scan.nextLong();
				view.correctPersonNum(userLong);
				checkYesNoAnswer = scan.next();
				checkYN = checkYesNoAnswer.charAt(0);
				personNumberAsString = String.valueOf(userLong);
				if (personNumberAsString.length() != 12) {
					view.wrongFormat();
				}
				for (int i = 0; i < memReg.getMemberList().size(); i++) { // checks the personal number if user already
																			// exists
					if (personNumberAsString.equals(memReg.getMemberList().get(i).getPersonNum())) {
						view.userExist();
						startMenu();
					}
				}
				int legthOfPersonNum = personNumberAsString.length(); // checks if personal number is 12
				if (checkYN == 'y' && legthOfPersonNum == 12) {
				//	view.added();
					number = true;
				}
			}
			view.saveMember(userIn, userLong);
			checkYesNoAnswer = scan.next();
			checkYN = checkYesNoAnswer.charAt(0);
			if (checkYN == 'Y' || checkYN == 'y') {
				memReg.CreateMember(userIn, personNumberAsString); // sends the users input as a parameter to
																	// thecreatemember method
				view.memberSaved();
				startMenu(); // calls the main again
			}
		} else {
			caseAddMember(); // calls itself again to add more members
		}

	}

	/*
	 * The change member method that handles the functionality of changing the users
	 * information, adding a boat, deleting a boat, changing the boats information,
	 * as well as deleting a member
	 */
	private void caseChangeMember() {
		view.printMemListForChange(memReg.getMemberList());
		;
		view.typeID();
		userIn = scan.next();
		int userID = Integer.parseInt(userIn);
		int index = -1;

		for (int i = 0; i < memReg.getMemberList().size(); i++) {
			if (userID == memReg.getMemberList().get(i).getID()) {
				index = i;
			}
		}
		if (index < 0) {
			view.noUser();
			startMenu();
		} else {
			view.changeMem();
			userIn = scan.next();
			switch (userIn) {
			case ("1"):
				addBoat(userID);
				startMenu();
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
		caseChangeMember();
	}

	/*
	 * Prints the compact list of the members information, then goes back to the
	 * main menu
	 */
	private void caseShowCompact() {
		memReg.CompactList();
		startMenu();
	}

	/*
	 * Prints the verbose list of the member and boats information, then goes back
	 * to the main menu
	 */
	private void caseShowVerbose() {
		memReg.printVerbose();
		startMenu();
	}

	/*
	 * Checks if the user wants to quit the application, then saves the information
	 * in the txt file
	 */
	private void caseQuitApp() {
		System.out.println("Are you sure? Do you want to save and exit the application? (y/n)");
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			fileHandler(memReg.getMemberList()); // calls the filehandler and sends the members information to save it
			System.out.println("Okay! Hope we will see you again");
			System.exit(0);// closing the console application
		}
		System.out.println("Okay! Back to the main menu.");
		startMenu();
	}

	/*
	 * Checks if the user wants to change the name, then saves the information in
	 * the Member register
	 */
	private void changeName(int i) {
		view.AddName();
		userIn = scan.next();
		view.correctName(userIn);
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'y') {
			memReg.getMemberList().get(i).setName(userIn);
			view.changes();
			startMenu();
		} else {
			view.noChanges();
			caseChangeMember();
		}
	}

	/*
	 * Checks if the user wants to delete a member, then saves the information in
	 * the Member register
	 */
	private void deleteMember(int id) {
		System.out.println("Are you sure? Do you want to delete the member?" + id + "(y/n)");
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			System.out.println("--The member gets deleted--");
			memReg.DeleteMember(id);
		} else {
			System.out.println("Okay back to the main menu");
			startMenu();
		}

	}

	/*
	 * Method that handles the functionality of addig a boat with a type and a
	 * length, then adding it to the registry at the correct id
	 */
	private void addBoat(int id) {
		System.out.println("Type of boat?:");
		userIn = scan.next();
		String typeOfBoat = userIn;
		System.out.println("length of boat?");
		userIn = scan.next();
		String lengthOfBoat = userIn;
		System.out.println("Is " + typeOfBoat + " and length " + lengthOfBoat + " correct?(y/n)");
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			BoatTypes type;
			memReg.getMember(id).addBoat(BoatTypes.getBoatType(typeOfBoat), Integer.parseInt(lengthOfBoat));
		}
	}

	/*
	 * Method that handles the functionality of changing a already added boats
	 * information such as a type and a length, then adding the changes it to the
	 * registry
	 */
	private void changeBoat(int userID) {
		System.out.println("Which boat should be changed? select the number infront of the boat type");
		String p;
		for (int i = 0; i < memReg.getMemberList().get(userID).getBoatList().size(); i++) {
			p = i + " " + memReg.getMemberList().get(userID).getBoatList().get(i).getType() + " "
					+ memReg.getMemberList().get(userID).getBoatList().get(i).getLength();
			System.out.println(p);
		}
		userIn = scan.next();
		int boatSelected = Integer.parseInt(userIn);
		System.out.println("Do you want to change length(1), type (2), both (3)");
		userIn = scan.next();
		int changesSel = Integer.parseInt(userIn);
		if (changesSel == 1 || changesSel == 3) {
			System.out.println("Set new length for the boat: ");
			userIn = scan.next();
			// updating the new boat length
			memReg.getMemberList().get(userID).getBoatList().get(boatSelected).setLength(Integer.parseInt(userIn));
			System.out.println("Length set to: " + userIn);

		}
		if (changesSel == 2 || changesSel == 3) { // does the user want to change name, change type or both
			System.out.println("Set new type for the boat: ");
			userIn = scan.next();
			// updating the new boat type
			memReg.getMemberList().get(userID).getBoatList().get(boatSelected).setType(BoatTypes.getBoatType(userIn));
			System.out.println("Boat Type set to: " + userIn);
		}
		startMenu();

	}

	/*
	 * Method that handles the functionality of deleting a already added boat, by
	 * first checking the id then the user has to choose one of the boats and press
	 * delete
	 */
	private void deleteBoat(int userID) {
		int userIndex = 0;
		for (int i = 0; i < memReg.getMemberList().size(); i++) {
			if (memReg.getMemberList().get(i).getID() == userID) { // checks if correct member id
				userIndex = i;
			}
		}
		String p;
		// Loops thru the users registered boats and gets the type and the length
		for (int i = 0; i < memReg.getMemberList().get(userIndex).getBoatList().size(); i++) {
			p = i + " " + memReg.getMemberList().get(userIndex).getBoatList().get(i).getType() + " "
					+ memReg.getMemberList().get(userIndex).getBoatList().get(i).getLength();
			System.out.println(p);
		}
		System.out.println("Which boat do you want to delete? select the number infront of boat type");
		String deleteBoat = userIn;
		deleteBoat = scan.next();
		int deleteBoatInt = Integer.parseInt(deleteBoat);
		for (int i = 0; i < memReg.getMemberList().get(userIndex).getBoatList().size(); i++) {
			String c = i + " " + memReg.getMemberList().get(userIndex).getBoatList().get(i);
			String r = deleteBoatInt + " " + memReg.getMemberList().get(userIndex).getBoatList().get(i);
			if (c.equals(r)) {
				memReg.getMemberList().get(userIndex).deleteBoat(i);
				System.out.println("---Boat is deleted, back to the main menu---");
			}
		}
		startMenu();
	}

	/*
	 * The initFile() method checks if the user already has a saved txt file, if so
	 * it reads the file and calls the addMember method and adds the saved members
	 * information to the member register
	 */
	private void initFile() {
		String fileName = "YachtClubRegister.txt";

		try {
			ArrayList<String> arr = new ArrayList<String>();
			String line = null;
			FileReader fileReader = new FileReader(fileName);
			BufferedReader buffReader = new BufferedReader(fileReader);
			int counter = 0;
			while ((line = buffReader.readLine()) != null) {
				if (line.equals(",")) {
					Member m = new Member(arr.get(0), arr.get(1)); // gets the name and the personal number from file
					for (int i = 0; i < Integer.parseInt(arr.get(3)); i++) {
						m.addBoat(BoatTypes.getBoatType(arr.get(4 + (counter))), // gets the boattypes fro file
								Integer.parseInt(arr.get(5 + (counter))));
						counter += 2;
					}
					counter = 0;
					memReg.AddMember(m); // add the members
					arr.clear();
				} else {
					arr.add(line);
				}
			}
			buffReader.close();
		} catch (FileNotFoundException e) { // catches the exceptions
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/*
	 * The fileHandler() method is called when the user doesnt have any saved files.
	 * Makes a new YachtClubRegister.txt
	 */
	private void fileHandler(ArrayList<Member> arrayList) {
		File file = new File("YachtClubRegister.txt");
		if (!file.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				saveFileInfo(writer, arrayList);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				file.delete();
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				saveFileInfo(writer, arrayList);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * ThesaveFileInfo() method is called when the user wants to quit the
	 * application, so txt file can save the members information.
	 */
	private void saveFileInfo(BufferedWriter writer, ArrayList<Member> arrayList) {

		for (int i = 0; i < arrayList.size(); i++) {
			try {
				writer.write(arrayList.get(i).getName() + System.lineSeparator());
				writer.write(arrayList.get(i).getPersonNum() + System.lineSeparator());
				writer.write(arrayList.get(i).getID() + System.lineSeparator());
				writer.write(arrayList.get(i).getAmountOfBoats() + System.lineSeparator());
				if (arrayList.get(i).getAmountOfBoats() > 0) {
					for (int j = 0; j < arrayList.get(i).getAmountOfBoats(); j++) {
						writer.write(
								arrayList.get(i).getBoatList().get(j).getType().toString() + System.lineSeparator());
						writer.write((int) arrayList.get(i).getBoatList().get(j).getLength() + System.lineSeparator());
					}
				}
				writer.write("," + System.lineSeparator());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		arrayList.clear(); // clears it so we dont get duplicate members
	}
}