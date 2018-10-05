package domain;

public final class TradeEvent {
	private final int trade_id;
	private final TradeKey key;
	private final String trade_type;
	private final int quantity;
	
	public TradeEvent(int trade_id, String trade_type, String acc_id, String sec_id, int quantity)
	{
		this.trade_id=trade_id;
		key=new TradeKey(acc_id,sec_id);
		this.trade_type= trade_type;
		this.quantity=quantity;		
	}
	public int gettrade_id() {
		return this.trade_id;
	}
	
	public TradeKey gettradekey()
	{
		return new TradeKey(key.getacc_id(),key.getsec_id());
	}
	public TradeType gettrade_type()
	{
		return TradeType.valueOf(trade_type);
	}
	public int getquantity()
	{
		return quantity;
	}
}
