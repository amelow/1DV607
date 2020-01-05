package Model.FileHandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Model.BoatTypes;
import Model.Member;
import Model.MemberRegister;

public class CreateFile {

	public void fileHandler(Iterator<Member> membersList) {
		File file = new File("YachtClubRegister.txt");
		if (!file.exists()) {
			file.delete();
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			saveFileInfo(writer, membersList);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveFileInfo(BufferedWriter writer, Iterator<Member> membersList) {

		while (membersList.hasNext()) {
			Member member = membersList.next();
			try {
				writer.write(member.getName() + System.lineSeparator());
				writer.write(member.getPersonNum() + System.lineSeparator());
				writer.write(member.getID() + System.lineSeparator());
				writer.write(member.getAmountOfBoats() + System.lineSeparator());
				if (member.getAmountOfBoats() > 0) {
					for (int j = 0; j < member.getAmountOfBoats(); j++) {
						writer.write(member.getBoatList().get(j).getType().toString() + System.lineSeparator());
						writer.write((int) member.getBoatList().get(j).getLength() + System.lineSeparator());
					}
				}
				writer.write("," + System.lineSeparator());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void initFile(MemberRegister memReg) {
		String fileName = "YachtClubRegister.txt";

		try {
			ArrayList<String> arr = new ArrayList<String>();
			String line = null;
			FileReader fileReader = new FileReader(fileName);
			BufferedReader buffReader = new BufferedReader(fileReader);
			int counter = 0;
			while ((line = buffReader.readLine()) != null) {
				if (line.equals(",")) {

					Member m = new Member(arr.get(0), arr.get(1), Integer.parseInt(arr.get(2)));
					for (int i = 0; i < Integer.parseInt(arr.get(3)); i++) {
						m.addBoat(BoatTypes.getBoatType(arr.get(4 + (counter))),
								Integer.parseInt(arr.get(5 + (counter))));
						counter += 2;
					}
					counter = 0;
					memReg.addMemberList(m, Integer.parseInt(arr.get(2)));
					arr.clear();
				} else {
					arr.add(line);
				}
			}
			buffReader.close();
		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
