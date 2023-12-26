
public class TipStrategyRoundUp implements TipStrategy {
	@Override
	public double calculate(double bill, int tipPercent) {
		double tipAmount = bill * tipPercent * 0.01;
		return Math.ceil(tipAmount);
	}
}
