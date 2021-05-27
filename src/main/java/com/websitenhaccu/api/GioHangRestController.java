package com.websitenhaccu.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.converter.MauSanPhamConverter;
import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.HoaDonDTO;
import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.service.MauSanPhamService;
import com.websitenhaccu.util.CustomUserDetails;

@RestController
@RequestMapping("/api/gio-hang")
public class GioHangRestController {

	@Autowired
	private MauSanPhamService mauSanPhamService;

	@Autowired
	private MauSanPhamConverter mauSanPhamConverter;

//	@GetMapping(value = "/user")
//	public @ResponseBody UserDTO getUser() {
//		
//		UserDTO userDTO = new UserDTO();
//		userDTO.setFullName("Trần Hoàng Cầu");
//		userDTO.setPhone("0123456789");
//		
//		return userDTO;
//	}
//	
//	@GetMapping(value = "/user")
//	public @ResponseBody List<String> getDiaChi() {
//		List<String> diaChi = new ArrayList<String>();
//		
//		UserDTO userDTO = new UserDTO();
//		userDTO.setAddress("110 lý thường kiệt, Xã Hữu Sản, Huyện Sơn Động, Tỉnh Bắc Giang");
//
//		
//		
//		
////		return userDTO;

//	}

	@GetMapping("/them-vao-gio-hang")
	public int themVaoGioHang(HttpSession httpSession, @RequestParam("maSanPham") String maSanPham,
			@RequestParam("maMau") int maMau) {

		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		MauSanPham mauSanPham = mauSanPhamService.getMauSanPhamTheoMaSanPhamVaMaMau(maSanPham, maMau);
		MauSanPhamDTO mauSanPhamDTO = mauSanPhamConverter.toMauSanPhamDTO(mauSanPham);

		
		return hoaDonDTO.themChiTietHoaDonDTO(mauSanPhamDTO) ? 1 : -1;
	}
	
	@GetMapping("/cap-nhat-so-luong")
	public HttpStatus capNhatSoLuong(HttpSession httpSession,
			@RequestParam("maSanPham") String maSanPham,
			@RequestParam("maMau") int maMau,
			@RequestParam("soLuong") int soLuong) {
		
		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		MauSanPham mauSanPham = mauSanPhamService.getMauSanPhamTheoMaSanPhamVaMaMau(maSanPham, maMau);
		MauSanPhamDTO mauSanPhamDTO = mauSanPhamConverter.toMauSanPhamDTO(mauSanPham);
		
		hoaDonDTO.getChiTietHoaDonDTOs().forEach(cthd -> {
			if(cthd.getMauSanPhamDTO().equals(mauSanPhamDTO)) {
				cthd.setSoLuong(soLuong);
			}
			
		});
		
		return HttpStatus.OK;
	}
	
	@PutMapping("/cap-nhat-dia-chi")
	public HttpStatus capNhatDiaChi(HttpSession httpSession,
			@RequestBody String data) {
		String diaChiMoi = "";
		try {
			diaChiMoi = URLDecoder.decode(data.split("=")[1], StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println(diaChiMoi);
		
		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		hoaDonDTO.setDiaChiGiaoHang(diaChiMoi);
		
		return HttpStatus.OK;
	}
	
	@DeleteMapping("/xoa-gio-hang")
	public HttpStatus xoaSanPhamKhoiGioHang(HttpSession httpSession, @RequestParam("maSanPham") String maSanPham,
			@RequestParam("maMau") int maMau) {
		
		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		MauSanPham mauSanPham = mauSanPhamService.getMauSanPhamTheoMaSanPhamVaMaMau(maSanPham, maMau);
		MauSanPhamDTO mauSanPhamDTO = mauSanPhamConverter.toMauSanPhamDTO(mauSanPham);
		
		return hoaDonDTO.xoaChiTietHoaDon(mauSanPhamDTO) ? HttpStatus.OK : HttpStatus.BAD_REQUEST;
	}
	
	@GetMapping("/kiem-tra-so-luong-ton")
	public int getSoLuongTon(@RequestParam("maSanPham") String maSanPham,
			@RequestParam("maMau") int maMau) {

		MauSanPham mauSanPham = mauSanPhamService.getMauSanPhamTheoMaSanPhamVaMaMau(maSanPham, maMau);

		return mauSanPham.getSoLuong();
	}
	
	
	@GetMapping("/xem-gio-hang")
	public List<ChiTietHoaDonDTO> xemGioHang(HttpSession httpSession) {
		
		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		
		return hoaDonDTO.getChiTietHoaDonDTOs();
	}

}
