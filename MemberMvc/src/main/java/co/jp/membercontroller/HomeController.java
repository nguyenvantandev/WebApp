package co.jp.membercontroller;

import java.util.ArrayList;

import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		/*
		 * 性別のプルダウンを設定する
		 */
		List<String> list = new ArrayList<String>();
		list.add("男");
		list.add("女");
		model.addAttribute("sexlist", list);
		/*
		 * 生年月日の年のプルダウンを設定する
		 */
		int staryear = 1950;
		int endyear = 2030;
		List<Integer> year = new ArrayList<Integer>();
		for (int i = staryear; i <= endyear; i++) {
			year.add(i);
		}
		model.addAttribute("yearlist", year);
		/*
		 * 生年月日の月のプルダウンを設定する
		 */
		int startmonth = 1;
		int endmonth = 12;
		List<Integer> month = new ArrayList<Integer>();
		for (int i = startmonth; i <= endmonth; i++) {
			month.add(i);
		}
		model.addAttribute("monthlist", month);
		/*
		 * 生年月日の日のプルダウンを設定する
		 */
		int startday = 1;
		int endday = 31;
		List<Integer> day = new ArrayList<Integer>();
		for (int i = startday; i <= endday; i++) {
			day.add(i);
		}
		model.addAttribute("daylist", day);
		/*
		 * 結婚状況のプルダウンを設定する
		 */
		List<String> mari = new ArrayList<String>();
		mari.add("あり");
		mari.add("無し");
		model.addAttribute("marilist", mari);

		return "MemberAdd";
	}

	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String member(@RequestParam("memberId") String id, @RequestParam("sex") String sex,
			@RequestParam("memberName") String name, @RequestParam("year") String year,
			@RequestParam("month") String month, @RequestParam("day") String day,
			@RequestParam("birthplace") String birthplace, @RequestParam("marStatus") String marStatus,
			@RequestParam("employee") String employee, @RequestParam("persentaddress") String persentaddress,
			Locale locale, Model model) {
		model.addAttribute("memberid", id);
		model.addAttribute("membername", name);
		model.addAttribute("sex", sex);
		String birthdate = year + "/" + month + "/" + day;
		model.addAttribute("birthdate", birthdate);
		model.addAttribute("birthplace", birthplace);
		model.addAttribute("marStatus", marStatus);
		model.addAttribute("employee", employee);
		model.addAttribute("persentaddress", persentaddress);
		return "Membershow";
	}

}
