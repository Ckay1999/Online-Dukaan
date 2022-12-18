package spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo_models.Images;
import pojo_models.Shopkeeper;

@Repository
public class ImageDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveImage(Images img) {
		int id=(Integer)this.hibernateTemplate.save(img);
		return id;
	}
	
	//get all images
			public List<Images> getImages(){
				List<Images> img=this.hibernateTemplate.loadAll(Images.class);
				return img;
			}
			
			//delete an image
			@Transactional
			public void delete(int imgid) {
				Images p=this.hibernateTemplate.load(Images.class,imgid);
				this.hibernateTemplate.delete(p);
			}
			
			//get a single image
			public Images getImg(int aid) {
				return this.hibernateTemplate.get(Images.class, aid);
			}
}




