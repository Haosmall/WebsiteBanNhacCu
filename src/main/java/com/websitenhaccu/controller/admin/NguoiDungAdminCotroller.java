package com.websitenhaccu.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.converter.NguoiDungConverter;
import com.websitenhaccu.dto.NguoiDungDTO;
import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.entity.NguoiDung;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.service.NguoiDungService;

@Controller
@RequestMapping("/admin/nguoi-dung")
public class NguoiDungAdminCotroller {
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private NguoiDungConverter nguoiDungConverter;
	
	@Autowired
	private HoaDonService hoaDonService;
	
	@GetMapping("/danh-sach-nguoi-dung")
	private String getAllKhachHang(Model model) {
		List<NguoiDungDTO> nguoiDungDTOs = new ArrayList<NguoiDungDTO>();
		List<NguoiDung> nguoiDungs = nguoiDungService.timKiemNguoiDung("", "", "", 0, 10);
		nguoiDungs.forEach(nd ->{
			NguoiDungDTO nguoiDungDTO = nguoiDungConverter.toNguoiDungDTO(nd);
			nguoiDungDTOs.add(nguoiDungDTO);
		});
		
		model.addAttribute("listKhachHang", nguoiDungDTOs);
		model.addAttribute("page", 0);
		return "admin/nguoidung/nguoidung";
	}
	
	@PostMapping("/xoa-nguoi-dung")
	private String xoaNguoiDung(Model model, @RequestParam("id") String id) {
		if(nguoiDungService.XoaNguoiDung(id))
			model.addAttribute("trangThaiXoa", "Người dùng có hóa đơn. Không thể xóa");
		else
			model.addAttribute("trangThaiXoa", "Xóa thành công");
		return "redirect:/admin/nguoi-dung/danh-sach-nguoi-dung";
	}

	@GetMapping("/chi-tiet-nguoi-dung")
	private String chiTietNguoiDung(Model model, @RequestParam("id") String id) {
		NguoiDung nguoiDung = nguoiDungService.getNguoiDungById(id);
		model.addAttribute("nguoiDung", nguoiDung);

		return "/admin/nguoidung/ChiTietNguoiDung";
	}
}
