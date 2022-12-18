 package pojo_models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Images {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int imageId;
	
	private String image;

	@ManyToOne
	private Shopkeeper shop;
	
	public int getImageId() {
		return imageId;
	}

	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	

	public Images() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Shopkeeper getShop() {
		return shop;
	}

	public void setShop(Shopkeeper shop) {
		this.shop = shop;
	}

	public Images(int imageId, String image, Shopkeeper shop) {
		super();
		this.imageId = imageId;
		this.image = image;
		this.shop = shop;
	}






	}


