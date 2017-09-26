package com.niit.Front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Back.dao.categoryDao;
import com.niit.Back.dto.Category;
import com.niit.Back.dto.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private categoryDao categorydao;
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
    public ModelAndView showAdminProduct(){
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("ADMIN",true);
		mv.addObject("title","admin product");
		Product aproduct=new Product();
		aproduct.setSupplier_id(1);
		aproduct.setIs_active(true);
		mv.addObject("product",aproduct);
		
		return mv;
	}
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categorydao.list();
	}
}
