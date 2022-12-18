package spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import pojo_models.Admin;
import pojo_models.Images;
import pojo_models.Item;
import pojo_models.Review;
import pojo_models.Shopkeeper;
import spring.dao.AdminDao;
import spring.dao.ImageDao;
import spring.dao.ItemDao;
import spring.dao.ReviewDao;
import spring.dao.Shopkeeperdao;
import spring.search.Category;
import spring.search.GetRating;
import spring.search.ImageFetch;
import spring.search.MainSearch;

@Controller
public class ProcessingContoller {

	@Autowired
	private spring.service.ShopkeeperService ShopkeeperService;
	
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private ItemDao itemDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private Shopkeeperdao shopkeeperDao;
	
	@Autowired
	private AdminDao adminDao;

	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}
	
	@RequestMapping(path="/processform",method=RequestMethod.POST)
	public String handleform(@ModelAttribute("s1") Shopkeeper s1, Model model) {
		
		int s_id=this.shopkeeperDao.saveShopkeeper(s1);
		model.addAttribute("id",s_id);
		return "uploading";
	}	

	
	@RequestMapping(path="/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/images")
	public String images() {
		return "images";
	}

	@RequestMapping("/view_bus")
	public String view() {
		return "form";
	}

	@RequestMapping(path="/search_bus")
	public String search_bus(Model m,@RequestParam(required=false,name="lat") String lat,@RequestParam(required=false,name="lng") String lng) {
			try {
			double l=Double.parseDouble(lat);
			double longi=Double.parseDouble(lng);	
			System.out.println(l);
			System.out.println(longi);
	
		List<Shopkeeper> add=shopkeeperDao.getShopkeeper();
		List<String> categories = new ArrayList<String>();
		for(int i=0;i<add.size();i++) {
			categories.add(add.get(i).getType().toLowerCase());
			double bus_lat=Double.parseDouble(add.get(i).getLat());
			double bus_lng=Double.parseDouble(add.get(i).getLng());

			
			//It will give distance in meters
			double dist = org.apache.lucene.util.SloppyMath.haversinMeters(bus_lat, bus_lng,l, longi );
			double d1=dist/1000;
			d1= (double) Math.round(d1 * 100) / 100;
			Shopkeeper s=shopkeeperDao.getBusiness(add.get(i).getId());
			s.setDist(d1);
			shopkeeperDao.updateBusiness(s);
			
		}
		HashSet<String> hset = new HashSet<String>(categories);
		List<Shopkeeper> modified_add=shopkeeperDao.getShopkeeper();
		m.addAttribute("business",modified_add);
		m.addAttribute("categories",hset);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		return "shop";
	}
	
	@RequestMapping(path="/delete/{shopkeeperId}")
	public RedirectView delete(@PathVariable("shopkeeperId") int shopkeeperId,HttpServletRequest request) {
		this.shopkeeperDao.delete(shopkeeperId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
		
	}
	
	
	@RequestMapping(path="/filter/{category}")
	public String filter(@PathVariable("category") String category,HttpServletRequest request,Model m) {
		List<Shopkeeper> shops=shopkeeperDao.getShopkeeper();
		List<Shopkeeper> filtered =MainSearch.display(1, category, 0, 0, null, shops);
		List<Images> img=imageDao.getImages();
		ImageFetch.returnImage(img,filtered);
		
		
		m.addAttribute("business",filtered);
		HashSet<String> hset=Category.getCategories(filtered);
		m.addAttribute("categories",hset);
		return "shop";
		
	}
	
	@RequestMapping("/filter_bus")
	public String f(@RequestParam("search")String name,Model m) {
		List<Shopkeeper> shops=shopkeeperDao.getShopkeeper();
		List<Shopkeeper> s=MainSearch.display(3,null, 0.0,0.0,name,shops);
		m.addAttribute("business",s);
		HashSet<String> hset=Category.getCategories(s);
		m.addAttribute("categories",hset);
		return "shop";
	}
	
	@RequestMapping(path="/filter_cat/{choice}")
	public String filter_dist(@PathVariable("choice") int choice,HttpServletRequest request,Model m) {

		List<Shopkeeper> shops=shopkeeperDao.getShopkeeper();
		List<Images> shop_images=imageDao.getImages();
		double dist1=0.0,dist2=0.0;
		if(choice==1) {
		dist1=0.0;
		dist2=50.0;
		}
		else if(choice==2) {
			dist1=50.0;
			dist2=100.0;
		}
		else if(choice==3) {
			dist1=100.0;
			dist2=200.0;
		}
		else if(choice==4) {
			dist1=200.0;
			dist2=Double.POSITIVE_INFINITY;
		}
		List<Shopkeeper> filtered=MainSearch.display(2,null, dist1, dist2, null, shops);
		m.addAttribute("business",filtered);
		HashSet<String> hset=Category.getCategories(filtered);
		m.addAttribute("categories",hset);
		return "shop";
		
	}
	
	@RequestMapping(path="/goto_bus",method=RequestMethod.POST)
	public String handlebus(@RequestParam("email") String email,@RequestParam("password") String password, Model m) {
		float avg=0;
		List<Shopkeeper> add=shopkeeperDao.getShopkeeper();
		int bus_id=0;
		try {
		for(int i=0;i<add.size();i++) {
			if(add.get(i).getEmail().equals(email) && add.get(i).getPassword().equals(password)) {
				int id=add.get(i).getId();
				List<Images> shop_images=imageDao.getImages();
				List<String> pic=new ArrayList<String>();
				List<String> four_pic=new ArrayList<String>();
				String base_pic;
				for(int i1=0;i1<shop_images.size();i1++) {
					int s_id=shop_images.get(i1).getShop().getId();
					if(s_id==id) {
						bus_id=s_id;
						pic.add(shop_images.get(i1).getImage());
					}
				}
				if(pic.isEmpty()) {
					base_pic="no_img.jpg";
				}else {
					base_pic=pic.remove(0);
				}
				
				int val=3;
				int n=pic.size();
				if(n<val) {
					int diff=val-n;
					for(int i2=0;i2<n;i2++) {
						four_pic.add(pic.get(i2));
					}
					for(int i2=0;i2<diff;i2++) {
						four_pic.add("no_img.jpg");
					}
				}else {
					for(int i2=0;i2<3;i2++) {
						four_pic.add(pic.get(i2));
					}
				}
				
				Shopkeeper s1=shopkeeperDao.getBusiness(id);
				List<Review> reviews=reviewDao.getReviews();
				List <Review> rev=GetRating.getSpecificRating(reviews,s1.getId());
				List<Integer> lst=GetRating.fetchRatings(rev);

				
				int st_1=lst.remove(0);
				int st_2=lst.remove(0);
				int st_3=lst.remove(0);
				int st_4=lst.remove(0);
				int st_5=lst.remove(0);
				int total_sum=st_1+ st_2+st_3+ st_4 +st_5;
				int value=st_1+ 2 * st_2+ 3 * st_3+ 4 * st_4+ 5 * st_5;
				if(total_sum!=0) {
					avg=value/total_sum;
				}
				else {
					avg=0;
				}
				m.addAttribute("s1",s1);
				m.addAttribute("base",base_pic);
				m.addAttribute("four_pic",four_pic);
				m.addAttribute("star_1",st_1);
				m.addAttribute("star_2",st_2);
				m.addAttribute("star_3",st_3);
				m.addAttribute("star_4",st_4);
				m.addAttribute("star_5",st_5);
				m.addAttribute("count",total_sum);
				m.addAttribute("avg",avg);
			return "profile";
			}
			
		}
		System.out.println(email);
		}
		catch(Exception e){
			e.printStackTrace();
	      
		}
		return "login";
	}
	
	@RequestMapping(path="/update/{shopkeeperId}")
	public String update(@PathVariable("shopkeeperId") int shopkeeperId,HttpServletRequest request,Model m) {
		Shopkeeper s=shopkeeperDao.getBusiness(shopkeeperId);
		m.addAttribute("s1",s);
		return "update";
	}
	
	@RequestMapping(path="/add/{shopkeeperId}")
	public String add(@PathVariable("shopkeeperId") int shopkeeperId,HttpServletRequest request,Model m) {
		Shopkeeper s=shopkeeperDao.getBusiness(shopkeeperId);
		m.addAttribute("id",shopkeeperId);
		return "additem";
	}
	
	@RequestMapping(path="/add/processitems",method=RequestMethod.POST)
	public RedirectView processingItems(@RequestParam("image") CommonsMultipartFile file,@RequestParam("sub_cat") String sub_cat,@RequestParam("name") String name,@RequestParam("price") String price,@RequestParam("bus_id") String bus_id,HttpSession s,Model m,HttpServletRequest request) {
		System.out.println(bus_id);
		Integer shop_id=Integer.parseInt(bus_id);
		Item it=new Item(shop_id,sub_cat,name,price,file.getOriginalFilename());
		byte[] data=file.getBytes();
		
		String path=s.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+"images"+File.separator+file.getOriginalFilename();
		System.out.println(path);
		//we have to save the file to server...
		try {
			FileOutputStream fos=new FileOutputStream(path);
			fos.write(data);
			fos.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		itemDao.saveItem(it);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/");
		return redirectView;
	}
	
	
	@RequestMapping(path="/handle_updating",method=RequestMethod.POST)
	public String handle_update(@ModelAttribute("shop") Shopkeeper shop,Model model) {
	shopkeeperDao.updateBusiness(shop);
		return "home";
	}
	

	
}
