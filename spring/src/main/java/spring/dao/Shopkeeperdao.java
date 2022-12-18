package spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pojo_models.Shopkeeper;

@Repository
public class Shopkeeperdao {
	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveShopkeeper(Shopkeeper user) {
		int id=(Integer)this.hibernateTemplate.save(user);
		return id;
	
	}
	
	//get all shopkeepers
		public List<Shopkeeper> getShopkeeper(){
			List<Shopkeeper> add=this.hibernateTemplate.loadAll(Shopkeeper.class);
			return add;
		}
		
		//delete a shopkeeper's business
		@Transactional
		public void delete(int aid) {
			Shopkeeper p=this.hibernateTemplate.load(Shopkeeper.class,aid);
			this.hibernateTemplate.delete(p);
		}
		
		//get a single business
		public Shopkeeper getBusiness(int aid) {
			return this.hibernateTemplate.get(Shopkeeper.class, aid);
		}
		
		@Transactional
		public void updateBusiness(Shopkeeper s) {
			this.hibernateTemplate.saveOrUpdate(s);
		}
}
