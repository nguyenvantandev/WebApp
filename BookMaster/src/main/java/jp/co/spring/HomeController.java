package jp.co.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.model.SearchInfo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "BookMasterList";
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
