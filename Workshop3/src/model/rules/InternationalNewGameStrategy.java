package model.rules;

import model.Dealer;
import model.Player;
import model.Card;

class InternationalNewGameStrategy implements INewGameStrategy {
	private Dealer dealer;

	public boolean NewGame(Dealer a_dealer, Player a_player) { // removing deck
		dealer = a_dealer;
		Card c;

		dealer.DealCard(a_player, true);
		dealer.DealCard(a_dealer, true);
		dealer.DealCard(a_player, true);

		return true;
	}
}