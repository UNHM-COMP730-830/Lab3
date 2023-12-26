
// Singleton Class
public class TipSettings {
	
	private static TipSettings INSTANCE;
	private int tipPercent = 20;
	private TipStrategy tipStrategy = new TipStrategyDefault();
	
	private TipSettings() {
	}
	
	public static TipSettings getInstance() {
		// Lazy initialization
		if (INSTANCE == null) INSTANCE = new TipSettings();
		return INSTANCE;
	}
	
	public int getTipPercent() {
		return tipPercent;
	}
	
	public void setTipPercent(int value) {
		tipPercent = value;
	}
	
	public TipStrategy getTipStrategy() {
		return tipStrategy;
	}
	
	public void setTipStrategy(TipStrategy value) {
		tipStrategy = value;
	}
}
