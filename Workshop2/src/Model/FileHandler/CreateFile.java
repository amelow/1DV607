package Model.FileHandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Model.Member;

public class CreateFile {
	private SaveFile save = new SaveFile();

	public void fileHandler(ArrayList<Member> arrayList) {
		File file = new File("YachtClubRegister.txt");
		if (!file.exists()) {
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				save.saveFileInfo(writer, arrayList);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				file.delete();
				BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
				save.saveFileInfo(writer, arrayList);
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
