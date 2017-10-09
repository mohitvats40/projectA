package com.niit.Back.dao;

import java.util.List;

import com.niit.Back.dto.Address;
import com.niit.Back.dto.Cart;
import com.niit.Back.dto.User;

public interface userDao {
	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listShippingAddress(User user);
	
	
	

}
