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
	private int boats = 0;
	private long userLong;
	private String yesNo;
	private char checkYN;
	private String personNumberAsString;
	private Scanner scan = new Scanner(System.in);
	public static View view = new View();
	public static MemberRegister MR = new MemberRegister();
	public static Boat boat = new Boat();

	public void welcomeM(){
		initFile();
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
			caseTwo();
			break;
		case ("3"):
			caseThree();
			break;
		case ("4"):
			caseFour();
			break;
		case ("Q"):
			caseFive();
		default:
			startM();
		}

	}

	public void caseOne() {
		view.AddName();
		userIn = scan.next();
		view.correctName(userIn);
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			boolean number = false;
			while (number == false) {
				view.AddPersonNum();
				userLong = scan.nextLong();
				view.correctPersonNum(userLong);
				yesNo = scan.next();
				checkYN = yesNo.charAt(0);
				personNumberAsString = String.valueOf(userLong);
				if (personNumberAsString.length() != 12) {
					view.wrongFormat();
				}
				for (int i = 0; i < MR.getMemberList().size(); i++) {
					if (personNumberAsString.equals(MR.getMemberList().get(i).getPersonNum())) {
						view.userExist();
						startM();
					}
				}
				int legthOfPersonNum = personNumberAsString.length();
				if (checkYN == 'y' && legthOfPersonNum == 12) {
					view.added();
					number = true;
				}
			}
			view.saveMember(userIn, userLong);
			yesNo = scan.next();
			checkYN = yesNo.charAt(0);
			if (checkYN == 'Y' || checkYN == 'y') {
				MR.CreateMember(userIn, personNumberAsString);
				view.memberSaved();
				startM();
			}
		} else {
			caseOne();
		}

	}

	private void caseTwo() {
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
			startM();
		} else {
			view.changeMem();
			userIn = scan.next();
			switch (userIn) {
			case ("1"):
				addBoat(userID);
				startM();
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
		view.noUser();
		caseTwo();
	}

	private void caseThree() {
		MR.CompactList();
		startM();
	}

	private void caseFour() {
		MR.printVerbose();
		startM();
	}

	private void caseFive() {
		System.out.println("Are you sure? Do you want to exit the application? (y/n)");
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			fileHandler(MR.getMemberList());
			System.out.println("Okay! Hope we will see you again");
			System.exit(0);
		}
		System.out.println("Okay! Back to the main menu.");
		startM();
	}

	private void changeName(int i) {
		view.AddName();
		userIn = scan.next();
		view.correctName(userIn);
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'y') {
			MR.getMemberList().get(i).setName(userIn);
			view.changes();
			startM();
		} else {
			view.noChanges();
			caseTwo();
		}
	}

	private void deleteMember(int id) {
		System.out.println("Are you sure? Do you want to delete the member?" + id + "(y/n)");
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			System.out.println("--The member gets deleted--");
			MR.DeleteMember(id);
		} else {
			System.out.println("Okay back to the main menu");
			startM();
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
		yesNo = scan.next();
		checkYN = yesNo.charAt(0);
		if (checkYN == 'Y' || checkYN == 'y') {
			BoatTypes type;
			MR.getMember(id).addBoat(BoatTypes.getBoatType(typeOfBoat), Integer.parseInt(lengthOfBoat));
		}
	}

	private void changeBoat(int userID) {

	}

	private void deleteBoat(int userID) {
//		MR.getMemberList().get(userID).getBoatList();
		System.out.println("Which boat do you want to delete?");
		String deleteBoat = userIn;
		deleteBoat = scan.next();
		System.out.print(deleteBoat);
//		MR.getMember(userID).deleteBoat(boats);
	}
	
	
	private void initFile() {
		String fileName= "file.txt";

		try {
			ArrayList<String> arr = new ArrayList<String>();
			String line = null;
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			int counter = 0;
			while((line = br.readLine()) != null) {
				if(line.equals(",")) {
					Member m = new Member(arr.get(0), arr.get(1));
					for(int i = 0; i < Integer.parseInt(arr.get(3)); i++) {
						m.addBoat(BoatTypes.getBoatType(arr.get(4+(counter))), Integer.parseInt(arr.get(5+(counter))));
						counter+=2;
					}
					counter = 0;
					MR.AddMember(m);
					arr.clear();
				}else {
					arr.add(line);
					}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private void fileHandler(ArrayList<Member> arrayList) {
		File file = new File("file.txt");
		if(!file.exists()) {
			try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			saveFileInfo(writer,arrayList);
			writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			try {
			file.delete();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
			saveFileInfo(writer,arrayList);
			writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void saveFileInfo(BufferedWriter writer, ArrayList<Member> arrayList) {
		
	for(int i = 0; i < arrayList.size(); i++) {
		  try {
			writer.write(arrayList.get(i).getName() + System.lineSeparator());
			writer.write(arrayList.get(i).getPersonNum() + System.lineSeparator());
			  writer.write(arrayList.get(i).getID() + System.lineSeparator());
			  writer.write(arrayList.get(i).getAmountOfBoats() + System.lineSeparator());
			  if (arrayList.get(i).getAmountOfBoats() > 0) {
					for (int j = 0; j <arrayList.get(i).getAmountOfBoats(); j++) {
						writer.write(arrayList.get(i).getBoatList().get(j).getType().toString() + System.lineSeparator());
						writer.write((int) arrayList.get(i).getBoatList().get(j).getLength() +	 System.lineSeparator());
					}
			}
				writer.write("," + System.lineSeparator());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	}
	arrayList.clear();
}
}