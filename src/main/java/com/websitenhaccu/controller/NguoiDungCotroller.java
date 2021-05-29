package com.websitenhaccu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitenhaccu.converter.NguoiDungConverter;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
@RequestMapping("/tai-khoan")
public class NguoiDungCotroller {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private NguoiDungConverter nguoiDungConverter;

	@GetMapping("/thong-tin-tai-khoan")
	private String chiTietNguoiDung(Model model) {

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (pricipal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) pricipal).getUsername();
		} else {
			email = pricipal.toString();
		}

		NguoiDung nguoiDung = nguoiDungService.getNguoiDungTheoEmail(email);
		NguoiDungDTO user = nguoiDungConverter.toNguoiDungDTO(nguoiDung);

		model.addAttribute("user", user);

		return "/user/ThongTinTaiKhoan";
	}

	@PostMapping("/thong-tin-tai-khoan")
	private String capNhatThongTinNguoiDung(@ModelAttribute("user") NguoiDungDTO nguoiDungDTO) {

		NguoiDung nguoiDung = nguoiDungConverter.toUpdateUser(nguoiDungDTO);
		nguoiDungService.capNhatNguoiDung(nguoiDung);
		return "redirect:/tai-khoan/thong-tin-tai-khoan";
	}

}
