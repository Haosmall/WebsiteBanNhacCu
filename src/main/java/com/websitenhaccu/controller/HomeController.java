package com.websitenhaccu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.service.UserService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class HomeController {
	@Autowired
	UserService userService;

	@RequestMapping("/trang-chu")
	public String hienThiTrangChu() {

		return "user/home";
	}

}
