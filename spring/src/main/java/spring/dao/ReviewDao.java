package spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo_models.Review;

@Repository
public class ReviewDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveReview(Review r){
		int id=(Integer)this.hibernateTemplate.save(r);
		return id;
	}
	
	//get all images
			public List<Review> getReviews(){
				List<Review> reviews=this.hibernateTemplate.loadAll(Review.class);
				return reviews;
			}
			
			//delete an image
			@Transactional
			public void delete(int imgid) {
				Review p=this.hibernateTemplate.load(Review.class,imgid);
				this.hibernateTemplate.delete(p);
			}
			
			//get a single image
			public Review getR(int aid) {
				return this.hibernateTemplate.get(Review.class, aid);
			}
}
