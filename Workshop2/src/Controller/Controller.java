package controller;

import java.util.ArrayList;
import java.util.Scanner;

import model.FileHandler;
import model.MemberRegister;
import view.IView;
import view.MainMenuOptions;

public class Controller {

	private String userIn;
	private long userLong;
	private String personNumberAsString;
	private Scanner scan;
	private MemberRegister memReg;
	private IView view;
	private FileHandler fileHandler;

	public Controller(MemberRegister m, IView v) {
		this.scan = new Scanner(System.in);
		this.memReg = m;
		this.view = v;
		this.fileHandler = new FileHandler();
		welcomeMessage();
		startMenu();
	}

	public void welcomeMessage() {
		fileHandler.initFile(memReg);
		view.welcomeMessage();
	}

	/*
	 * Main menu, giving the different options, reads the users input then calls
	 * upon the option chosen. If wrong input it calls the main again
	 */
	
	  	public void startMenu() {
		while (true) {
			MainMenuOptions option = view.mainMenu();
			switch (option) {
			case showVerbose:
				caseShowVerbose();
				break;
			case showCompact:
				caseShowCompact();
				break;
			case addMember:
				caseAddMember();
				break;
			case changeMember:
				caseChangeMember();
				break;
			case quitApp:
				caseQuitApp();
			default:
				;
			}
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
		}
		memReg.CreateMember(createName, personNumberAsString);
		view.memberSaved();
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
	
	/*
	 * 	  	public void startMenu() {
		while (true) {
			MainMenuOptions cmd = view.mainMenu();
			switch (cmd) {
			case showVerbose:
				caseShowVerbose();
				break;
			case showCompact:
				caseShowCompact();
				break;
			case addMember:
				caseAddMember();
				break;
			case changeMember:
				caseChangeMember();
				break;
			case quitApp:
				caseQuitApp();
			default:
				;
			}
	 */
	private void caseChangeMember() {
		view.listMembers();
		view.selectID();
		userIn = scan.next();
		int memberId = Integer.parseInt(userIn);
		if (!memReg.existsMemberIndex(memberId)) {
			view.noUser();
		} else {
			String option = view.changeMember();
			switch (option) {
			case ("a"):
				changeName(memberId);
				break;
			case ("b"):
				deleteMember(memberId);
				break;
			case ("c"):
				addBoat(memberId);
				break;
			case ("d"):
				deleteBoat(memberId);
				break;
			case ("e"):
				changeBoat(memberId);
			default:
				;
			}
		}
	}

	private void caseShowCompact() {
		view.compactListView();
	}

	private void caseShowVerbose() {
		view.verboseListView();
	}

	private void caseQuitApp() {
		fileHandler.fileHandler(memReg.getMemberList());
		System.exit(0);
	}

	private void changeName(int memberId) {
		view.changName();
		String newName = nameWithSpace();
		memReg.changeName(memberId, newName);
	}

	/*
	 * Checks if the user wants to delete a member, then saves the information in
	 * the Member register
	 */
	private void deleteMember(int memberId) {
		view.memberDeleted();
		memReg.deleteMember(memberId);
	}

	/*
	 * Method that handles the functionality of adding a boat with a type and a
	 * length, then adding it to the registry at the correct id
	 */
	private void addBoat(int memberId) {
		String typeOfBoat = view.typeOfBoat();
		double lengthOfBoat = view.addBoatLength();
		view.correctBoatInfo(typeOfBoat, lengthOfBoat);
		memReg.addBoatToMember(memberId, lengthOfBoat, typeOfBoat);
	}

	/*
	 * Method that handles the functionality of changing a already added boats
	 * information such as a type and a length, then adding the changes it to the
	 * registry
	 */
	private void changeBoat(int memberId) {
		view.changeBoat();
		view.listMembersBoats(memberId);
		String userIn = scan.next();
		int boatIndex = Integer.parseInt(userIn);
		view.changeBoatTypeLength();
		userIn = scan.next();
		int lengthOfBoat = Integer.parseInt(userIn);
		String boatType = scan.next();
		boolean updated = memReg.changeBoatMember(memberId, boatIndex, lengthOfBoat, boatType);
		view.boatUpdated(updated);
	}

	/*
	 * Method that handles the functionality of deleting a already added boat, by
	 * first checking the id then the user has to choose one of the boats and press
	 * delete
	 */
	private void deleteBoat(int memberId) {
		view.listMembersBoats(memberId);
		view.selectBoatToDelete();
		String deleteBoat = userIn;
		deleteBoat = scan.next();

		int deleteBoatInt = Integer.parseInt(deleteBoat);
		boolean deletedBoat = memReg.deleteBoatFromMember(memberId, deleteBoatInt);
		view.deletedBoat(deletedBoat);
	}
}
