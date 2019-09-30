package theYachtClub;

public class View {

	public void welcome() {
		String hi = "Hi and Welcome!" + "\n";
		System.out.println(hi);

	}

	public void mainMenu() {
		String choose = "What do you want to do?";
		String alt1 = "Add member (1)";
		String alt2 = "Change member info(2)";
		String alt3 = "Show compactlist(3)";
		String alt4 = "Show verboselist(4)";
		String SQ = "Save and quit (Q)";

		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(SQ);
	}
	/*
	 * public void compactList() { for (Member member : m) {
	 * System.out.println(member.getName() + "," + member.getID() + "," + "," +
	 * member.getAmountOfBoats()); } }
	 * 
	 * public void verboseList() { for (Member member : m) {
	 * System.out.println(member.getName() + "," + "," + member.getPersonNum() + ","
	 * + member.getID() + ", Boats:"); } }
	 */

}