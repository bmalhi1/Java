package domain;

public final class TradeKey {
	private final String acc_id;
	private final String sec_id;
	public TradeKey(String acc_id,String sec_id)
	{
		this.acc_id=acc_id;
		this.sec_id=sec_id;
	}
	public String getacc_id()
	{
		return this.acc_id;
	}
	public String getsec_id() {
		return this.sec_id;
	}
	public boolean equals(Object ob) {
	    if (ob == null) return false;
	    if (!(ob instanceof TradeKey))
	        return false;
	    if (ob == this)
	        return true;
	    if (this.getacc_id().equals(((TradeKey) ob).getacc_id()) && this.getsec_id().equals(((TradeKey) ob).getsec_id()))
	    	return true;
	    else
	    	return false;
	    
	}
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + acc_id.hashCode();
	    result = prime * result + sec_id.hashCode();
	    return result;
	}
}
