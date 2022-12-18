package spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import pojo_models.Admin;

@Repository
public class AdminDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	//get all shopkeepers
	public List<Admin> Admin_info(){
		List<Admin> add=this.hibernateTemplate.loadAll(Admin.class);
		return add;
			}
}
