package org.mateuszsikorski.wirtualnydziekanat.controller;

import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@SessionAttributes("user")
public class HomePageController {
	
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}
	
	@RequestMapping("/author")
	public String authorPage() { 
		return "author";
	}
	
	@GetMapping("/")
	public ModelAndView homePage(@ModelAttribute("user") User user) {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		mav.addObject("user", user);
		
		return mav;
	}
	
	public static ModelAndView actionFailed(String msg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", msg);
		mav.setViewName("/actionfailed");
		return mav;
	}
	
}
