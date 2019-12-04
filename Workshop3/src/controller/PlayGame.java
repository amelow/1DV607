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
		this.observ_game = a_game;
		this.observ_view = a_view;
		//this.observ_game.newGameObserver(this);
	}

	// removing the hidden dependencies
	public boolean Play() {
		observ_game.IsGameOver();
		Action userChoice = observ_view.getAction();

		if (userChoice == Action.PLAY) {
			observ_game.NewGame();
		} else if (userChoice == Action.HIT) {
			observ_game.Hit();
		} else if (userChoice == Action.STAND) {
			observ_game.Stand();
		}
		return userChoice != Action.QUIT;
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
