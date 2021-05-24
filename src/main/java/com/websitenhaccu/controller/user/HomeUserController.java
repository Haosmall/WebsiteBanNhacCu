package com.websitenhaccu.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
@RequestMapping("/user")
public class HomeUserController {
	@Autowired
	NguoiDungService userService;

	@RequestMapping("/trang-chu")
	public ModelAndView getUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}
		
		NguoiDungDTO user = userService.getByEmail(email);
		return new ModelAndView("user/home", "user", user);
	}

}
