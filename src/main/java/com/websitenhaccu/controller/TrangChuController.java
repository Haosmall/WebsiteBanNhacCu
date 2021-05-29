package com.websitenhaccu.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.websitenhaccu.converter.ThuongHieuConverter;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class TrangChuController {
	@Autowired
	private NguoiDungService userService; 
	
	@Autowired
	private LoaiSanPhamService LoaiSanPhamService; 
	
	@Autowired
	private ThuongHieuService thuongHieuService; 
	
	@Autowired
	private DongSanPhamService dongSanPhamService; 

	@Autowired
	private ThuongHieuConverter thuongHieuConverter; 

	@RequestMapping("/trang-chu")
	public String hienThiTrangChu(Model model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}
		
		NguoiDungDTO user = userService.getByEmail(email);
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
		model.addAttribute("pageTitle", "Trang chủ");
		model.addAttribute("user", user);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		
		return "user/home";
	}

}
