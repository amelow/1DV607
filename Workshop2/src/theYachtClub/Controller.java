package theYachtClub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
	private String userIn;
	private long userLong;
	private String checkYesNoAnswer;
	private char checkYN;
	private String personNumberAsString;
	private Scanner scan = new Scanner(System.in);
	public View view = new View();
	public MemberRegister MR = new MemberRegister();
	public Boat boat = new Boat();

	public void welcomeM() {
		initFile();
		view.welcome();
		startMenu();
	}

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
				for (int i = 0; i < MR.getMemberList().size(); i++) {
					if (personNumberAsString.equals(MR.getMemberList().get(i).getPersonNum())) {
						view.userExist();
						startMenu();
					}
				}
				int legthOfPersonNum = personNumberAsString.length();
				if (checkYN == 'y' && legthOfPersonNum == 12) {
					view.added();
					number = true;
				}
			}
			view.saveMember(userIn, userLong);
			checkYesNoAnswer = scan.next();
			checkYN = checkYesNoAnswer.charAt(0);
			if (checkYN == 'Y' || checkYN == 'y') {
				MR.CreateMember(userIn, personNumberAsString);
				view.memberSaved();
				startMenu();
			}
		} else {
			caseAddMember();
		}

	}

	private void caseChangeMember() {
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

	private void caseShowCompact() {
		MR.CompactList();
		startMenu();
	}

	private void caseShowVerbose() {
		MR.printVerbose();
		startMenu();
	}

	private void caseQuitApp() {
		System.out.println("Are you sure? Do you want to save and exit the application? (y/n)");
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			fileHandler(MR.getMemberList());
			System.out.println("Okay! Hope we will see you again");
			System.exit(0);
		}
		System.out.println("Okay! Back to the main menu.");
		startMenu();
	}

	private void changeName(int i) {
		view.AddName();
		userIn = scan.next();
		view.correctName(userIn);
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'y') {
			MR.getMemberList().get(i).setName(userIn);
			view.changes();
			startMenu();
		} else {
			view.noChanges();
			caseChangeMember();
		}
	}

	private void deleteMember(int id) {
		System.out.println("Are you sure? Do you want to delete the member?" + id + "(y/n)");
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			System.out.println("--The member gets deleted--");
			MR.DeleteMember(id);
		} else {
			System.out.println("Okay back to the main menu");
			startMenu();
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
		checkYesNoAnswer = scan.next();
		checkYN = checkYesNoAnswer.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			BoatTypes type;
			MR.getMember(id).addBoat(BoatTypes.getBoatType(typeOfBoat), Integer.parseInt(lengthOfBoat));
		}
	}

	private void changeBoat(int userID) {
		System.out.println("Which boat should be changed? select the number infront of the boat type");
		String p;
		for (int i = 0; i < MR.getMemberList().get(userID).getBoatList().size(); i++) {
			p = i + " " + MR.getMemberList().get(userID).getBoatList().get(i).getType() + " "
					+ MR.getMemberList().get(userID).getBoatList().get(i).getLength();
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
			MR.getMemberList().get(userID).getBoatList().get(boatSelected).setLength(Integer.parseInt(userIn));
			System.out.println("Length set to: " + userIn);

		}
		if (changesSel == 2 || changesSel == 3) {
			System.out.println("Set new type for the boat: ");
			userIn = scan.next();
			MR.getMemberList().get(userID).getBoatList().get(boatSelected).setType(BoatTypes.getBoatType(userIn));
			System.out.println("Boat Type set to: " + userIn);
		}
		startMenu();

	}

	private void deleteBoat(int userID) {
		int userIndex = 0;
		for (int i = 0; i < MR.getMemberList().size(); i++) {
			if (MR.getMemberList().get(i).getID() == userID) {
				userIndex = i;
			}
		}
		String p;
		for (int i = 0; i < MR.getMemberList().get(userIndex).getBoatList().size(); i++) {
			p = i + " " + MR.getMemberList().get(userIndex).getBoatList().get(i).getType() + " "
					+ MR.getMemberList().get(userIndex).getBoatList().get(i).getLength();
			System.out.println(p);
		}
		System.out.println("Which boat do you want to delete? select the number infront of boat type");
		String deleteBoat = userIn;
		deleteBoat = scan.next();
		int deleteBoatInt = Integer.parseInt(deleteBoat);
		for (int i = 0; i < MR.getMemberList().get(userIndex).getBoatList().size(); i++) {
			String c = i + " " + MR.getMemberList().get(userIndex).getBoatList().get(i);
			String r = deleteBoatInt + " " + MR.getMemberList().get(userIndex).getBoatList().get(i);
			if (c.equals(r)) {
				MR.getMemberList().get(userIndex).deleteBoat(i);
				System.out.println("Boat is deleted and main menu will be showed");
			}
		}
		startMenu();
	}

	private void initFile() {
		String fileName = "file.txt";

		try {
			ArrayList<String> arr = new ArrayList<String>();
			String line = null;
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int counter = 0;
			while ((line = br.readLine()) != null) {
				if (line.equals(",")) {
					Member m = new Member(arr.get(0), arr.get(1));
					for (int i = 0; i < Integer.parseInt(arr.get(3)); i++) {
						m.addBoat(BoatTypes.getBoatType(arr.get(4 + (counter))),
								Integer.parseInt(arr.get(5 + (counter))));
						counter += 2;
					}
					counter = 0;
					MR.AddMember(m);
					arr.clear();
				} else {
					arr.add(line);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void fileHandler(ArrayList<Member> arrayList) {
		File file = new File("file.txt");
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
		arrayList.clear();
	}
}