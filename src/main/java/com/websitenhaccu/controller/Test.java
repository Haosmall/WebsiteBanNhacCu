package com.websitenhaccu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.service.UserService;

@Controller
public class Test {
	@Autowired
	UserService userService;

	@RequestMapping("/user-info")
	public ModelAndView getUser() {
		UserDTO user = userService.getByEmail("admin");

		return new ModelAndView("User", "user", user);
	}

}
