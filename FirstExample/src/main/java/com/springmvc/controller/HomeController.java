package com.springmvc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springmvc.model.member;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/", method = RequestMethod.GET)
public class HomeController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String membervalue (Map<String, Object> model){
		member mem = new member();
		model.put("memberVal", mem);
		List<String> sex = new ArrayList<String>();
		sex.add("�j");
		sex.add("��");
		model.put("sex", sex);
		return "memberAdd";
	}
	
	@RequestMapping(value = "/accept", method = RequestMethod.POST)
	public String memberShow (@ModelAttribute("memberVal") member mem, Map<String, Object> model ){
		
		return "memberShow";
	}
	
}
