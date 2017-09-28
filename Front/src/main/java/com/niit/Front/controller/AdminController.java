package com.niit.Front.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Back.dao.categoryDao;
import com.niit.Back.dao.productDao;
import com.niit.Back.dto.Category;
import com.niit.Back.dto.Product;
import com.niit.Front.util.fileUplode;
import com.niit.Front.valid.validetor;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private categoryDao categorydao;
	
	@Autowired
	private productDao productdao;
	
	private static final Logger logger=LoggerFactory.getLogger(AdminController.class);
	
	@RequestMapping(value="/product",method=RequestMethod.GET)
    public ModelAndView showAdminProduct(@RequestParam(name="operation",required=false)String operation){
		
		
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("ADMIN",true);
		mv.addObject("title","admin product");
		Product aproduct=new Product();
		aproduct.setSupplier_id(1);
		aproduct.setIs_active(true);
		mv.addObject("product",aproduct);
		if(operation!=null){
			if(operation.equals("product")){
				mv.addObject("message","product submit successfully");
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/product",method=RequestMethod.POST)
	public String handleProductAdding(@Valid @ModelAttribute("product") Product mproduct,BindingResult results,
			Model model,HttpServletRequest request){
		new validetor().validate(mproduct,results);
		
		if(results.hasErrors()){
			model.addAttribute("ADMIN",true);
			model.addAttribute("title","admin product");
			model.addAttribute("message","product submittion fail!!");
			return "page";
		}
		
		logger.info(mproduct.toString());
		productdao.add(mproduct);
		if(!mproduct.getFile().getOriginalFilename().equals("")){
			fileUplode.uploadFile(request, mproduct.getFile(), mproduct.getpCode());
		}
		return "redirect:/admin/product?operation=product";
	}
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categorydao.list();
	}
}
