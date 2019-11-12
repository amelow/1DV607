package Model.FileHandler;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

import Model.Member;

public class SaveFile {

	public void saveFileInfo(BufferedWriter writer, ArrayList<Member> arrayList) {

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
