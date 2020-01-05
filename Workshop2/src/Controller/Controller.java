package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.MemberRegister;
import Model.FileHandler.CreateFile;
import View.View;

public class Controller {
	private String userIn;
	private long userLong;
	private String checkYesNoAnswer;
	private char checkYN;
	private String personNumberAsString;
	private Scanner scan = new Scanner(System.in);
	private MemberRegister memReg = new MemberRegister();
	private View view = new View(memReg);
	private CreateFile fileHandler = new CreateFile();

	/*
	 * Prints the viewer class welcome message, initializes a file and calls the
	 * main menu method
	 */
	public void welcomeMessage() {
		fileHandler.initFile(memReg);
		view.welcomeMessage();
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
			caseShowVerbose();
			break;
		case ("2"):
			caseShowCompact();
			break;
		case ("3"):
			caseAddMember();
			break;
		case ("4"):
			caseChangeMember();
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
		view.addName();
		String createName = nameWithSpace();
		view.addPersonNum();
		userLong = scan.nextLong();
		personNumberAsString = String.valueOf(userLong);
		boolean doesExist = false;
		boolean correctNum = false;
		doesExist = memReg.checkIfPersonNumExists(personNumberAsString);
		if (doesExist == false) {
			int lengthOfPersonNum = personNumberAsString.length();
			correctNum = memReg.checkLengthOfPersonNum(lengthOfPersonNum);
			if (correctNum == true) {
				view.saveMember(createName, userLong);
			} else if (correctNum == false) {
				view.wrongFormat();
			}
		} else {
			view.userExist();
			startMenu();
		}
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			memReg.CreateMember(createName, personNumberAsString);
			view.memberSaved();
			startMenu();
		} else {
			startMenu();

		}
	}

	private String nameWithSpace() {
		String temp = "";
		ArrayList<String> name = new ArrayList<String>();
		while (temp.equals("-1") != true) {
			temp = scan.next();
			name.add(temp);
		}
		for (int i = 0; i < name.size(); i++) {
			temp = temp + " " + name.get(i);
			temp = temp.replace("-1", "");
		}
		return temp;
	}

	/*
	 * The change member method that handles the functionality of changing the users
	 * information, adding a boat, deleting a boat, changing the boats information,
	 * as well as deleting a member
	 */
	private void caseChangeMember() {
		view.listMembers();
		view.selectID();
		userIn = scan.next();
		int userID = Integer.parseInt(userIn);
		int index = memReg.getMemberIndex4Id(userID);

		if (index < 0) { // Member id does not exist
			view.noUser();
			startMenu();
		} else {
			view.changeMem();
			userIn = scan.next();
			switch (userIn) {
			case ("1"):
				addBoat(index);
				startMenu();
				break;
			case ("2"):
				deleteBoat(index);
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
		view.compactListView();
		startMenu();
	}

	/*
	 * Prints the verbose list of the member and boats information, then goes back
	 * to the main menu
	 */
	private void caseShowVerbose() {
		// ArrayList<Object> verbose = memReg.verboseList();
		view.verboseListView();
		startMenu();
	}

	private void caseQuitApp() {
		view.saveAndQuit();
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			fileHandler.fileHandler(memReg.getMemberList());
			// fileHandler(memReg.getMemberList());

			System.exit(0);
		}
		startMenu();
	}

	private void changeName(int i) {
		view.changName();
		String newName = nameWithSpace();
		view.correctName(newName);
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'y' || checkYN == 'Y') {
			memReg.changeName(i, newName);
		} else {
			view.noChanges();
			// caseChangeMember();
			startMenu();
		}
	}

	/*
	 * Checks if the user wants to delete a member, then saves the information in
	 * the Member register
	 */
	private void deleteMember(int id) {
		view.deleteMember();
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			view.memberDeleted();
			memReg.deleteMember(id);
			startMenu();
		} else {
			startMenu();
		}

	}

	/*
	 * Method that handles the functionality of addig a boat with a type and a
	 * length, then adding it to the registry at the correct id
	 */
	private void addBoat(int id) {
		view.typeOfBoat();
		userIn = scan.next();
		String typeOfBoat = userIn;
		view.addBoatLength();
		userIn = scan.next();
		int lengthOfBoat = Integer.parseInt(userIn);
		view.correctBoatInfo(typeOfBoat, lengthOfBoat);
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			memReg.addBoatToMember(id, lengthOfBoat, typeOfBoat);
			startMenu();
		} else {
			startMenu();
		}

	}

	/*
	 * Method that handles the functionality of changing a already added boats
	 * information such as a type and a length, then adding the changes it to the
	 * registry
	 */
	private void changeBoat(int memberIndex) {
		view.changeBoat();
		view.listMembersBoats(memberIndex);
		String userIn = scan.next();
		view.boatSel(userIn);
		String change = "Set new length and type for the boat ";
		view.changeBoatTL(change);
		int boatSelected = Integer.parseInt(userIn);
		userIn = scan.next();
		int changeLength = Integer.parseInt(userIn);
		userIn = scan.next();
		boolean updated = memReg.changeBoatMember(memberIndex, boatSelected, changeLength, userIn);
		view.boatUpdated(updated);
	}

	/*
	 * Method that handles the functionality of deleting a already added boat, by
	 * first checking the id then the user has to choose one of the boats and press
	 * delete
	 */
	private void deleteBoat(int memberIndex) {
		view.listMembersBoats(memberIndex);
		view.selectBoatToDelete();
		String deleteBoat = userIn;
		deleteBoat = scan.next();
		int deleteBoatInt = Integer.parseInt(deleteBoat);
		boolean deletedBoat = memReg.deleteBoatFromMember(memberIndex, deleteBoatInt);
		view.deletedBoat(deletedBoat);
		startMenu();
	}
}
