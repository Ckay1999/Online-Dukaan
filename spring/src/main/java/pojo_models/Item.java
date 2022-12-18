package pojo_models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private int bus_id;
	private String sub_cat;
	private String name;
	private String price;
	private String image;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBus_id() {
		return bus_id;
	}
	public void setBus_id(int bus_id) {
		this.bus_id = bus_id;
	}
	public String getSub_cat() {
		return sub_cat;
	}
	public void setSub_cat(String sub_cat) {
		this.sub_cat = sub_cat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Item(int id, int bus_id, String sub_cat, String name, String price, String image) {
		super();
		this.id = id;
		this.bus_id = bus_id;
		this.sub_cat = sub_cat;
		this.name = name;
		this.price = price;
		this.image = image;

	}
	public Item(int bus_id, String sub_cat, String name, String price, String image) {
		super();
		this.bus_id = bus_id;
		this.sub_cat = sub_cat;
		this.name = name;
		this.price = price;
		this.image = image;
	}
	
	
	
	
}
