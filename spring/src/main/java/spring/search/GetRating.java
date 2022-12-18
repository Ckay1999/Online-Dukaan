package spring.search;
import java.util.*;

import pojo_models.Review;
public class GetRating {
	
	public static List<Review> getSpecificRating(List<Review> rev, int shop_id){
		List<Review> filtered=new ArrayList<Review>();
		for(int i=0;i<rev.size();i++) {
			if(rev.get(i).getShop().getId()==shop_id) {
				filtered.add(rev.get(i));
			}
		}
		return filtered;
		
	}
	
	public static List<Integer> fetchRatings(List<Review> rev){
		List<Integer> lst=new ArrayList<Integer>();
		int count_1=0,count_2=0,count_3=0,count_4=0,count_5=0;
		
		for(int i=0;i<rev.size();i++) {
			int r=rev.get(i).getStars();
			if(r==1) {
				count_1++;
			}
			else if(r==2) {
				count_2++;
			}
			else if(r==3) {
				count_3++;
			}
			else if(r==4) {
				count_4++;
			}
			else if(r==5) {
				count_5++;
			}
		}
		lst.add(count_1);
		lst.add(count_2);
		lst.add(count_3);
		lst.add(count_4);
		lst.add(count_5);
		return lst;
	}
}
