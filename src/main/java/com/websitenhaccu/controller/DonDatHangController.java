package com.websitenhaccu.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitenhaccu.converter.ChiTietHoaDonConverter;
import com.websitenhaccu.converter.HoaDonConverter;
import com.websitenhaccu.converter.MauSanPhamConverter;
import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.HoaDonDTO;
import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.ChiTietHoaDon;
import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.service.ChiTietHoaDonService;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.service.MauSanPhamService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.util.Constant;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class DonDatHangController {

	@Autowired
	private NguoiDungService UserService;
	
	@Autowired
	private MauSanPhamService mauSanPhamService;
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@Autowired
	private MauSanPhamConverter mauSanPhamConverter;
	
	@Autowired
	private ChiTietHoaDonConverter chiTietHoaDonConverter;
	
	@Autowired
	private HoaDonConverter hoaDonConverter;

	@GetMapping("/dat-hang")
	public String datHang(Model model, HttpSession httpSession, HttpServletRequest req) {

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (pricipal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) pricipal).getUsername();
		} else {
			email = pricipal.toString();
		}

		NguoiDungDTO user = UserService.getByEmail(email);

		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		String message = "";

		List<ChiTietHoaDonDTO> chiTietHoaDonDTOs = hoaDonDTO.getChiTietHoaDonDTOs();
		
		for (ChiTietHoaDonDTO cthd : chiTietHoaDonDTOs) {
			MauSanPhamDTO mauSanPhamDTO = cthd.getMauSanPhamDTO();
			MauSanPham temp = mauSanPhamService.getMauSanPhamTheoMaSanPhamVaMaMau(mauSanPhamDTO.getMaSanPham(),
					mauSanPhamDTO.getMaMau());
			MauSanPhamDTO current = mauSanPhamConverter.toMauSanPhamDTO(temp);
			int soLuong = cthd.getSoLuong();

			if (soLuong > current.getSoLuong()) {
				message = "Sản phẩm: " + temp.getSanPham().getTenSanPham() + "- màu: " + temp.getMau().getTenMau() + "không đủ số lượng";
				
				model.addAttribute("message", message);
				return "redirect:/gio-hang";
			}
		}
		
		Date temp = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date ngayHienTai = Date.valueOf(format.format(temp));

		hoaDonDTO.setTrangThai(Constant.DANG_CHO_XU_LY);
		hoaDonDTO.setNguoiDung(user);
		hoaDonDTO.setNgayLapHD(ngayHienTai);
		
		HoaDon hoaDon = hoaDonConverter.toHoaDon(hoaDonDTO);
		String id = hoaDonService.themHoaDon(hoaDon).getId();
		
		chiTietHoaDonDTOs.forEach(cthd -> {
			cthd.setMaHoaDon(id);
			ChiTietHoaDon chiTietHoaDon = chiTietHoaDonConverter.toChiTietHoaDon(cthd);
			chiTietHoaDonService.themChiTietHoaDon(chiTietHoaDon);
		});
		
		httpSession.invalidate();

		return "redirect:/gio-hang";
	}

}
