package domain;

public enum TradeType {
	BUY,SELL,CANCEL;
	public TradeType opposite() {
        switch(this) {
            case BUY: return TradeType.SELL;
            case SELL: return TradeType.BUY;
            default: return null;
        }
	}
}
