package com.niit.Front.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
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
	
	
	public String validateUser(User user,MessageContext error){
		String transitionValue="success";
		if(!(user.getPassword().equals(user.getConfirmPassword()))){
			error.addMessage(new MessageBuilder()
					.error().source("confirmPassword")
					.defaultText("Password does not match").build());
			transitionValue = "failure";
		}
		
		if(userdao.getByEmail(user.getEmail())!=null){
			error.addMessage(new MessageBuilder()
					.error().source("email")
					.defaultText("email is already used").build());
			transitionValue = "failure";
		}
		return transitionValue;
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
