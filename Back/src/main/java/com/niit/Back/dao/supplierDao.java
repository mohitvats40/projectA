package com.niit.Back.dao;

import java.util.List;

import com.niit.Back.dto.Supplier;

public interface supplierDao {
	Supplier get(int sId);
	List<Supplier> list();
	boolean add(Supplier supplier);
	boolean update(Supplier supplier);
	boolean delete(Supplier supplier);

}
