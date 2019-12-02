package model.rules;

import model.Dealer;
import model.Player;

//Comment: Deck can also be removed from the INewGameStrategy interface
public interface INewGameStrategy {
	boolean NewGame(Dealer a_dealer, Player a_player); // removing deck
}
