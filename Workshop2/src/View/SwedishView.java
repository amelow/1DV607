package View;

public class SwedishView implements ViewInterface {

	@Override
	public void MainMenu() {
		String choose = "Vad vill du göra?";
		String alt1 = "För att visa verbose-listan, tryck()";
		String alt2 = "För att visa compact-listan, tryck()";
		String alt3 = "För att lägga till en medlem, tryck ()";
		String alt4 = "För att ändra en medlems information, tryck()";
		String alt5 = "För att spara och stänga av, tryck (Q)";

		System.out.println(choose + "\n");
		System.out.println(alt1);
		System.out.println(alt2);
		System.out.println(alt3);
		System.out.println(alt4);
		System.out.println(alt5);

	}

}
