package view;

public class EnglishView implements ViewInterface {

	@Override
	public void DisplayWelcomeMessage() {
		String hi = "\n" + "Hi and Welcome to the Boatclub!" + "\n";
		System.out.println(hi);
		System.out.println("-------------------------------");

	}

	@Override
	public void mainMenu() {
		String choose = "What would you like to do?";
		String alt0 = "To change the language to Swedish,enter(0)";
		String alt1 = "To add a member, enter (1)";
		String alt2 = "To change member info, enter(2)";
		String alt3 = "To show the compactlist, enter(3)";
		String alt4 = "To show the verboselist, enter(4)";
		String quit = "To quit the application, enter (Q)";

		System.out.println(choose + "\n");
		System.out.println(alt0);
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(quit);

	}

	@Override
	public void compactList() {
		// TODO Auto-generated method stub

	}

	@Override
	public void verboseList() {
		// TODO Auto-generated method stub

	}

}
