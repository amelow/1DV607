package model.rules;

public class WinGameStrategy implements ITheWinnerStrategy {
	private int equalHitLimit = 21;

	@Override
	public boolean isWinner(int dealerScore, int playerScore) {
		if (dealerScore < playerScore && playerScore <= equalHitLimit) {
			return false;
		}
		else if (dealerScore > playerScore && dealerScore < equalHitLimit) {
			return true;
		}
		else if (dealerScore == playerScore && playerScore == equalHitLimit) {
			return false;
		}
		else if (dealerScore == playerScore && playerScore != equalHitLimit) {
			return true;
		} else {
			return true;
		}

		
	}

}
