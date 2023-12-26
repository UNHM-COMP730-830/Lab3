
public class TipStrategyRoundDown implements TipStrategy {
	@Override
	public double calculate(double bill, int tipPercent) {
		double tipAmount = bill * tipPercent * 0.01;
		return Math.floor(tipAmount);
	}
}
