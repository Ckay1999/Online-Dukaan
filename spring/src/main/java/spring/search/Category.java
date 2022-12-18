package spring.search;
import pojo_models.Shopkeeper;
import java.util.*;
public class Category {
public static HashSet getCategories(List<Shopkeeper> shops) {
	
	List<String> categories=new ArrayList<String>();
	Iterator<Shopkeeper> iter= shops.iterator();
	
	while(iter.hasNext()) {
		Shopkeeper s=iter.next();
		categories.add(s.getType().toLowerCase());
	}
	
	HashSet<String> hset = new HashSet<String>(categories);
	return hset;
}

}
