package controller;

import model.Game;
import model.observer.IObserver;
import view.IView;
import view.IView.Action;
/*
 * Code provided by Tobias Ohlsson for the 1DV607 course.
 * Changes are made by Amelie Löwe and Johan Eriksson
 */

public class PlayGame implements IObserver {
	private Game observ_game;
	private IView observ_view;
	private int sleepTime = 2500;

	// new constructor
	public PlayGame(Game a_game, IView a_view) {
		observ_game = a_game;
		observ_view = a_view;
		// a_game.newGameObserver(this);
		// a_game.IsGameOver();
	}

	// removing the hidden dependencies
	public boolean Play() {
		this.observ_view.DisplayWelcomeMessage();
		Action userChoice = observ_view.getAction();
		while (!observ_game.IsGameOver())
			if (userChoice == Action.PLAY) {
				observ_game.NewGame();
			} else if (userChoice == Action.HIT) {
				observ_game.Hit();
			} else if (userChoice == Action.STAND) {

			}

		if (observ_game.IsGameOver()) {
			observ_view.DisplayGameOver(observ_game.IsDealerWinner());
		}
		/*
		 * m_view.DisplayWelcomeMessage();
		 * 
		 * m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
		 * m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
		 * 
		 * if (m_game.IsGameOver()) { m_view.DisplayGameOver(m_game.IsDealerWinner()); }
		 * 
		 * IView.Intent input = m_view.getIntent();
		 * 
		 * if (input == IView.Intent.NewGame) { m_game.NewGame(); } else if (input ==
		 * IView.Intent.Hit) { m_game.Hit(); } else if (input == IView.Intent.Stand) {
		 * m_game.Stand(); } return input != IView.Intent.Quit;
		 */
//		if (input == 'p') {
//			a_game.NewGame();
//		} else if (input == 'h') {
//			a_game.Hit();
//		} else if (input == 's') {
//			a_game.Stand();
//		}
//
//		return input != 'q';
		return false;
	}

	@Override
	public void infoToObservers() {
		System.out.println("--------infoToObservers----------");
		try {
			Thread.sleep(sleepTime);
			observ_view.DisplayDealerHand(observ_game.GetDealerHand(), observ_game.GetDealerScore());
			observ_view.DisplayPlayerHand(observ_game.GetPlayerHand(), observ_game.GetPlayerScore());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
