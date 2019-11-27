package view;

public interface IView {
	void DisplayWelcomeMessage();
	
	public IView.Action getAction();
	
	public enum Action{PLAY, HIT, STAND, QUIT}

	int GetInput();

	void DisplayCard(model.Card a_card);

	void DisplayPlayerHand(Iterable<model.Card> a_hand, int a_score);

	void DisplayDealerHand(Iterable<model.Card> a_hand, int a_score);

	void DisplayGameOver(boolean a_dealerIsWinner);
}
