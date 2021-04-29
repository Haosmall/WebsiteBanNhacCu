package com.websitenhaccu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.service.UserService;

@Controller
@RequestMapping("/admin")
public class HomeAdmin {
	@Autowired
	UserService userService;

	@RequestMapping("/home")
	public ModelAndView getUser() {

		return new ModelAndView("admin/home");
	}

}
