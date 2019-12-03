package controller;

import model.Game;
import model.observer.IObserver;
import view.IView;
/*
 * Code provided by Tobias Ohlsson for the 1DV607 course.
 * Changes are made by Amelie Löwe and Johan Eriksson
 */

public class PlayGame implements IObserver {
	private Game observ_game;
	private IView observ_view;
	private int sleepTime = 2500;

	public PlayGame(Game a_game, IView a_view) {
		observ_game = a_game;
		observ_view = a_view;
	//	a_game.newGameObserver(this);
	//	a_game.IsGameOver();
	}

	public boolean Play() {
		int input = observ_view.GetInput();
		if (input == 'p') {
			a_game.NewGame();
		} else if (input == 'h') {
			a_game.Hit();
		} else if (input == 's') {
			a_game.Stand();
		}

		return input != 'q';
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
