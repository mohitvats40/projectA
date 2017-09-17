package com.niit.Front.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("HOME", true);
		return mv;
	}

	@RequestMapping(value = { "about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("ABOUT", true);
		return mv;
	}

	@RequestMapping(value = { "contactus" })
	public ModelAndView contactus() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contactus");
		mv.addObject("CONTACT", true);
		return mv;
	}

	@RequestMapping(value = { "regester" })
	public ModelAndView regester() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Regester");
		mv.addObject("REGESTER", true);
		return mv;
	}

	@RequestMapping(value = { "login" })
	public ModelAndView login(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Login");
		mv.addObject("LOGIN", true);
		return mv;
	}
	@RequestMapping(value={"product"})
	public ModelAndView product(){
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","Products");
		mv.addObject("PRODUCT",true);
		return mv;
	}

}
