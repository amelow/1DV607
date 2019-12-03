
import model.Game;
import view.*;
import controller.*;
/*
 * Code provided by Tobias Ohlsson for the 1DV607 course.
 * Changes are made by Amelie Löwe and Johan Eriksson
 */
public class Program {

	public static void main(String[] a_args) {

		IView v = new SimpleView(); // new SwedishView();
		Game g = new Game(v);
		PlayGame ctrl = new PlayGame();

		while (ctrl.Play(g, v))
			;
	}
}