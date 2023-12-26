
public class TipStrategyDefault implements TipStrategy {
	@Override
	public double calculate(double bill, int tipPercent) {
		return bill * tipPercent * 0.01;
	}
}
