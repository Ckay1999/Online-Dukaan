package spring.search;
import java.util.*;
import pojo_models.Shopkeeper;
public class MainSearch {
	
	
public static List display(int action,String category, double dist1,double dist2,String name,List<Shopkeeper> shops) {
	List<Shopkeeper> lst=new ArrayList<Shopkeeper>();
	switch (action) {
	case 1:
		lst=search1(category,shops);
		break;
	case 2:
		lst=search2(dist1,dist2,shops);
		break;
	case 3:
		lst=search3(name,shops);
		break;
	default:
		lst=search(shops);
	}
	return lst;
}

//creating methods for different types of searches
public static List search1(String category,List<Shopkeeper> shops) {
	SearchCategory obj=new SearchCategory(category);
	return obj.findShops(shops);
}

public static List search2(double dist1,double dist2,List<Shopkeeper> shops) {
	SearchDist obj=new SearchDist(dist1,dist2);
	return obj.findShops(shops);
}

public static List search(List<Shopkeeper> shops) {
	NormalSearch obj=new NormalSearch();
	return obj.findShops(shops);
}

public static List search3(String name,List<Shopkeeper> shops) {
	BusinessSearch obj=new BusinessSearch(name);
	return obj.findShops(shops);
}

}
