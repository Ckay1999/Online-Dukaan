package spring.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojo_models.Review;
import spring.dao.ReviewDao;
import spring.dao.Shopkeeperdao;
import spring.service.EmailService;

@Controller
public class ReviewController {
	
	Random random=new Random(1000);
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private ReviewDao reviewDao;
	
	@Autowired
	private Shopkeeperdao shopkeeperDao;
	
	@RequestMapping(path="/review/{bus_id}")
	public String review(@PathVariable("bus_id") int bus_id,Model m) {
		m.addAttribute("id",bus_id);
		return "email";
	}
	
	@RequestMapping(path="/otp",method=RequestMethod.POST)
	public String get_otp(@RequestParam("email") String email,@RequestParam("id") Integer id,Model m) {		
		//Generating otp	
		int otp=random.nextInt(99999);
		System.out.println(otp);
		String context="Dear User, welcome to Online Dukaan. Your otp is "+otp;
		this.emailService.sendEmail("Email verification",context,email);
		m.addAttribute("otp",otp);
		m.addAttribute("id",id);
		m.addAttribute("email",email);

		return "otp";
	}
	
	@RequestMapping(path="/verify",method=RequestMethod.POST)
	public String verify_otp(@RequestParam("otp") Integer otp,@RequestParam("otp1") Integer otp1,@RequestParam("email") String email,@RequestParam("id") Integer id,Model m) {
		m.addAttribute("id",id);
		if(otp.equals(otp1)) {	
			m.addAttribute("email",email);
			return "rate";
		}
		return "email";
	
	}
	
	@RequestMapping("/rate")
	public String give_ratings() {
		
		return "rate";
	}
	
	@RequestMapping(path="/stars_processing")
	public String handle_rating( @RequestParam("stars") Integer stars,@RequestParam("experience") String experience, @RequestParam("email") String email,@RequestParam("id") Integer id) {
		Review r=new Review();
		r.setEmail(email);
		r.setExperience(experience);
		r.setStars(stars);
		r.setShop(shopkeeperDao.getBusiness(id));
		reviewDao.saveReview(r);
	
		return "home";
	}
}
