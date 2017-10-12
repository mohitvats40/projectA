package com.niit.Front.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Front.cartservice.CartService;

@Controller
@RequestMapping("/cart")
public class cartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name="result",required=false)String result){
		ModelAndView mv=new ModelAndView("page");
		if(result!=null){
			switch(result){
			case "updated":
				mv.addObject("message","Cartline is updated!");
				break;
			case "deleted":
				mv.addObject("message","Cartline is deleted!");
				break;
			case "added":
				mv.addObject("message","Cartline is added!");
				break;
			case "error":
				mv.addObject("message","Something wana wrong!");
				break;
			}
		}
		mv.addObject("title","User Cart");
		mv.addObject("SHOWCART",true);
		mv.addObject("cartline",cartService.getCartLine());
		return mv;
	}
	
	@RequestMapping("/{cartlineId}/update")
	public String updateCart(@PathVariable int cartlineId, @RequestParam int pCount){
		String response=cartService.updateCartline(cartlineId, pCount);
		return "redirect:/cart/show?"+response;
	}
	@RequestMapping("/{cartlineId}/delete")
	public String deleteCart(@PathVariable int cartlineId){
		String response=cartService.deleteCartline(cartlineId);
		return "redirect:/cart/show?"+response;
	}
	@RequestMapping("/add/{pId}/product")
	public String addCart(@PathVariable int pId){
		String response=cartService.addCartline(pId);
		return "redirect:/cart/show?"+response;
	}
	@RequestMapping("final")
	public ModelAndView fn() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "final");
		mv.addObject("FINAL", true);
		return mv;
	}

}
