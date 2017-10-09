package com.niit.Front.cartservice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.Back.dao.cartlineDao;
import com.niit.Back.dto.Cart;
import com.niit.Back.dto.Product;
import com.niit.Back.dto.cartLine;
import com.niit.Front.Model.UserModel;

@Service("cartService")
public class CartService {

	@Autowired
	private cartlineDao cartlinedao;

	@Autowired
	private HttpSession session;

	private Cart getCart() {
		return ((UserModel) session.getAttribute("usermodel")).getCart();
	}

	public List<cartLine> getCartLine() {
		return cartlinedao.list(this.getCart().getCrId());
	}

	public String updateCartline(int cartlineId, int pCount) {

		cartLine cartline = cartlinedao.get(cartlineId);

		if (cartline == null) {
			return "result=error";
		} else {
			Product product = cartline.getProduct();

			double oldTotal = cartline.getTotal();

			if (product.getpQat() <= pCount) {
				pCount = product.getpQat();
			}

			cartline.setpCount(pCount);
			cartline.setBuying_price(product.getpPrice());
			cartline.setTotal(product.getpPrice() * pCount);
			cartlinedao.update(cartline);
			Cart cart = this.getCart();
			cart.setTotal(cart.getTotal() - oldTotal + cartline.getTotal());
			cartlinedao.updateCart(cart);
			return "result=updated";
		}

	}

	public String deleteCartline(int cartlineId) {
		cartLine cartline = cartlinedao.get(cartlineId);
		if(cartline==null){
			return "result=error";
		}
		else{
			Cart cart = this.getCart();
			cart.setTotal(cart.getTotal()-cartline.getTotal());
			cart.setCartLine(cart.getCartLine()-1);
			cartlinedao.updateCart(cart);
			cartlinedao.delete(cartline);
			return "result=deleted";
			
			
		}
	}

}
