package org.mateuszsikorski.wirtualnydziekanat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.mateuszsikorski.wirtualnydziekanat.service.LoginService;
import org.mateuszsikorski.wirtualnydziekanat.service.LoginServiceImpl;
import org.mateuszsikorski.wirtualnydziekanat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginDetail;
	
	@ModelAttribute("user")
	public User getUser(){
		return new User();
	}

	// Logowanie
	@GetMapping("/login")
	public ModelAndView loginPage(@ModelAttribute("user") User user){
		
		ModelAndView mav = new ModelAndView();
		loginDetail = new LoginServiceImpl();

		if(!(user.getUserName() == "Niezarejestrowany")) {
			String msg = "Uzytkownik jest juz zalogowany";
			mav.addObject("msg", msg);
			mav.setViewName("/actionfailed");
			return mav;
		}
		
		String msg = "";
		
		mav.addObject("loginDetail", loginDetail);
		mav.addObject("msg", msg);
		mav.setViewName("/login/login-form");
		
		return mav;
	}
	
	// Autoryzacja logowania
	@PostMapping("/loginproceed")
	public ModelAndView loginValidation(@ModelAttribute("user") User user,
										@ModelAttribute("loginDetail") LoginServiceImpl loginDetail){
		
		ModelAndView mav = new ModelAndView();
		
		if(loginDetail.validate()){
			user = loginDetail.getUser();
			mav.addObject("user", user);
			mav.setViewName("/login-form-succes");
		} else {
			String msg = "Niepoprawna nazwa uzytkownika lub haslo";
			mav.addObject("msg", msg);
			mav.setViewName("/login/login-form");
			return mav;
		}
		return mav;
	}
	
	// Rejestracja uzytkownika
	@GetMapping("/create")
	public ModelAndView createUser(@ModelAttribute("user") User user) {
		
		ModelAndView mav = new ModelAndView();
		
		String msg;
		
		if(!(user.getUserName() == "Niezarejestrowany")) {
			msg = "Uzytkownik jest juz zarejestrowany";
			mav.addObject("msg", msg);
			mav.setViewName("/actionfailed");
			System.out.println("\n-----\n/user/create Recived request from registered user: " + user);
		} else {
			user = new User();
			mav.setViewName("/user/add-user-form");
			System.out.println("\n-----\n/user/create Creating new user in memory: " + user);
		}
		
		mav.addObject("user", user);
		
		return mav;
	}
	
	// Rejestracja uzytkownika
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") @Valid User user,
			BindingResult bR){
		
		if(bR.hasErrors()) {
			System.out.println("\n-----\n/user/save Incorrect data recieved");
			return "/user/add-user-form";
		} else {		
		System.out.println("\n-----\n/user/save/ Saving the user in db: " + user);
		userService.saveUserDetail(user.getUserDetail());
		userService.saveUser(user);
		}
		
		return "user/user-detail-form";
	}
	
	// Szczegoly profilu uzytkownika
	@GetMapping("/detail")
	public String showDetail(@ModelAttribute("user") User user){
		
		System.out.println("\n-----\n/user/detail User + " + user);
		
		return "user/user-detail-form";
	}
	
	// Szczegoly profilu uzytkownika
	@PostMapping("/saveDetail")
	public String saveUserDetail(@ModelAttribute("user") User user){
	
		System.out.println("\n-----\n/user/saveDetail saving the user: " + user);
		
		userService.saveUserDetail(user.getUserDetail());
	
		return "user/user-detail-form";
	}
	
	
	
}
