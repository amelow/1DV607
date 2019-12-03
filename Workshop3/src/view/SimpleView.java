package view;

public class SimpleView implements IView {
	
	private final char play = 'p';
	private final char hit = 'h';
	private final char stand = 's';
	private final char quit = 'q';

	public void DisplayWelcomeMessage() {
	//	for (int i = 0; i < 50; i++) {
	///		System.out.print("\n");
		//}
		;
		System.out.println("Hello Black Jack World");
		System.out.println("Type 'p' to Play, 'h' to Hit, 's' to Stand or 'q' to Quit\n");
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
	
	public Action getAction() {
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
		System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
	}

	public void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score) {
		DisplayHand("Player", a_hand, a_score);
	}

	public void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score) {
		DisplayHand("Dealer", a_hand, a_score);
	}

	private void DisplayHand(String a_name, Iterable<model.Card> a_hand, int a_score) {
		System.out.println(a_name + " Has: ");
		for (model.Card c : a_hand) {
			DisplayCard(c);
		}
		System.out.println("Score: " + a_score);
		System.out.println("");
	}

	public void DisplayGameOver(boolean a_dealerIsWinner) {
		System.out.println("GameOver: ");
		if (a_dealerIsWinner) {
			System.out.println("Dealer Won!");
		} else {
			System.out.println("You Won!");
		}

	}
}
