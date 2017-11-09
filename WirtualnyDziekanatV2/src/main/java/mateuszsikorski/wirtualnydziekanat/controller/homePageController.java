package mateuszsikorski.wirtualnydziekanat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mateuszsikorski.wirtualnydziekanat.entity.User;
import mateuszsikorski.wirtualnydziekanat.service.UserService;

@Controller
@RequestMapping("/")
public class homePageController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/author")
	public String homePage() { 
		return "author";
	}
	/*
	@GetMapping("/createuser")
	public String createUser(Model m){
		
		User theUser = new User();
		m.addAttribute("user", theUser);
		
		return "add-user-form";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User theUser){
		
		userService.saveUser(theUser);
		
		return "redirect:/";
	}*/
	
}
