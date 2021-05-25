package com.websitenhaccu.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.HoaDonDTO;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class GioHangController {

	@Autowired
	NguoiDungService UserService;
	@Autowired
	SanPhamService sanPhamService;

	@GetMapping("/gio-hang")
	public String hienThiGioHang(Model model, HttpSession httpSession) {
		
		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (pricipal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) pricipal).getUsername();
		} else {
			email = pricipal.toString();
		}

		NguoiDungDTO user = UserService.getByEmail(email);

		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if(hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		Map<ChiTietHoaDonDTO, SanPhamDTO> map = new HashMap<ChiTietHoaDonDTO, SanPhamDTO>();
		hoaDonDTO.getChiTietHoaDonDTOs().forEach(cthd -> {
			String maSP = cthd.getMauSanPhamDTO().getMaSanPham();
			SanPhamDTO sanPhamDTO = sanPhamService.getSanPhamDTOTheoID(maSP);
			
			map.put(cthd, sanPhamDTO);
		 });
		
		model.addAttribute("map", map);
		model.addAttribute("pageTitle", "Giỏ hàng");
		model.addAttribute("user", user);
		
		
		
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
