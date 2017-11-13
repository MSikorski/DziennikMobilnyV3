package mateuszsikorski.wirtualnydziekanat.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

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
	public ModelAndView loginPage(@ModelAttribute("user") User user){
		
		ModelAndView mav = new ModelAndView();
		Map<String, String> loginDetail = new Map<>();
		
		loginDetail.put("userName", "");
		loginDetail.put("password", "");
		
		if(user.isRegistered()) {
			String msg = "Uzytkownik jest juz zalogowany";
			mav.addObject("msg", msg);
			mav.setViewName("/actionfailed");
		}
		mav.addObject("loginDetail", loginDetail);
		
		
		return null;
	}
	
	// Rejestracja uzytkownika
	@GetMapping("/create")
	public ModelAndView createUser(@ModelAttribute("user") User user) {
		
		ModelAndView mav = new ModelAndView();
		
		String msg;
		
		if(user.isRegistered()) {
			msg = "Uzytkownik jest juz zarejestrowany";
			mav.addObject("msg", msg);
			mav.setViewName("/actionfailed");
			System.out.println("/user/create Recived request from registered user: " + user);
		} else {
			user = new User();
			mav.setViewName("/user/add-user-form");
			System.out.println("/user/create Creating new user in memory: " + user);
		}
		
		mav.addObject("user", user);
		
		return mav;
	}
	
	// Rejestracja uzytkownika
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("user") @Valid User user,
			BindingResult bR, HttpServletRequest request){
		
		if(bR.hasErrors()) {
			System.out.println("/user/save Incorrect data recieved");
			return "/user/add-user-form";
		} else {		
		System.out.println("/user/save/ Saving the user in db: " + user);
		//userService.saveUser(user);
		}
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
