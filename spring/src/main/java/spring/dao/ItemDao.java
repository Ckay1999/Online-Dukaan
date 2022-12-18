package spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pojo_models.Item;

@Repository
public class ItemDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	public int saveItem(Item item) {
		int id=(Integer)this.hibernateTemplate.save(item);
		return id;
	
	}
	
	//get all items
		public List<Item> getItems(){
			List<Item> add=this.hibernateTemplate.loadAll(Item.class);
			return add;
		}
		
		//delete an item
		@Transactional
		public void delete(int aid) {
			Item p=this.hibernateTemplate.load(Item.class,aid);
			this.hibernateTemplate.delete(p);
		}
		
		//get a single item
		public Item getBusiness(int aid) {
			return this.hibernateTemplate.get(Item.class, aid);
		}
		
}
