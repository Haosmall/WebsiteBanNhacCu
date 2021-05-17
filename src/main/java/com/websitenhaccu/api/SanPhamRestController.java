package com.websitenhaccu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.NhaCungCapService;
import com.websitenhaccu.service.ThuongHieuService;

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamRestController {
	
	@Autowired
	NhaCungCapService nhaCungCapService;
	
	@Autowired
	DongSanPhamService dongSanPhamService;
	
	@Autowired
	LoaiSanPhamService loaiSanPhamService;
	
	@Autowired
	ThuongHieuService thuongHieuService;
	
	@GetMapping(value = "/danh-sach-nha-cung-cap")
	public @ResponseBody List<NhaCungCap> getDanhSachNhaCungCap() {
		
		return nhaCungCapService.getTatCaNhaCungCap();
		
	}
	
	@GetMapping(value = "/danh-sach-dong-san-pham")
	public @ResponseBody List<DongSanPham> getDanhSachDongSanPham() {
		
		return dongSanPhamService.getTatCaDongSanPham();
		
	}

}
