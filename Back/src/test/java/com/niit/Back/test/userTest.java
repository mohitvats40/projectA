package com.niit.Back.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Back.dao.userDao;
import com.niit.Back.dto.Address;
import com.niit.Back.dto.Cart;
import com.niit.Back.dto.User;

public class userTest {

	private static AnnotationConfigApplicationContext context;
	private static userDao userdao;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Back");
		context.refresh();
		userdao = (userDao) context.getBean("userdao");
	}
	
	  @Test public void testAdd(){
	   user=new User(); user.setFname("Mohit");
	  user.setLname("vats"); user.setEmail("mohitvats40@gmail.com");
	  user.setContectno("7042287356"); user.setRole("ADMIN");
	  user.setPassword("mohit");
	  
	  assertEquals("failed to add user",true,userdao.addUser(user));
	  
	  /*
	  address = new Address(); address.setAddressLine1("add1");
	  address.setAddessLine2("add2"); address.setCity("city");
	 address.setState("state"); address.setCountery("countery");
	  address.setPostalCode("110044"); address.setBilling(true);
	  
	  // link user to address address.setUserId(user.getuId());
	  
	  assertEquals("failed to add address",true,userdao.addAddress(address));
	  
	  if(user.getRole().equals("USER")){
	  
	  cart = new Cart(); cart.setUser(user);
	  
	  assertEquals("failed to add cart",true,userdao.addCart(cart));
	  
	  address = new Address(); address.setAddressLine1("add1");
	  address.setAddessLine2("add2"); address.setCity("city");
	  address.setState("state"); address.setCountery("countery");
	  address.setPostalCode("110044"); address.setShipping(true);
	
	 * //link with user
	 * 
	 * address.setUserId(user.getuId());
	 * 
	 * assertEquals("failed to add address",true,userdao.addAddress(address));
	 * 
	 * }
	 * 
	 * 
	 * }
	 */

	/*@Test
	public void testAdd() {
		user = new User();
		user.setFname("Mohit");
		user.setLname("vats");
		user.setEmail("mohitvats40@gmail.com");
		user.setContectno("7042287356");
		user.setRole("USER");
		user.setPassword("1234567");

		if (user.getRole().equals("USER")) {

			cart = new Cart();
			cart.setUser(user);
			//attach cart
			user.setCart(cart);
		}
		assertEquals("failed to add user", true, userdao.addUser(user));

	}*/

	/*@Test
	public void testupdateCart() {
		user = userdao.getByEmail("mohitvats40@gmail.com");
		
		cart = user.getCart();
		
		cart.setTotal(5256);
		
		cart.setCartLine(5);
		
		
		
		assertEquals("failed to add user", true, userdao.updateCart(cart));

	}*/
	
	/*@Test
	public void testAddress(){
		
		 user=new User(); user.setFname("Mohit");
		  user.setLname("vats"); user.setEmail("mohitvats40@gmail.com");
		  user.setContectno("7042287356"); user.setRole("USER");
		  user.setPassword("1234567");
		  
		  assertEquals("failed to add user",true,userdao.addUser(user));
		  
		  
		  address = new Address(); address.setAddressLine1("add1");
		  address.setAddessLine2("add2"); address.setCity("city");
		 address.setState("state"); address.setCountery("countery");
		  address.setPostalCode("110044"); address.setBilling(true);
		  
		address.setUser(user);
		assertEquals("failed to add user",true,userdao.addAddress(address));
		
		  
		  address = new Address(); address.setAddressLine1("add1");
		  address.setAddessLine2("add2"); address.setCity("city");
		  address.setState("state"); address.setCountery("countery");
		  address.setPostalCode("110044"); address.setShipping(true);
		
		  address.setUser(user);
			assertEquals("failed to add user",true,userdao.addAddress(address));
			
		
	}*/
	
	
	/*@Test
	public void testadd(){
		
		user = userdao.getByEmail("mohitvats40@gmail.com");
		
		 address = new Address(); address.setAddressLine1("klsdfnl,add1");
		  address.setAddessLine2("lkn,add2"); address.setCity("city");
		  address.setState("state"); address.setCountery("countery");
		  address.setPostalCode("110044"); address.setShipping(true);
		
		  address.setUser(user);
			assertEquals("failed to add user",true,userdao.addAddress(address));
			
		
		
	}*/
	
	/*@Test
	public void testgetAddress(){
		
		user = userdao.getByEmail("mohitvats40@gmail.com");
		
		assertEquals("failed to add user",2,userdao.listShippingAddress(user).size());
		
		assertEquals("failed to add user","city",userdao.getBillingAddress(user).getCity());
		
		
	}*/
	
	
	
	
	
	
	
	
	  }
	
	
	
	
	

	
}
