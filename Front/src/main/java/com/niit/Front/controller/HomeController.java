package com.niit.Front.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Back.dao.categoryDao;
import com.niit.Back.dao.productDao;
import com.niit.Back.dto.Category;
import com.niit.Back.dto.Product;
import com.niit.Front.exc.productNotFound;



@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private categoryDao categorydao;
	
	@Autowired
	private productDao productdao;
	
	
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		logger.info("Inside Home controller index method - info");
		logger.debug("Inside Home controller index method - DEBUG");
		mv.addObject("categories",categorydao.list());
		mv.addObject("HOME", true);
		return mv;
	}

	@RequestMapping(value = { "about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("ABOUT", true);
		return mv;
	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories",categorydao.list());
		mv.addObject("ALLPRODUCTS", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{cId}/products")
	public ModelAndView showCategoryProducts(@PathVariable("cId")int cId) {
		ModelAndView mv = new ModelAndView("page");
		Category category=null;
	    category = categorydao.get(cId);
		mv.addObject("title", category.getcName());
		mv.addObject("categories",categorydao.list());
		mv.addObject("category",category);
		mv.addObject("CATEGORYPRODUCTS", true);
		return mv;
	}
	
	@RequestMapping(value = { "contactus" })
	public ModelAndView contactus() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contactus");
		mv.addObject("CONTACT", true);
		return mv;
	}

	

	@RequestMapping(value = { "login" })
	public ModelAndView login(@RequestParam(name="error",required=false)String error,
			@RequestParam(name="logout",required=false)String logout){
		ModelAndView mv = new ModelAndView("login");
		if(error!=null){
			mv.addObject("message","Invalid Username and Password");
		}
		if(logout!=null){
			mv.addObject("logout","User hass succesfully logged out!");
		}
		mv.addObject("title", "Login");
		return mv;
	}
			
	@RequestMapping(value={"product"})
	public ModelAndView product(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Products");
		mv.addObject("PRODUCT",true);
		return mv;
	}
	
	//view single product
	@RequestMapping(value="/show/{pId}/product")
	public ModelAndView showSingleProduct(@PathVariable int pId) throws productNotFound {
		ModelAndView mv=new ModelAndView("page");
		Product product=productdao.get(pId);
		
		if(product==null) throw new productNotFound();
		
		product.setViews(product.getViews()+1);
		//update the view
		productdao.update(product);
		
		//add
		mv.addObject("title",product.getpName());
		mv.addObject("product",product);
		mv.addObject("SHOWPRODUCT",true);
		return mv;
	}
	
	
	@RequestMapping(value = { "register" })
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contactus");
		return mv;
	}

	@RequestMapping(value = { "/access-denied" })
	public ModelAndView accesDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 -Access Denied");
		mv.addObject("errorTitle", "Aha! Caught You.");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		return mv;
	}
	
	@RequestMapping(value="/perform-logout")
	public String logout(HttpServletRequest request,HttpServletResponse response){
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		if(auth!=null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}
	
	
	


}





