package com.websitenhaccu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
@RequestMapping("/admin")
public class QuanLyController {
	@Autowired
	NguoiDungService userService;
	
	@Autowired
	private SanPhamService sanPhamService;
	

//	@RequestMapping("/home")
//	public ModelAndView getUser() {
//		
//
//		return new ModelAndView("admin/home");
//	}

	@RequestMapping("/quan-ly")
	public String getUser(Model model) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}
		
		NguoiDungDTO user = userService.getByEmail(email);
		
		List<SanPham> sanPhams = sanPhamService.getTatCaSanPham();

		model.addAttribute("listSanPham", sanPhams);
		model.addAttribute("user", user);

		return "admin/sanpham/SanPham";
	}
}
