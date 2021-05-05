package com.websitenhaccu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.service.UserService;
import com.websitenhaccu.util.UserValidator;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login/login");
	}

	@GetMapping("/register")
	public String register(Model model) {
		String userId = RandomStringUtils.randomNumeric(8);
		UserDTO userDTO = new UserDTO(userId);
		model.addAttribute("user", userDTO);
		return "login/register";
	}

	@PostMapping(value = "/register")
	public String register(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO,
			BindingResult bindingResult) {
		System.out.println("UserDTO" + userDTO);

		userValidator.validate(userDTO, bindingResult);

		if (bindingResult.hasErrors()) {
			return "login/register";
		}

		String baseUrl = "http://" + request.getHeader("host");
		userService.registrationVerifyUserByEmail(userDTO, baseUrl);

		return "redirect:/login";
	}

	@GetMapping(value = "/verify-email")
	public String verifyEmail(@RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "token", required = true) String token) {

		boolean result = userService.verifyEmail(email, token);

		if (result)
			return "redirect:/login";

		return "redirect:/error";
	}

	@GetMapping("/forgot-password")
	public String forgotPassword() {
		return "login/forgotPassword";
	}

	@PostMapping("/forgot-password")
	public String forgotPassword(HttpServletRequest request,
			@RequestParam(value = "email", required = true) String email) {
		
		String baseUrl = "http://" + request.getHeader("host");
		userService.sendEmailForgotPassword(email, baseUrl);
		return "redirect:/login";
	}
	
	@GetMapping(value = "/forgot-password/enter-password")
	public String verifyPassword(Model model, @RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "token", required = true) String token) {

		model.addAttribute("email", email);
		model.addAttribute("token", token);

		return "login/verifyPassword";
	}

	@PostMapping(value = "/forgot-password/enter-password")
	public String verifyPassword(Model model, @RequestParam(name = "email", required = true) String email,
			@RequestParam(name = "token", required = true) String token,
			@RequestParam(name = "password", required = true) String password) {
		
		boolean result = userService.verifyPassword(email, token, password);

		if (result)
			return "redirect:/login";

		return "error";
	}

	@GetMapping(value = "/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login";
	}
}
