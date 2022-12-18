package spring.search;

import java.util.List;

import pojo_models.Shopkeeper;

public interface IBusinessSearch {
	public List<Shopkeeper> findShops(List<Shopkeeper> shops);
}
