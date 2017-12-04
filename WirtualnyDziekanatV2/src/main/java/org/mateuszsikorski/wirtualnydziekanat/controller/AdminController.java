package org.mateuszsikorski.wirtualnydziekanat.controller;

import java.util.List;

import org.mateuszsikorski.wirtualnydziekanat.entity.StudentGroup;
import org.mateuszsikorski.wirtualnydziekanat.entity.User;
import org.mateuszsikorski.wirtualnydziekanat.service.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
@SessionAttributes("user")
public class AdminController {
	
	@Autowired
	StudentService studentService;
	
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}
	
	public boolean checkPrivagles(User user) {
		if(user.getUserDetail().getAdminDetail() == null)
			return false;
		else return true;
	}
	
	@GetMapping("/panel")
	public ModelAndView getAdminPanel(@ModelAttribute("user") User user) {
		
		if(!checkPrivagles(user)) {
			String msg = "Brak dostepu do tej funkcjonalnosci";
			return HomePageController.actionFailed(msg);
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/admin-panel");
		
		return mav;
	}
	
	@GetMapping("/manageStudentGroups")
	public ModelAndView getStudentGroupManagment(@ModelAttribute("user") User user) {
		
		if(!checkPrivagles(user)) {
			String msg = "Brak dostepu do tej funkcjonalnosci";
			return HomePageController.actionFailed(msg);
		}
		
		ModelAndView mav = new ModelAndView();
		
		List<StudentGroup> studentGroupList = studentService.getStudentGroupList();
		mav.addObject("studentGroupList", studentGroupList);
	
		mav.setViewName("/admin/student-group-list");
		
		return mav;
	}
	
	@GetMapping("/saveStudentGroup")
	public String redirectFromPost1() {
		return "forward:/admin/manageStudentGroups";
	}
	
	@GetMapping("/createStudentGroup")
	public ModelAndView createStudentGroup(@ModelAttribute("user") User user) {
		
		if(!checkPrivagles(user)) {
			String msg = "Brak dostepu do tej funkcjonalnosci";
			return HomePageController.actionFailed(msg);
		}
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/admin/create-student-group");
		
		StudentGroup studentGroup = new StudentGroup();
		mav.addObject("studentGroup", studentGroup);
		
		return mav;
	}
	
	@PostMapping("/saveStudentGroup")
	public ModelAndView saveStudentGroup(@ModelAttribute("user") User user,
					@ModelAttribute("studentGroup") StudentGroup studentGroup) {
		
		ModelAndView mav = new ModelAndView();
		
		studentService.saveStudentGroup(studentGroup);
		studentService.saveTimeTable(studentGroup.getTimeTable());
		
		String msg = "Pomylsnie zapisano grupe";
		List<StudentGroup> studentGroupList = studentService.getStudentGroupList();
		mav.addObject("msg", msg);
		mav.addObject("studentGroupList", studentGroupList);
		
		mav.setViewName("/admin/student-group-list");
		
		return mav;
	}
	

}
