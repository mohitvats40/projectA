package com.niit.Back.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int crId;
	@OneToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private double total;
	private int cartLine;
	public int getCrId() {
		return crId;
	}
	public void setCrId(int crId) {
		this.crId = crId;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getCartLine() {
		return cartLine;
	}
	public void setCartLine(int cartLine) {
		this.cartLine = cartLine;
	}
	@Override
	public String toString() {
		return "Cart [crId=" + crId + ", user=" + user + ", total=" + total + ", cartLine=" + cartLine + "]";
	}
	
	
	
	

}
