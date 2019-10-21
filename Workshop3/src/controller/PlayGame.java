package controller;

import model.Game;
import view.IView;

public class PlayGame {

	public boolean Play(Game a_game, IView a_view) {

		a_game.IsGameOver();

		int input = a_view.GetInput();

		if (input == 'p') {
			a_game.NewGame();
		} else if (input == 'h') {
			a_game.Hit();
		} else if (input == 's') {
			a_game.Stand();
		}

		return input != 'q';
	}
}
