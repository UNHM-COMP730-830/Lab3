
public class TipStrategyTotalRoundUp implements TipStrategy {
	@Override
	public double calculate(double bill, int tipPercent) {
		double tip = bill * tipPercent * 0.01;
		double roundedTotal = Math.ceil(tip + bill);
		return roundedTotal - bill;
	}
}
