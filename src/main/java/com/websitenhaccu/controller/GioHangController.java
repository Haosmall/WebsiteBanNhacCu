package com.websitenhaccu.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.websitenhaccu.converter.ThuongHieuConverter;
import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.HoaDonDTO;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.NguoiDungService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.util.CustomUserDetails;

@Controller
public class GioHangController {

	@Autowired
	NguoiDungService UserService;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	private LoaiSanPhamService LoaiSanPhamService;

	@Autowired
	private ThuongHieuService thuongHieuService;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@Autowired
	private ThuongHieuConverter thuongHieuConverter;

	@GetMapping("/gio-hang")
	public String hienThiGioHang(Model model, HttpSession httpSession) {

		Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String email;
		if (pricipal instanceof CustomUserDetails) {
			email = ((CustomUserDetails) pricipal).getUsername();
		} else {
			email = pricipal.toString();
		}

		NguoiDungDTO user = UserService.getByEmail(email);
		NguoiDung nguoiDung = UserService.getNguoiDungTheoEmail(email);

		HoaDonDTO hoaDonDTO = (HoaDonDTO) httpSession.getAttribute("hoaDonDTO");
		if (hoaDonDTO == null) {
			hoaDonDTO = new HoaDonDTO();
			if (nguoiDung != null) {

				hoaDonDTO.setDiaChiGiaoHang(nguoiDung.getDiaChi());
			}
			httpSession.setAttribute("hoaDonDTO", hoaDonDTO);
		}
		Map<ChiTietHoaDonDTO, SanPhamDTO> mapCTHD = new HashMap<ChiTietHoaDonDTO, SanPhamDTO>();
		hoaDonDTO.getChiTietHoaDonDTOs().forEach(cthd -> {
			String maSP = cthd.getMauSanPhamDTO().getMaSanPham();
			SanPhamDTO sanPhamDTO = sanPhamService.getSanPhamDTOTheoID(maSP);

			mapCTHD.put(cthd, sanPhamDTO);
		});

		List<LoaiSanPham> loaiSanPhams = LoaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();

		Map<LoaiSanPham, Set<ThuongHieuDTO>> map = new HashMap<LoaiSanPham, Set<ThuongHieuDTO>>();

		loaiSanPhams.forEach(loaiSanPham -> {
			String maLoai = loaiSanPham.getId();
			Set<ThuongHieuDTO> temp = new HashSet<ThuongHieuDTO>();

			dongSanPhams.forEach(dongSanPham -> {
				if (dongSanPham.getLoaiSanPham().getId().equals(maLoai)) {
					String maTH = dongSanPham.getThuongHieu().getId();

					thuongHieus.forEach(thuongHieu -> {
						if (thuongHieu.getId().equals(maTH)) {
							temp.add(thuongHieuConverter.toThuongHieuDTO(thuongHieu));
						}
					});

				}
			});

			map.put(loaiSanPham, temp);
		});
		model.addAttribute("map", map);

		model.addAttribute("mapCTHD", mapCTHD);
		model.addAttribute("pageTitle", "Giỏ hàng");
		model.addAttribute("user", user);

		return "user/GioHang";
	}

}
