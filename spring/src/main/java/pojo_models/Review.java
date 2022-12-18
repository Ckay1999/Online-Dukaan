package pojo_models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private int stars;
	private String email;
	private String experience;
	
	@ManyToOne
	private Shopkeeper shop;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStars() {
		return stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}



	public Shopkeeper getShop() {
		return shop;
	}

	public void setShop(Shopkeeper shop) {
		this.shop = shop;
	}

	
	public Review(int id, int stars, String email, String experience, Shopkeeper shop) {
		super();
		this.id = id;
		this.stars = stars;
		this.email = email;
		this.experience = experience;
		this.shop = shop;
	}

	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
