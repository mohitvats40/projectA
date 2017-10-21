package com.niit.Back.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Back.dao.cartlineDao;
import com.niit.Back.dao.productDao;
import com.niit.Back.dao.userDao;
import com.niit.Back.dto.Cart;
import com.niit.Back.dto.Product;
import com.niit.Back.dto.User;
import com.niit.Back.dto.cartLine;

public class cartTest {
	
	private static AnnotationConfigApplicationContext context;
	private static cartlineDao cartlinedao;
	private static productDao productdao;
	private static userDao userdao;
	
	
	
	private Product product=null;
	private User user=null;
	private Cart cart=null;
	private cartLine cartline=null;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.Back");
		context.refresh();
		productdao = (productDao) context.getBean("productdao");
		userdao = (userDao) context.getBean("userdao");
		cartlinedao = (cartlineDao) context.getBean("cartlinedao");
	}
	
	/*@Test
	public void testaddcartline(){
		user = userdao.getByEmail("aman@gmail.com");
		
		cart = user.getCart();
		
		product=productdao.get(1);
		
		cartline = new cartLine();
		cartline.setBuying_price(product.getpPrice());
		cartline.setpCount(cartline.getpCount()+1);
		cartline.setTotal(cartline.getpCount()*product.getpPrice());
		cartline.setIs_available(true);
		cartline.setCrId(cart.getCrId());
		cartline.setProduct(product);
		
		assertEquals("failed for add",true,cartlinedao.add(cartline));
	   cart.setTotal(cart.getTotal()+cartline.getTotal());
	   cart.setCartLine(cart.getCartLine()+1);
	   assertEquals("failed for add",true,cartlinedao.updateCart(cart));
	
	}*/
	
	@Test
	public void testUpdateCartLine() {

		// fetch the user and then cart of that user
		User user = userdao.getByEmail("aman@gmail.com");		
		Cart cart = user.getCart();
				
		cartline = cartlinedao.getByCartAndProduct(cart.getCrId(), 2);
		
		cartline.setpCount(cartline.getpCount() + 1);
				
		double oldTotal = cartline.getTotal();
				
		cartline.setTotal(cartline.getProduct().getpPrice() * cartline.getpCount());
		
		cart.setTotal(cart.getTotal() + (cartline.getTotal() - oldTotal));
		
		assertEquals("Failed to update the CartLine!",true, cartlinedao.update(cartline));	

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
