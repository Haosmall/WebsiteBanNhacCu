package com.websitenhaccu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.converter.ThuongHieuConverter;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.service.UserService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class HomeController {
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
		
		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		
		Map<LoaiSanPham, List<ThuongHieuDTO>> map = new HashMap<LoaiSanPham, List<ThuongHieuDTO>>();
		
		loaiSanPhams.forEach(loaiSanPham -> {
			
			String maLoai = loaiSanPham.getId();
			
			List<ThuongHieuDTO> temp = new ArrayList<ThuongHieuDTO>();
			
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
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		
		return "user/home";
	}

}
