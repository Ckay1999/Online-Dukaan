package pojo_models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Shopkeeper {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
private String bus_name;

@Column(unique=true)
private String email;
private String password;
private String phone;
private String open;
private String close;
private String type;
private String address;
private String lat;
private String lng;
private double dist;
private String image;

@OneToMany(mappedBy="shop",cascade=CascadeType.ALL)
private List<Images> images;

@OneToMany(mappedBy="shop",cascade=CascadeType.ALL)
private List<Review> reviews ;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBus_name() {
	return bus_name;
}
public void setBus_name(String bus_name) {
	this.bus_name = bus_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}

public String getOpen() {
	return open;
}
public void setOpen(String open) {
	this.open = open;
}

public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public List<Images> getImages() {
	return images;
}
public void setImages(List<Images> images) {
	this.images = images;
}
public String getClose() {
	return close;
}
public void setClose(String close) {
	this.close = close;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

public List<Review> getReviews() {
	return reviews;
}
public void setReviews(List<Review> reviews) {
	this.reviews = reviews;
}

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

public String getLat() {
	return lat;
}
public void setLat(String lat) {
	this.lat = lat;
}
public String getLng() {
	return lng;
}
public void setLng(String lng) {
	this.lng = lng;
}


public double getDist() {
	return dist;
}
public void setDist(double dist) {
	this.dist = dist;
}
public Shopkeeper() {
	super();
	// TODO Auto-generated constructor stub
}
public Shopkeeper(int id, String bus_name, String email, String password, String phone, String open, String close,
		String type, String address, String lat, String lng, double dist, List<Images> images, List<Review> reviews) {
	super();
	this.id = id;
	this.bus_name = bus_name;
	this.email = email;
	this.password = password;
	this.phone = phone;
	this.open = open;
	this.close = close;
	this.type = type;
	this.address = address;
	this.lat = lat;
	this.lng = lng;
	this.dist = dist;
	this.images = images;
	this.reviews = reviews;
}




}
