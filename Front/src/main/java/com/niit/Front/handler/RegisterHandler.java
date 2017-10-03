package com.niit.Front.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.niit.Back.dao.userDao;
import com.niit.Back.dto.Address;
import com.niit.Back.dto.Cart;
import com.niit.Back.dto.User;
import com.niit.Front.Model.RegisterModel;

@Component
public class RegisterHandler {
	
	@Autowired
	private userDao userdao;
	
	public RegisterModel init(){
		return new RegisterModel();
	}
	public void addUser(RegisterModel registerModel, User user){
		registerModel.setUser(user);
	}
	public void addBilling(RegisterModel registerModel, Address billing){
		registerModel.setBilling(billing);;
	}
	public String saveAll(RegisterModel model){
		String transitionValue="success"; 
		
		User user = model.getUser();
		if(user.getRole().equals("USER")){
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		userdao.addUser(user);
		
		Address billing=model.getBilling();
		billing.setUser(user);
		billing.setBilling(true);
		userdao.addAddress(billing);
		return transitionValue;
	}
}
