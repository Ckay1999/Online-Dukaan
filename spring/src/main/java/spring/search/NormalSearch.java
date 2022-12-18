package spring.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import pojo_models.Shopkeeper;
import spring.dao.Shopkeeperdao;

public class NormalSearch implements IBusinessSearch{
	
	public List<Shopkeeper> findShops(List<Shopkeeper> shops){
		return shops;
	}
}
