package com.niit.Back.dto;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pId;
	private String pCode;
	
	@NotBlank(message = "Please enter the product Name!")
	private String pName;
	@NotBlank(message = "Please enter the product Brand!")
	private String pBrand;
	
	@JsonIgnore
	@NotBlank(message = "Please enter the product Description!")
	private String pDesc;
	//@Pattern(regexp="(^$|[0-9])", message="Your name should be in nuberrs.")
	private double pPrice;
	
	//@Pattern(regexp="(^$|[0-9])", message="Your name should be in nuberrs.")
	private int pQat;
	
	
	private boolean is_active;
	
	@JsonIgnore
	private int category_id;
	
	@JsonIgnore
	private int supplier_id;
	
	private int Purchase;
	private int Views;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Transient
	private MultipartFile file;
	
	
	public Product(){
		
		this.pCode="PRD"+UUID.randomUUID().toString().substring(26).toUpperCase();
	}
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	public double getpPrice() {
		return pPrice;
	}
	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}
	public int getpQat() {
		return pQat;
	}
	public void setpQat(int pQat) {
		this.pQat = pQat;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public int getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}

	public int getPurchase() {
		return Purchase;
	}
	public void setPurchase(int purchase) {
		Purchase = purchase;
	}
	public int getViews() {
		return Views;
	}
	public void setViews(int views) {
		Views = views;
	}
	
	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pCode=" + pCode + ", pName=" + pName + ", pBrand=" + pBrand + ", pDesc="
				+ pDesc + ", pPrice=" + pPrice + ", pQat=" + pQat + ", is_active=" + is_active + ", category_id="
				+ category_id + ", supplier_id=" + supplier_id + ", Purchase=" + Purchase + ", Views=" + Views + "]";
	}

}
