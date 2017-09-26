package com.niit.Front.exc;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalEx {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","This page is not constructed!!!");
		mv.addObject("errorDescription","This page you are looking is not avilable!!!");
		mv.addObject("title","404 Error Page");
		return mv;
	}
	
	@ExceptionHandler(productNotFound.class)
	public ModelAndView handlerproductNotFound(){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Product not avilable");
		mv.addObject("errorDescription","This product you are looking is not avilable!!!");
		mv.addObject("title","Product Unavailable");
		return mv;
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle","Contact your administrator!!!");
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		ex.printStackTrace(pw);
		
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title","Error");
		return mv;
	}

}
