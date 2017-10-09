package com.niit.Back.dao;

import java.util.List;

import com.niit.Back.dto.Cart;
import com.niit.Back.dto.cartLine;

public interface cartlineDao {
	
	public cartLine get(int id);
	
	public boolean add(cartLine cartline);
	
	public boolean update(cartLine cartline);
	
	public boolean delete(cartLine cartline);
	
	public List<cartLine> list(int crId);
	
	public List<cartLine> listAvailable(int crId);
	
	public cartLine getByCartAndProduct(int crId,int pId);
	
	boolean updateCart(Cart cart);
	

}
