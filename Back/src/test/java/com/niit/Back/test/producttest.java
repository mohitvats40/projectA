package com.niit.Back.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Back.dao.productDao;
import com.niit.Back.dto.Product;

public class producttest {
	private static AnnotationConfigApplicationContext context;
	private static productDao productdao;
	private Product product;
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Back");
		context.refresh();
		productdao = (productDao) context.getBean("productdao");
	}
	
	
	@Test 
	public void  testAddCategory(){ 
		
		product = new Product();
	product.setpName("s3"); 
	product.setpBrand("oppo"); 
	product.setpDesc("mobile"); 
	product.setpPrice(160.00);
	product.setpQat(0);
	product.setIs_active(true); 
	product.setCategory_id(3); 
	product.setSupplier_id(2); 
	assertEquals("secess for add",true,productdao.add(product));
		
	
	
    /*	product=productdao.get(1);
    	product.setpName("ASDFG");
    	assertEquals("secess for update",true,productdao.update(product));
    	assertEquals("secess for delet",true,productdao.delete(product));
    	assertEquals("secess for size",5,productdao.list().size());*/
	}
    
	/*@Test
	public void testListActiveProducts(){
		assertEquals("secess",4,productdao.listActiveProduct().size());
		
		
	}*/
	
/*	@Test
	public void testListActiveProductsByCategory(){
		assertEquals("secess",2,productdao.listActiveProductByCategory(1).size());
		assertEquals("secess",2,productdao.listActiveProductByCategory(3).size());
		
	}*/
	
	/*@Test
	public void testLatestActiveProducts(){
		assertEquals("secess",2,productdao.getLatestActiveProduct(2).size());
		
	}*/
}










