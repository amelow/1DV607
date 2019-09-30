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

	public void AddName() {
		System.out.println("Please enter your name: ");

	}

	public void AddPersonNum() {
		System.out.println("Please enter your personal-number: YYYYMMDDXXXX");
	}
	
	public void correctName(String str) {
		String nameQ = "Is this correct? Your name is: " + str + " (y/n)";
		
		System.out.println(nameQ);
	}
	
	public void correctPersonNum(long id) {
		String idPer = "Is this correct? Your person number is: " + id + " (y/n)";
		
		System.out.println(idPer);
	}
	
	public void saveMember(String str, long id) {
		String save = "Do you want to save the member with name " + str + " and personal number " + id + "?";
		
		System.out.println(save);
	}

	public void added() {
		String added = "member is now added";
		
		System.out.println(added);
		
	}

}