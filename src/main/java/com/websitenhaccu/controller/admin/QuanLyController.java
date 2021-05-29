package com.websitenhaccu.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.converter.MauSanPhamConverter;
import com.websitenhaccu.converter.SanPhamConverter;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.MauSanPhamService;
import com.websitenhaccu.service.MauService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.service.NhaCungCapService;
import com.websitenhaccu.util.CustomUserDetails;
import com.websitenhaccu.validator.SanPhamValidator;

@Controller
@RequestMapping("/admin")
public class QuanLyController {
	@Autowired
	NguoiDungService userService;
	
	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@Autowired
	private ThuongHieuService thuongHieuService;

//	@RequestMapping("/home")
//	public ModelAndView getUser() {
//		
//
//		return new ModelAndView("admin/home");
//	}

	@RequestMapping("/quan-ly")
	public String getUser(Model model) {

		List<SanPham> sanPhams = sanPhamService.timKiemSanPham("", "", "", "", 0, 10);
		
		List<String> listXuatXu = new ArrayList<String>();
		for(SanPham sp : sanPhams) {
			String xx = sp.getXuatXu().toLowerCase();
			xx = xx.substring(0, 1).toUpperCase() + xx.substring(1);
			if(!listXuatXu.contains(xx))
				listXuatXu.add(xx);
		}
		
		List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		
		model.addAttribute("page", 0);
		
		model.addAttribute("listSanPham", sanPhams);
		model.addAttribute("listXuatXu", listXuatXu);
		model.addAttribute("listThuongHieu", thuongHieus);
		model.addAttribute("listLoaiSanPham", loaiSanPhams);
		
		return "admin/sanpham/SanPham";
	}
}
