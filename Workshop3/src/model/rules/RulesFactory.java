package model.rules;

public class RulesFactory {

	public IHitStrategy GetHitRule() {
		return new SoftXStrategy();
	}

	public INewGameStrategy GetNewGameRule() {
		return new AmericanNewGameStrategy();
	}
}