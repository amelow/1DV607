package theYachtClub;

public class View {

	public void welcome() {
		String hi = "Hi and Welcome!";
		System.out.println(hi);

	}

	public void mainMenu() {
		String choose = "What do you want to do?";
		String alt1 = "Show compactlist(1)";
		String alt2 = "Show verboselist(2)";
		String alt3 = "Add member (3)";
		String SQ = "Save and quit (Q)";

		System.out.println(choose);
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(SQ);
	}

	public void compactList() {
		for (Member member : m) {
			System.out.println(member.getName() + "," + member.getID() + "," + "," + member.getAmountOfBoats());
		}
	}

	public void verboseList() {
		for (Member member : m) {
			System.out.println(member.getName() + "," + "," + member.getPersonNum() + "," + member.getID() + ", Boats:");
		}
	}

}