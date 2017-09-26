package com.niit.Back.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Back.dao.categoryDao;
import com.niit.Back.dto.Category;

public class categorytest {

	private static AnnotationConfigApplicationContext context;
	private static categoryDao categorydao;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Back");
		context.refresh();
		categorydao = (categoryDao) context.getBean("categorydao");
	}
	/*
	 * @Test public void testAddCategory(){ category = new Category();
	 * 
	 * category.setcName("tv"); category.setcDesc("a television");
	 * category.setImageURL("ab.png");
	 * assertEquals("secess",true,categorydao.add(category)); }
	 * 
	 * @Test public void testcategory(){
	 * 
	 * category=categorydao.get(1);
	 * assertEquals("secess","tv",category.getcName()); }
	 * 
	 * @Test public void testupdatecategory(){
	 * 
	 * category=categorydao.get(1); category.setcName("TV");
	 * assertEquals("secess",true,categorydao.update(category)); }
	 * 
	 * 
	 * @Test public void testupdatecategory(){
	 * 
	 * category=categorydao.get(1); category.setcName("TV");
	 * assertEquals("secess",true,categorydao.delete(category)); }
	 * 
	 * @Test public void testallcategory(){
	 * 
	 * category=categorydao.get(1); category.setcName("TV");
	 * assertEquals("secess",0,categorydao.list().size()); }
	 */
   @Test
	public void testcategory() {
		category = new Category();
		category.setcName("tv");
		category.setcDesc("a television");
		category.setImageURL("ab.png");
		assertEquals("secess", true, categorydao.add(category));
		
		
		category = new Category();
		category.setcName("laptop");
		category.setcDesc("a television");
		category.setImageURL("ab1.png");
		assertEquals("secess", true, categorydao.add(category));
		

		category = new Category();
		category.setcName("freez");
		category.setcDesc("a television");
		category.setImageURL("ab1.png");
		assertEquals("secess", true, categorydao.add(category));

		category = categorydao.get(1);
		category.setcName("TV");
		assertEquals("secess", true, categorydao.update(category));

		
		assertEquals("secess", true, categorydao.delete(category));

	
		assertEquals("secess", 1, categorydao.list().size());

	}

}
