package com.websitenhaccu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
@RequestMapping("/gio-hang")
public class GioHangController {

	@Autowired
	NguoiDungService UserService;

	@GetMapping
	public String hienThiThongTinNguoiDung(Model model) {

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (pricipal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) pricipal).getUsername();
		} else {
			email = pricipal.toString();
		}

		NguoiDungDTO user = UserService.getByEmail(email);
		String[] handleAdress = UserService.handleAddress(user.getAddress());

		model.addAttribute("pageTitle", "Giỏ hàng");
		model.addAttribute("user", user);
		model.addAttribute("address", handleAdress);

		return "user/GioHang";
	}
	
	
	
//	Thay đổi địa chỉ người dùng 

//	@PostMapping("/api/diachi")
//	public @ResponseBody ResponseEntity<UserDTO> saveDiaChiNguioDung(@RequestParam("id") String id,
//			@RequestParam("thanhPho") String thanhPho, @RequestParam("huyen") String huyen,
//			@RequestParam("xa") String xa, @RequestParam("soNha") String soNha) {
//
//		String diaChi = "";
//		diaChi.concat(soNha + ", ");
//		diaChi.concat(xa + ", ");
//		diaChi.concat(huyen + ", ");
//		diaChi.concat(thanhPho);
//		
//
////		return "redirect:/gio-hang";
//	}
}
