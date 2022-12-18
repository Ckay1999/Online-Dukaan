package spring.search;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo_models.Shopkeeper;
import spring.dao.Shopkeeperdao;

public class SearchDist implements IBusinessSearch {
	private double dist1;
	private double dist2;

	public SearchDist(double dist1, double dist2) {
		super();
		this.dist1 = dist1;
		this.dist2 = dist2;
	}

	public List<Shopkeeper> findShops(List<Shopkeeper> shops){
		List<Shopkeeper> dist_lst=new ArrayList<Shopkeeper>();

		Iterator<Shopkeeper> iter= shops.iterator();
		
		while(iter.hasNext()) {
			Shopkeeper s=iter.next();
			if(dist1<s.getDist() && s.getDist()<dist2) {
				dist_lst.add(s);
			}
		}
		
		return dist_lst;
	}
}
