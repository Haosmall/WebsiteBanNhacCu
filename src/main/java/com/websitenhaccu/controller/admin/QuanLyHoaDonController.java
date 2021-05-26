package com.websitenhaccu.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/quan-li-don-hang")
public class QuanLyHoaDonController {
	
	
	@GetMapping("/danh-sach-don-hang")
	public String DanhSachHoaDon() {
		
		return "admin/quanlydonhang/danhsachdonhang";
		
	}
	
	@GetMapping("/donhang")
	public String ChiTietDonHang() {
		
		return "admin/quanlydonhang/ChiTietDonHang";
		
	}
	

}
