package spring.search;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import pojo_models.Shopkeeper;
import spring.dao.Shopkeeperdao;

public class SearchCategory implements IBusinessSearch{
	private String category;


	public SearchCategory(String category) {
		super();
		this.category = category;
	}
	
	public List<Shopkeeper> findShops(List<Shopkeeper> shops){
		List<Shopkeeper> cat_lst=new ArrayList<Shopkeeper>();
		Iterator<Shopkeeper> iter= shops.iterator();
		
		while(iter.hasNext()) {
			Shopkeeper s=iter.next();
			if(s.getType().toLowerCase().equals(category)) {
				cat_lst.add(s);
			}
		}
		return cat_lst;
	}
}
