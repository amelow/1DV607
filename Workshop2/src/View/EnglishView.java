package View;

public class EnglishView implements ViewInterface {

	@Override
	public void MainMenu() {
		String choose = "What do you want to do?";
		String alt1 = "To show the verboselist, enter()";
		String alt2 = "To show the compactlist, enter()";
		String alt3 = "To add a member, enter ()";
		String alt4 = "To change member info, enter()";
		String alt5 = "To save and quit the application, enter (Q)";
		
		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(alt5);

	}


}
