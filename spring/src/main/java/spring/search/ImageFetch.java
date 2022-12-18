package spring.search;

import java.util.*;

import pojo_models.Images;
import pojo_models.Shopkeeper;
import pojo_models.Images;

public class ImageFetch {
public static String returnImage(List<Images> img, List<Shopkeeper> shop ) {
	String pic="";
	for(int i=0;i<shop.size();i++) {
			int id=shop.get(i).getId();
			for(int i1=0;i1<img.size();i1++) {
				int s_id=img.get(i1).getShop().getId();
				if(s_id==id) {
					pic=img.get(i1).getImage();
				}
	
}
}
	return pic;
}
}
	
