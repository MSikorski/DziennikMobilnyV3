package mateuszsikorski.wirtualnydziekanat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class homePageController {

	@RequestMapping("")
	public String homePage() { 
		return "home";
	}
	
}
