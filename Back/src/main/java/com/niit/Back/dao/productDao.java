package com.niit.Back.dao;

import java.util.List;

import com.niit.Back.dto.Product;

public interface productDao {
	
	Product get(int pId);
	List<Product> list();
	boolean add(Product product);
	boolean update(Product product);
	boolean delete(Product product);
	
	//buseness method
	List<Product> listActiveProduct();
	List<Product> listActiveProductByCategory(int category_id);
	List<Product> getLatestActiveProduct(int count);
}
