package spring.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pojo_models.Shopkeeper;

public class BusinessSearch implements IBusinessSearch{
	private String bus_name;


	
	public BusinessSearch(String bus_name) {
		super();
		this.bus_name = bus_name;
	}



	public List<Shopkeeper> findShops(List<Shopkeeper> shops){
		List<Shopkeeper> bus_lst=new ArrayList<Shopkeeper>();
		Iterator<Shopkeeper> iter= shops.iterator();
		
		while(iter.hasNext()) {
			Shopkeeper s=iter.next();
			if(s.getBus_name().equals(bus_name)) {
				bus_lst.add(s);
			}
		}
		return bus_lst;
	}
}
