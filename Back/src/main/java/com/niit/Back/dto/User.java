package com.niit.Back.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uId;
	
	@NotBlank(message="Please Enter Your First Name !")
	@Pattern(regexp="[a-zA-Z]+", message="Your name should be in characters.")
	private String fname;
	@NotBlank(message="Please Enter Your Last Name!")
	@Pattern(regexp="[a-zA-Z]+", message="Your name should be in characters.")
	private String lname;
	@NotBlank(message="Please Enter Your Email Address!")
	@Pattern(regexp=".+@.+\\..+", message="Wrong email!")
	private String email;
	@NotBlank(message="Please Enter Your Contact Number!")
	@Size(min=10 ,max=10, message="contect no should be 10 digits!")
	@Pattern(regexp="(^$|[0-9]{10})", message="Your contact no should be in numbers.")
	private String contectno;
	
	private String role;
	@NotBlank(message="Please Enter Password!")
	@Size(min = 6, max = 12,message="Password should be more then 6 cheractors!")
	private String password;
	private boolean enabled = true;
	@Transient
	private  String confirmPassword;
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Cart cart;
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContectno() {
		return contectno;
	}
	public void setContectno(String contectno) {
		this.contectno = contectno;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	

}
