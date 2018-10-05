package processor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import domain.*;

public class PositionBook {
	private ConcurrentHashMap<String, List<TradeEvent>> trades;
	private ConcurrentHashMap<TradeKey, Integer> positions;
	public PositionBook()
	{
		trades=new ConcurrentHashMap<String, List<TradeEvent>>();
		positions=new ConcurrentHashMap<TradeKey, Integer>();
	}
	public void addtrade(TradeEvent t)
	{
		TradeKey k=t.gettradekey();
		List<TradeEvent> l;
		if (!(trades.containsKey(k.getacc_id())))
			l=new ArrayList<TradeEvent>();
		else
			l=trades.get(k.getacc_id());
		l.add(t);
		trades.put(k.getacc_id(),l);
		
		

		int position=0,newposition=0;
		TradeType type=t.gettrade_type();
		if((positions.containsKey(k)))
			position=positions.get(k);
		if (type!=TradeType.CANCEL)
			newposition=compute(type,position,t.getquantity());
			
		
		else if (type==TradeType.CANCEL)
		{
			List<TradeEvent> li=trades.get(t.gettradekey().getacc_id());
			for(TradeEvent t1:li)
			{
				if(t1.gettradekey().equals(k) && t1.gettrade_id()==t.gettrade_id())
				{
					newposition=compute(t1.gettrade_type().opposite(),position,t1.getquantity());
					break;
				}
			}
		}
		positions.put(k, newposition);
		
	}
	
	public int compute(TradeType t, int position, int newvalue)
	{
		if (t==TradeType.BUY)
			return (position+newvalue);
		else
			return (position-newvalue);
	}
	public Integer getposition(TradeKey k)
	{
		if (positions.containsKey(k))
		{	System.out.println("IT worked");
			return positions.get(k);}
//		for(TradeKey keys: positions.keySet())
//			if(keys.equals(k))
//				return positions.get(keys);
		return null;
	}
	
	public List gettrades(String acc_id)
	{
		List<TradeEvent> l=new ArrayList<TradeEvent>();
		for(TradeEvent t:trades.get(acc_id))
			l.add(t);
		return l;
	}

}
