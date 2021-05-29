package com.websitenhaccu.api;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.converter.BinhLuanConverter;
import com.websitenhaccu.dto.BinhLuanDTO;
import com.websitenhaccu.entity.BinhLuan;
import com.websitenhaccu.service.BinhLuanService;
import com.websitenhaccu.service.HoaDonService;

@RestController
@RequestMapping("/api/hoa-don")
public class HoaDonRestController {

	@Autowired
	private HoaDonService HoaDonService;
	@Autowired
	private BinhLuanService binhLuanService;
	@Autowired
	private BinhLuanConverter binhLuanConverter;

	@GetMapping("/cap-nhat-trang-thai")
	public HttpStatus capNhatTrangThai(@RequestParam("maDonHang") String maDonHang,
			@RequestParam("trangThai") int trangThai) {
		
		HoaDonService.capNhatHoaDon(maDonHang, trangThai);
		
		return HttpStatus.OK;
		
	}
	
	@PostMapping("/danh-gia")
	public HttpStatus danhGiaSanPham(@RequestBody BinhLuanDTO binhLuanDTO) {
		Date temp = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = Date.valueOf(format.format(temp));
		
		binhLuanDTO.setNgayBinhLuan(ngayHienTai);
		BinhLuan binhLuan = binhLuanConverter.toBinhLuan(binhLuanDTO);
		
		binhLuanService.themBinhLuan(binhLuan);
		
		return HttpStatus.OK;
	}
	
	
	

}
