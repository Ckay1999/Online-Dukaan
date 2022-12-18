package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import pojo_models.Admin;
import pojo_models.Images;
import pojo_models.Item;
import pojo_models.Shopkeeper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import spring.dao.AdminDao;
import spring.dao.ImageDao;
import spring.dao.ItemDao;
import spring.dao.Shopkeeperdao;
import spring.search.MainSearch;


@Controller
public class WebsiteController {

	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private Shopkeeperdao shopkeeperDao;
	
	@Autowired
	private spring.service.ImageService imageService;
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private ItemDao itemDao ;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/upload")
	public String upload_img(){
	return "uploading";	
	}

	@RequestMapping("/admin")
	public String admin_login() {
		return "admin_login";
	}
	
	@RequestMapping(path="/delete_bus",method=RequestMethod.POST)
	public String delete_bus(@RequestParam("userid") String userid,@RequestParam("password") String password, Model m) {

		List<Admin> add=adminDao.Admin_info();
		for(int i=0;i<add.size();i++) {
			if(add.get(i).getUserid().equals(userid) && add.get(i).getPassword().equals(password)) {
				return "delete";
			}
		}
		return "admin_login";
	}
	
	@RequestMapping(path="/deleting",method=RequestMethod.POST)
	public String deleting(@RequestParam("id")String id) {
		Integer del_id=Integer.parseInt(id);
		shopkeeperDao.delete(del_id);
		return "home";
	}
	
	
	@RequestMapping(path="/handle_img", method=RequestMethod.POST)
	public String handle_image(@RequestParam("image") CommonsMultipartFile[] file,@RequestParam("id") Integer id, HttpSession s,Model m){
		Images img=new Images();
		Shopkeeper shop=shopkeeperDao.getBusiness(id);
		shop.setImage(file[0].getOriginalFilename());
		shopkeeperDao.updateBusiness(shop);
		for(int i=0;i<file.length;i++) {
		byte[] data=file[i].getBytes();
		
		String path=s.getServletContext().getRealPath("/")+"WEB-INF"+File.separator+"resources"+File.separator+file[i].getOriginalFilename();
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
		
		img.setImage(file[i].getOriginalFilename());
		img.setShop(shop);
		imageDao.saveImage(img);
		m.addAttribute("s1",shop);
			
		
	}
	List<Images> imag=imageDao.getImages();	
	shop.setImages(imag);
	return "login";	
	}


	
}


