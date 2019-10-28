package model.rules;

import model.Deck;
import model.Dealer;
import model.Player;
import model.Card;

class AmericanNewGameStrategy implements INewGameStrategy {
	private Dealer dealer;
	

	public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
		Card c;
		dealer = a_dealer;
		

//		c = a_deck.GetCard();
//		c.Show(true);
//		a_player.DealCard(c);
		dealer.DealCard(a_player,true);

//		c = a_deck.GetCard();
//		c.Show(true);
//		a_dealer.DealCard(c);
		dealer.DealCard(a_dealer,true);

//		c = a_deck.GetCard();
//		c.Show(true);
//		a_player.DealCard(c);
		dealer.DealCard(a_player,true);

//		c = a_deck.GetCard();
//		c.Show(false);
//		a_dealer.DealCard(c);
		dealer.DealCard(a_dealer,false);

		return true;
	}
}