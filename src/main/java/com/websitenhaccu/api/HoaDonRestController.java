package com.websitenhaccu.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.service.HoaDonService;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonRestController {

	@Autowired
	private HoaDonService HoaDonService;

	@GetMapping("/cap-nhat-trang-thai")
	public HttpStatus capNhatTrangThai(@RequestParam("maDonHang") String maDonHang,
			@RequestParam("trangThai") int trangThai) {
		
		HoaDonService.capNhatHoaDon(maDonHang, trangThai);
		
		return HttpStatus.OK;
		
	}
	

}
