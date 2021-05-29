package com.websitenhaccu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.service.MauSanPhamService;

@RestController
@RequestMapping("/api/mau-san-pham")
public class MauSanPhamRestController {
	
	@Autowired
	private MauSanPhamService mauSanPhamService;
	
	@GetMapping
	public int getAllMauSanPhamBySanPhamId(@RequestParam("id") String id){
		List<MauSanPham> list = mauSanPhamService.getMauSanPhamTheoMaSanPham(id);
		int total = 0;
		for(MauSanPham msp : list) {
			total += msp.getSoLuong();
		}
		return total;
	}
}
