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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitenhaccu.converter.ThuongHieuConverter;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.service.UserService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class SanPhamController {
	@Autowired
	private UserService userService; 
	
	@Autowired
	private LoaiSanPhamService LoaiSanPhamService; 
	
	@Autowired
	private ThuongHieuService thuongHieuService; 
	
	@Autowired
	private DongSanPhamService dongSanPhamService;
	
	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private ThuongHieuConverter thuongHieuConverter; 

	@GetMapping("/danh-sach-san-pham/{id}")
	public String hienThiTrangChu(Model model, @PathVariable("id") String id, 
			@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "size", defaultValue = "15") int size) {
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (principal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) principal).getUsername();
		} else {
			email = principal.toString();
		}
		
		UserDTO user = userService.getByEmail(email);
		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		List<SanPhamDTO> sanPhamDTOs;
		Set<String> xuatXus = sanPhamService.getDanhSachXuatXu();
		if(!id.equals("tat-ca")) {
			sanPhamDTOs = sanPhamService.getDanhSachSanPhamTheoLoaiThuongHieuDong(id, page-1, size);
			sanPhamDTOs.forEach(dto->{
				xuatXus.add(dto.getXuatXu());
			});
		}else {
			sanPhamDTOs = sanPhamService.getTatCaSanPham(page-1, size);
			sanPhamDTOs.forEach(dto->{
				xuatXus.add(dto.getXuatXu());
			});
		}
		
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
		
		model.addAttribute("user", user);
		model.addAttribute("map", map);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("xuatXus", xuatXus);
		model.addAttribute("sanPhamDTOs", sanPhamDTOs);
		model.addAttribute("xuatXus", xuatXus);
		
		return "user/DanhSachSanPham";
	}

}
