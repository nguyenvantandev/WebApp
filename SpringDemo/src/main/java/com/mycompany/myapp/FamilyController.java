package com.mycompany.myapp;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.arnx.jsonic.JSON;

/**
 *  * 家族の名前をJSON形式で返却するAPIクラスです。  
 */
@Controller
public class FamilyController {
	private static final Logger logger = LoggerFactory.getLogger(FamilyController.class);

	@RequestMapping(value = "/family", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Locale locale, Model model) {
		logger.debug("API start");
		model.addAttribute("callback", request.getParameter("callback"));
		//
		Family family = new Family();
		family.setFirstName("Casio");
		family.setLastName("Function");

		Message message = new Message();
		message.setRetrunCode(0);
		message.setMessage("success");

		String jsonFamily = JSON.encode(family);
		String jsonMessage = JSON.encode(message);
		model.addAttribute("responseData", jsonFamily);
		model.addAttribute("responseMessage", jsonMessage);
		return "response";
	}

	private class Family {
		private String firstName;
		private String lastName;

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}

	private class Message {
		private int retrunCode;
		private String message;
		public int getRetrunCode() {
			return retrunCode;
		}
		public void setRetrunCode(int retrunCode) {
			this.retrunCode = retrunCode;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		
	}
}
