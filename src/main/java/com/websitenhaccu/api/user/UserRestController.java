package com.websitenhaccu.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.service.NguoiDungService;

@RestController
@RequestMapping("/register/api/email")
public class UserRestController {

	@Autowired
	private NguoiDungService userService;

	@GetMapping
	public int getEmailExist(@RequestParam("email") String email) {
		NguoiDungDTO userDTO = userService.getByEmail(email);
		System.out.println(email);
		System.out.println(userDTO);
		return userDTO == null ? -1 : 1;
	}

}
