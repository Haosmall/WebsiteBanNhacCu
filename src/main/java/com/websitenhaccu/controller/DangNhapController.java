package com.websitenhaccu.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.websitenhaccu.converter.ThuongHieuConverter;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.validator.UserValidator;

@Controller
public class DangNhapController {

	@Autowired
	private NguoiDungService userService;

	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private LoaiSanPhamService LoaiSanPhamService; 
	
	@Autowired
	private ThuongHieuService thuongHieuService; 
	
	@Autowired
	private DongSanPhamService dongSanPhamService; 

	@Autowired
	private ThuongHieuConverter thuongHieuConverter; 

	@RequestMapping("/login")
	public String login(Model model) {
		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		
		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = new HashMap<LoaiSanPham, Set<ThuongHieuDTO>>();
		
		loaiSanPhams.forEach(loaiSanPham -> {
			String maLoai = loaiSanPham.getId();
			Set<ThuongHieuDTO> temp = new HashSet<ThuongHieuDTO>();
			
			dongSanPhams.forEach(dongSanPham -> {
				if(dongSanPham.getLoaiSanPham().getId().equals(maLoai)) {
					String maTH = dongSanPham.getThuongHieu().getId();
					
					thuongHieus.forEach(thuongHieu -> {
						if(thuongHieu.getId().equals(maTH)) {
							temp.add(thuongHieuConverter.toThuongHieuDTO(thuongHieu));
						}
					});
					
				}
			});
			
			map.put(loaiSanPham, temp);
		});
		model.addAttribute("map", map);
		model.addAttribute("pageTitle", "Đăng nhập");
		return "login/login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		String userId = RandomStringUtils.randomNumeric(8);
		NguoiDungDTO userDTO = new NguoiDungDTO(userId);
		
		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		
		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = new HashMap<LoaiSanPham, Set<ThuongHieuDTO>>();
		
		loaiSanPhams.forEach(loaiSanPham -> {
			String maLoai = loaiSanPham.getId();
			Set<ThuongHieuDTO> temp = new HashSet<ThuongHieuDTO>();
			
			dongSanPhams.forEach(dongSanPham -> {
				if(dongSanPham.getLoaiSanPham().getId().equals(maLoai)) {
					String maTH = dongSanPham.getThuongHieu().getId();
					
					thuongHieus.forEach(thuongHieu -> {
						if(thuongHieu.getId().equals(maTH)) {
							temp.add(thuongHieuConverter.toThuongHieuDTO(thuongHieu));
						}
					});
					
				}
			});
			
			map.put(loaiSanPham, temp);
		});
		model.addAttribute("map", map);
		
		model.addAttribute("pageTitle", "Đăng kí tài khoản");
		model.addAttribute("user", userDTO);
		return "login/register";
	}

	@PostMapping(value = "/register")
	public String register(Model model, HttpServletRequest request, @ModelAttribute("user") NguoiDungDTO userDTO,
			BindingResult bindingResult) {
		System.out.println("UserDTO" + userDTO);

		userValidator.validate(userDTO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("pageTitle", "Đăng kí tài khoản");
			return "login/register";
		}

		String baseUrl = "http://" + request.getHeader("host");

		NguoiDungDTO dto = userService.getByEmail(userDTO.getEmail());

		if (dto != null) {
			model.addAttribute("pageTitle", "Đăng kí tài khoản");
			return "login/register";
		}
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
	public String forgotPassword(Model model) {
		model.addAttribute("pageTitle", "Quên mật khẩu");
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
		model.addAttribute("pageTitle", "Đổi mật khẩu");
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
		return "redirect:/trang-chu";
	}
}
