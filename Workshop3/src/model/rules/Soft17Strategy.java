package model.rules;

import model.Player;

public class Soft17Strategy implements IHitStrategy {
	/*
	 * Design and implement a new rule variant for when the dealer should take one
	 * more card. The new variant is “Soft 17″, use the same design pattern already
	 * present for Hit. Soft 17 means that the dealer has 17 but in a combination of
	 * Ace and 6 (for example Ace, two, two, two). This means that the Dealer can
	 * get another card valued at 10 but still have 17 as the value of the ace is
	 * reduced to 1. Using the soft 17 rule the dealer should take another card
	 * (compared to the original rule when the dealer only takes cards on a score of
	 * 16 or lower).
	 */

	private int upperLimit = 21;
	private int lowerUpperLimit = 17;

	@Override
	public boolean DoHit(Player a_dealer) {
		int dealerScore = a_dealer.CalcScore();
		int cardScores[] = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };

		if (dealerScore == upperLimit) {
			System.out.println("test");
			if (dealerScore < lowerUpperLimit) {
				return true;
			}
				
			else if (dealerScore == lowerUpperLimit && a_dealer.checkIfAce()) // soft 17
				return true;

			return false;
		}
		return false;
	}

}
