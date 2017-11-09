package mateuszsikorski.wirtualnydziekanat.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import mateuszsikorski.wirtualnydziekanat.entity.User;
import mateuszsikorski.wirtualnydziekanat.entity.UserDetail;
import mateuszsikorski.wirtualnydziekanat.service.UserService;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private User user;

	
	@GetMapping("/login")
	public ModelAndView loginPage(){
		
		Map<String, String> loginDetail;
		
		return null;
	}
	
	// Rejestracja uzytkownika
	@GetMapping("/create")
	public ModelAndView createUser() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/add-user-form");
		
		user = new User();
		mav.addObject("user", user);
		System.out.println("/user/create Creating new user: " + user);
		
		
		return mav;
	}
	
	// Rejestracja uzytkownika
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") User user, HttpServletRequest request){
		
		System.out.println("/user/save/ Saving the user: " + user);
		//userService.saveUser(user);
		//m.addAttribute("user", user);
		
		return "user/user-detail-form";
	}
	
	// Szczegoly profilu uzytkownika
	@GetMapping("/detail")
	public String showDetail(@ModelAttribute("user") User user, HttpServletRequest request){
		
		//m.addAttribute("user", theUser);
		
		System.out.println("/user/detail User + " + user);
		
		return "user/user-detail-form";
	}
	
	// Szczegoly profilu uzytkownika
	@PostMapping("/saveDetail")
	public String saveUserDetail(@ModelAttribute("user") User user, HttpServletRequest request){
	
		System.out.println("/user/saveDetail saving the user: " + user);
		
		//userService.saveUser(user);
		//m.addAttribute("user", theUser);
		
		return "user/user-detail-form";
	}
	
	
}
