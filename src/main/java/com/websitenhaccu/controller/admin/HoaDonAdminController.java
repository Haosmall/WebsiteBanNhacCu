package com.websitenhaccu.controller.admin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.websitenhaccu.converter.ChiTietHoaDonConverter;
import com.websitenhaccu.converter.HoaDonConverter;
import com.websitenhaccu.dto.ChiTietHoaDonDTO;
import com.websitenhaccu.dto.HoaDonDTO;
import com.websitenhaccu.entity.ChiTietHoaDon;
import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.service.ChiTietHoaDonService;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.util.Constant;

@Controller
@RequestMapping("/admin/quan-li-don-hang")
public class HoaDonAdminController {
	@Autowired
	private HoaDonService hoaDonService;

	@Autowired
	private ChiTietHoaDonService chiTietHoaDonService;
	@Autowired
	private HoaDonConverter hoaDonConverter;
	@Autowired
	private ChiTietHoaDonConverter chiTietHoaDonConverter;

	@GetMapping("/danh-sach-don-hang")
	public String DanhSachHoaDon(Model model) {

		List<HoaDon> hoaDons = hoaDonService.getTatCaHoaDons();
		List<HoaDonDTO> hoaDonDTOs = new ArrayList<HoaDonDTO>();
		hoaDons.forEach(hd -> {
			HoaDonDTO hoaDonDTO = hoaDonConverter.toHoaDonDTO(hd);
			List<ChiTietHoaDonDTO> chiTietHoaDonDTOs = new ArrayList<ChiTietHoaDonDTO>();
			List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonService.getChiTietHoaDonTheoMaHoaDon(hoaDonDTO.getId());

			chiTietHoaDons.forEach(cthd -> {
				ChiTietHoaDonDTO chiTietHoaDonDTO = chiTietHoaDonConverter.toChiTietHoaDonDTO(cthd);
				chiTietHoaDonDTOs.add(chiTietHoaDonDTO);
			});
			hoaDonDTO.setChiTietHoaDonDTOs(chiTietHoaDonDTOs);

			hoaDonDTOs.add(hoaDonDTO);
		});

		model.addAttribute("hoaDonDTOs", hoaDonDTOs);

		return "admin/quanlydonhang/danhsachdonhang";

	}

	@GetMapping("/chi-tiet-don-hang")
	public String xemChiTietDonHang(@RequestParam("maDonHang") String maDonHang, Model model) {

		HoaDon hoaDon = hoaDonService.getHoaDonTheoId(maDonHang);
		List<ChiTietHoaDon> chiTietHoaDons = chiTietHoaDonService.getChiTietHoaDonTheoMaHoaDon(maDonHang);

		hoaDon.setChiTietHoaDons(chiTietHoaDons);

		HoaDonDTO hoaDonDTO = hoaDonConverter.toHoaDonDTO(hoaDon);
		hoaDonDTO.setTongTien(hoaDon.tinhTongTien());

		List<String> trangThais = new ArrayList<String>(Arrays.asList(Constant.DANG_CHO_XU_LY, Constant.DA_TIEP_NHAN,
				Constant.DANG_DONG_GOI, Constant.BAN_GIAO_VAN_CHUYEN, Constant.GIAO_THANH_CONG, Constant.DA_HUY));

		model.addAttribute("hoaDonDTO", hoaDonDTO);
		model.addAttribute("trangThais", trangThais);

		return "admin/quanlydonhang/ChiTietDonHang";

	}
	
	

}
