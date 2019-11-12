package Model.FileHandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Model.BoatTypes;
import Model.Member;
import Model.MemberRegister;

public class InitFile {

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

					Member m = new Member(arr.get(0), arr.get(1), Integer.parseInt(arr.get(2))); // gets the name and
																									// the personal
																									// number from file
					for (int i = 0; i < Integer.parseInt(arr.get(3)); i++) {
						m.addBoat(BoatTypes.getBoatType(arr.get(4 + (counter))), // gets the boattypes from file
								Integer.parseInt(arr.get(5 + (counter))));
						counter += 2;
					}
					counter = 0;
					memReg.addMember(m); // add the members
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
}