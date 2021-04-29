package com.websitenhaccu.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.service.UserService;

@Controller

@RequestMapping("/user")
public class HomeUser {
	@Autowired
	UserService userService;

	@RequestMapping("/home")
	public ModelAndView getUser() {

		return new ModelAndView("user/home");
	}

}
