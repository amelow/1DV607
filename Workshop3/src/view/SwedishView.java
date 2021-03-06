package view;

public class SwedishView implements IView {
	
	private final char play = 'p';
	private final char hit = 'h';
	private final char stand = 's';
	private final char quit = 'q';
	
	public void DisplayWelcomeMessage() {

//		for (int i = 0; i < 50; i++) {
//			System.out.print("\n");
//		}
//		;

		System.out.println("Hej Black Jack Världen");
		System.out.println("----------------------");
		System.out.println("Skriv 'p' för att Spela, 'h' för nytt kort, 's' för att stanna 'q' för att avsluta\n");
	}

	public int GetInput() {
		try {
			int c = System.in.read();
			while (c == '\r' || c == '\n') {
				c = System.in.read();
			}
			return c;
		} catch (java.io.IOException e) {
			System.out.println("" + e);
			return 0;
		}
	}
	
	public IView.Action getAction() {
		int userInput = this.GetInput();
		if (userInput == play) {
			return Action.PLAY;
		}
		else if(userInput == hit) {
			return Action.HIT;
		}
		else if (userInput == stand) {
			return Action.STAND;
		}
		else if (userInput == quit) {
			return Action.QUIT;
		}
		else {
		return null;
		}
		
	}

	public void DisplayCard(model.Card a_card) {
		if (a_card.GetColor() == model.Card.Color.Hidden) {
			System.out.println("Dolt Kort");
		} else {
			String colors[] = { "Hjärter", "Spader", "Ruter", "Klöver" };
			String values[] = { "två", "tre", "fyra", "fem", "sex", "sju", "åtta", "nio", "tio", "knekt", "dam", "kung",
					"ess" };
			System.out.println("" + colors[a_card.GetColor().ordinal()] + " " + values[a_card.GetValue().ordinal()]);
		}
	}

	public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score) {
		DisplayHand("Spelare", a_hand, a_score);
	}

	public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score) {
		DisplayHand("Croupier", a_hand, a_score);
	}

	public void DisplayGameOver(boolean a_dealerIsWinner) {
		System.out.println("Slut: ");
		if (a_dealerIsWinner) {
			System.out.println("Croupiern Vann!");
		} else {
			System.out.println("Du vann!");
		}
	}

	private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score) {
		System.out.println(a_name + " Har: " + a_score);
		for (model.Card c : a_hand) {
			DisplayCard(c);
		}
		System.out.println("Poäng: " + a_score);
		System.out.println("");
	}
}
