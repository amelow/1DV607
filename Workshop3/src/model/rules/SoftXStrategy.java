package model.rules;

import model.Player;

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
public class SoftXStrategy implements IHitStrategy {
	private final int g_hitLimit = 17;

	@Override
	public boolean DoHit(Player a_dealer) {
		int currentDealerScore = a_dealer.CalcScore();
		if (currentDealerScore < g_hitLimit) {
			return true;
		}  
		if (g_hitLimit == currentDealerScore && a_dealer.checkIfAce()) {
			return true;
		}
		return false;
	}

}
