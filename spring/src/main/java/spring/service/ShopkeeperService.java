package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pojo_models.Shopkeeper;
import spring.dao.Shopkeeperdao;

@Service
public class ShopkeeperService {
	@Autowired
	private Shopkeeperdao shopkeeperDao;	
	public int createShopkeeper(Shopkeeper user) {
	return this.shopkeeperDao.saveShopkeeper(user);
}
	
	public Shopkeeper getBusiness(int id) {
		return this.shopkeeperDao.getBusiness(id);
	}
	
}
