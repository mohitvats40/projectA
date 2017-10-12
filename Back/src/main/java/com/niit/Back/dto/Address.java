package com.niit.Back.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aId;
	
	@ManyToOne
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@NotBlank(message="Please Enter Your Address one!")
	private String addressLine1;
	@NotBlank(message="Please Enter Your Address Two!")
	private String addessLine2;
	@NotBlank(message="Please Enter Your City Name!")
	@Pattern(regexp="a-z||A-Z", message="Your name should be in characters.")
	private String city;
	@NotBlank(message="Please Enter Your State Name!")
	@Pattern(regexp="a-z||A-Z", message="Your name should be in characters.")
	private String state;
	@NotBlank(message="Please Enter Your Countery Name!")
	private String countery;
	@NotBlank(message="Please Enter Your PostalCode!")
	@Pattern(regexp="0-9", message="Your name should be in number.")
	@Size(min = 6, max = 6,message="Password should be in cheractors!")
	private String postalCode;
	private boolean shipping;
	private boolean billing;
	
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddessLine2() {
		return addessLine2;
	}
	public void setAddessLine2(String addessLine2) {
		this.addessLine2 = addessLine2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountery() {
		return countery;
	}
	public void setCountery(String countery) {
		this.countery = countery;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	@Override
	public String toString() {
		return "Address [aId=" + aId + ", addressLine1=" + addressLine1 + ", addessLine2=" + addessLine2 + ", city="
				+ city + ", state=" + state + ", countery=" + countery + ", postalCode=" + postalCode + ", shipping="
				+ shipping + ", billing=" + billing + "]";
	}
	
	
	

}
