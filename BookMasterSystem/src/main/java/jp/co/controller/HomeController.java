package jp.co.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.dao.MasterDAO;
import jp.co.model.ListInfo;
import jp.co.model.SearchInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@Autowired
	private MasterDAO masterDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView masterList(ModelAndView model) throws IOException{
		List<ListInfo> listInfos = masterDAO.list();
		model.addObject("memberList", listInfos);
		model.setViewName("BookMasterList");
		return model;
	}
	@RequestMapping( value = "/list", method = RequestMethod.POST)
	public String list(@ModelAttribute("searchInfo") SearchInfo search, Locale locale, Model model){
		System.out.println(search.getBookid());
		System.out.println(search.getAuthor());
		System.out.println(search.getTitle());
		System.out.println(search.getPulisher());
		System.out.println(search.getBookid());
		model.addAttribute("searchInfo", search);
		return "BookMasterList";
	}
}
