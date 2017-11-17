package org.mateuszsikorski.wirtualnydziekanat.controller;

import org.mateuszsikorski.wirtualnydziekanat.entity.StudentDetail;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.mateuszsikorski.wirtualnydziekanat.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("user")
@RequestMapping("/student")
public class StudentController {

	//@Autowired
	//StudentService studentService;
	
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}
	
	public boolean checkPrivagles(User user) {
		if(user.getUserDetail().getStudentDetail() == null)
			return false;
		else return true;
	}
	
	public ModelAndView noPrivagles() {
		
		ModelAndView mav = new ModelAndView();
		
		String msg = "Brak dostepu do tej funkcjonalnosci";
		
		mav.addObject("msg", msg);
		mav.setViewName("/actionfailed");
		
		return mav;
	}
	
	@GetMapping("/detail")
	public ModelAndView studentDetailPage(@ModelAttribute("user") User user) {
		
		if(!checkPrivagles(user))
			return noPrivagles();

		ModelAndView mav = new ModelAndView();
	
		mav.setViewName("/student/student-detail-form");
		
		return mav;
	}
	
	
}
