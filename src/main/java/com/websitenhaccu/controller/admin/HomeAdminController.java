package com.websitenhaccu.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.service.UserService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
@RequestMapping("/admin")
public class HomeAdminController {
	@Autowired
	UserService userService;

//	@RequestMapping("/home")
//	public ModelAndView getUser() {
//		
//
//		return new ModelAndView("admin/home");
//	}

	@RequestMapping("/home")
	public ModelAndView getUser() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}
		
		UserDTO user = userService.getByEmail(email);

		return new ModelAndView("admin/home", "user", user);
	}
}
