package com.niit.Front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niit.Back.dao.productDao;
import com.niit.Back.dto.Product;

@Controller
@RequestMapping("/json/data")
public class jasondatacont {
	
	@Autowired
	private productDao productdao;
	
	@RequestMapping("/all/product")
	@ResponseBody
	public List<Product> getAllProduct(){
		return productdao.listActiveProduct();
	}
	
	@RequestMapping("/category/{cId}/product")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable int cId){
		return productdao.listActiveProductByCategory(cId);
	}
	

}
