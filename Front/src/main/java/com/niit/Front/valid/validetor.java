package com.niit.Front.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.niit.Back.dto.Product;

public class validetor implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product=(Product) target;
		
		if(product.getFile()==null||product.getFile().getOriginalFilename().equals("")){
			errors.rejectValue("file",null,"Please select a image!!");
			return;
		}
     if(! (
    		 product.getFile().getContentType().equals("image/jpeg")||
    		 product.getFile().getContentType().equals("image/png")||
    		 product.getFile().getContentType().equals("image/gif")
    		 )){
    	 errors.rejectValue("file", null,"please use image file only!!");
    	 return;
     }
	}

}
