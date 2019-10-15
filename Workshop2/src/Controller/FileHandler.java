package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Model.BoatTypes;
import Model.Member;
import Model.MemberRegister;

public class FileHandler {
	private MemberRegister memReg = new MemberRegister();

	public void initFile() {
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

	public void fileHandler(ArrayList<Member> arrayList) {

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
