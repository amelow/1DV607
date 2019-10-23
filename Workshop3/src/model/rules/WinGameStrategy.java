package model.rules;

public class WinGameStrategy implements ITheWinnerStrategy {
	private int equalHitLimit = 21;

	@Override
	public boolean isWinner(int dealerScore, int playerScore) {

		if (dealerScore == playerScore && playerScore == equalHitLimit) {
			System.out.println("dealerScore" + dealerScore);
			System.out.println("playerScore" + playerScore);
			return true;
		}

		return false;
	}

}
