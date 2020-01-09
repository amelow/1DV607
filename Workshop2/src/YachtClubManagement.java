import java.util.Scanner;

import controller.Controller;
import model.MemberRegister;
import view.EnglishView;
import view.IView;
import view.SwedishView;

/*
 * Author: Amelie Löwe for the  1DV607 course
 */
public class YachtClubManagement {

	public static void main(String[] args) {
		Languages l = chooseLanguage();
		MemberRegister memReg = new MemberRegister();
		IView view;
		if (l.equals(Languages.Swedish))
			view = new SwedishView(memReg);
		else
			view = new EnglishView(memReg);
		new Controller(memReg,view);
	}

	public static Languages chooseLanguage() {
		System.out.println("\n" + "Choose your Language || Välj ditt språk");
		System.out.println("---------------------------------------" + "\n");
		System.out.println("For English, press (e)|| För Engelska, tryck (e)");
		System.out.println("For Swedish, press (s)|| För Svenska, tryck (s)");

		Scanner scan =new Scanner(System.in);
		String userIn = scan.next();
		if (userIn.contains("s")) {
			return Languages.Swedish;
		} else {
			return Languages.English;
		}
	}

	enum Languages {
		Swedish, English;
	}

}
