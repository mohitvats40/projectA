package com.niit.Front.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.niit.Back.dao.userDao;
import com.niit.Back.dto.User;
import com.niit.Front.Model.UserModel;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private userDao userdao;
	
	private UserModel usermodel=null;
	 
	@ModelAttribute("usermodel")
	public UserModel getUserModel(){
		if(session.getAttribute("usermodel")==null){
			Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		User user = userdao.getByEmail(authentication.getName());
		if(user!=null){
			
			usermodel=new UserModel();
			usermodel.setId(user.getuId());
			usermodel.setEmail(user.getEmail());
			usermodel.setRole(user.getRole());
			usermodel.setFullname(user.getFname()+" "+user.getLname());
			
			if(usermodel.getRole().equals("USER")){
				usermodel.setCart(user.getCart());
			}
			session.setAttribute("usermodel", usermodel);
			return usermodel;
		}
		}
		return (UserModel) session.getAttribute("usermodel");
	}
	
	
	

}
