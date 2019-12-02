package model.rules;

import model.Dealer;
import model.Player;
import model.Card;

class AmericanNewGameStrategy implements INewGameStrategy {
	private Dealer dealer;

	public boolean NewGame(Dealer a_dealer, Player a_player) {// removing deck
		Card c;
		dealer = a_dealer;

		dealer.DealCard(a_player, true);

		dealer.DealCard(a_dealer, true);

		dealer.DealCard(a_player, true);

		dealer.DealCard(a_dealer, false);

		return true;
	}
}