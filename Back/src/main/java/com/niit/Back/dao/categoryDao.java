package com.niit.Back.dao;

import java.util.List;

import com.niit.Back.dto.Category;

public interface categoryDao {
	
	
	Category get(int cId);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);

}
