package com.websitenhaccu.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
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

import com.websitenhaccu.converter.NhaCungCapConverter;
import com.websitenhaccu.dto.NhaCungCapDTO;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.validator.SanPhamValidator;

/**
 * @author nhath
 *
 */
@Controller
@RequestMapping("/admin/san-pham")
public class SanPhamController {

	@Autowired
	private SanPhamService sanPhamService;

	@Autowired
	private SanPhamValidator sanPhamValidator;
	
	@Autowired
	private NhaCungCapConverter nhaCungCapConverter;

	@RequestMapping("/danh-sach-san-pham")
	public ModelAndView danhSachSanPham() throws IOException, SQLException {

		List<SanPham> sanPhams = sanPhamService.getTatCaSanPham();
		
		return new ModelAndView("admin/sanpham/SanPham", "listSanPham", sanPhams);
	}

//	@RequestMapping(value = "/xem-chi-tiet")
//	public ModelAndView xemChiTietNhaCungCap(@RequestParam("id") String id) {
//
//		NhaCungCap nhaCungCap = nhaCungCapService.getNhaCungCapTheoMaNCC(id);
//
//		return new ModelAndView("admin/nhacungcap/ChiTietNhaCungCap", "nhaCungCap", nhaCungCap);
//	}

//	@GetMapping(value = "/cap-nhat-thong-tin-nha-cung-cap")
//	public String capNhatThongTinNCCView(Model model, @RequestParam("id") String id) {
//
//		
//		NhaCungCap nhaCungCap = nhaCungCapService.getNhaCungCapTheoMaNCC(id);
//		
//		NhaCungCapDTO nhaCungCapDTO = nhaCungCapConverter.toNhaCungCapDTO(nhaCungCap);
//		
//		model.addAttribute("nhaCungCapDTO", nhaCungCapDTO);
//		model.addAttribute("formTitle", "Cập nhật nhà cung cấp");
//		model.addAttribute("formButton", "Lưu");
//		
//		return "admin/nhacungcap/NhaCungCapForm";
//	}
//
//	@PostMapping(value = "/cap-nhat-thong-tin-nha-cung-cap")
//	public String capNhatThongTinNCC(Model model, @ModelAttribute("nhaCungCapDTO") NhaCungCapDTO nhaCungCapDTO,  BindingResult bindingResult) {
//		
//		NhaCungCap nhaCungCap = nhaCungCapConverter.toNhaCungCap(nhaCungCapDTO);
//		
//		nhaCungCapValidator.validate(nhaCungCap, bindingResult);
//
//		if (bindingResult.hasErrors()) {
//			
//			model.addAttribute("nhaCungCapDTO", nhaCungCapDTO);
//			model.addAttribute("formTitle", "Cập nhật nhà cung cấp");
//			model.addAttribute("formButton", "Lưu");
//			
//			return "admin/nhacungcap/NhaCungCapForm";
//		}
//
//		nhaCungCapService.themNhaCungCap(nhaCungCap);
//
//		return "redirect:/admin/nha-cung-cap/danh-sach-nha-cung-cap";
//	}
//
//	@GetMapping(value = "/xoa-nha-cung-cap")
//	public String xoaNhaCungCap(@RequestParam("id") String id) {
//
//		nhaCungCapService.xoaNhaCungCap(id);
//
//		return "redirect:/admin/nha-cung-cap/danh-sach-nha-cung-cap";
//	}

	@GetMapping(value = "/them-nha-san-pham")
	public String hienThiTrangThemSanPham(Model model) {

		model.addAttribute("nhaCungCapDTO", new NhaCungCapDTO());
		
		model.addAttribute("formTitle", "Thêm nhà cung cấp");
		model.addAttribute("formButton", "Thêm");
		
		return "admin/sanpham/SanPhamForm";

	}

	
	@PostMapping(value = "/them-nha-san-pham")
	public String themSanPham(Model model, @ModelAttribute("nhaCungCapDTO") NhaCungCapDTO nhaCungCapDTO, BindingResult bindingResult) {
		
		SanPham nhaCungCap = nhaCungCapConverter.toThemNhaCungCap(nhaCungCapDTO);
		
		nhaCungCapValidator.validate(nhaCungCap, bindingResult);

		if (bindingResult.hasErrors()) {
			
			model.addAttribute("nhaCungCap", nhaCungCap);
			model.addAttribute("formTitle", "Thêm nhà cung cấp");
			model.addAttribute("formButton", "Thêm");
			
			return "admin/nhacungcap/NhaCungCapForm";
		}

		nhaCungCapService.themNhaCungCap(nhaCungCap);
		
		return "redirect:/admin/nha-cung-cap/danh-sach-nha-cung-cap";

	}

}
