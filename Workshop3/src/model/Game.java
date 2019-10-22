package model;

import view.IView;

public class Game {

	private Dealer m_dealer;
	private Player m_player;
	private IView a_view;

	public Game(IView v) {
		m_dealer = new Dealer(new model.rules.RulesFactory());
		m_player = new Player();
		a_view = v;
	}

	public boolean IsGameOver() {
		UpdateView();
		boolean res = m_dealer.IsGameOver();
		if (res)
			a_view.DisplayGameOver(IsDealerWinner());
		return res;
	}

	public boolean IsDealerWinner() {
		return m_dealer.IsDealerWinner(m_player);
	}

	public boolean NewGame() {
		UpdateView();
		return m_dealer.NewGame(m_player);
	}

	public boolean Hit() {
		UpdateView();
		return m_dealer.Hit(m_player);
	}

	public boolean Stand() {
		UpdateView();
		return m_dealer.Stand();
	}

	public Iterable<Card> GetDealerHand() {
		return m_dealer.GetHand();
	}

	public Iterable<Card> GetPlayerHand() {
		return m_player.GetHand();
	}

	public int GetDealerScore() {
		return m_dealer.CalcScore();
	}

	public int GetPlayerScore() {
		return m_player.CalcScore();
	}

	private void UpdateView() {
		a_view.DisplayWelcomeMessage();
		a_view.DisplayDealerHand(GetDealerHand(), GetDealerScore());
		a_view.DisplayPlayerHand(GetPlayerHand(), GetPlayerScore());
	}

}
