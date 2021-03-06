package com.lycato.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lycato.model.UserInfo;

@Controller
public class HelloController {

	@RequestMapping (value = "input.htm")
	public String showForm (ModelMap model){
		model.addAttribute("user", new UserInfo());
		return "HelloInput";
	}
	
	@RequestMapping ( value = "hello.htm")
	public String sayHello (@ModelAttribute ("user") UserInfo user){
		return "HelloSucess";
	}
}
