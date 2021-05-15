package com.websitenhaccu.controller.admin;

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

import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.validator.ThuongHieuValidator;

@Controller
@RequestMapping("/admin/thuong-hieu")
public class ThuongHieuCotroller {
	@Autowired
	private ThuongHieuService thuongHieuService;
	
	@Autowired
	private ThuongHieuValidator thuongHieuValidator;
	
	@GetMapping("/danh-sach-thuong-hieu")
	public ModelAndView getTatcaThuonghieu() {
		List<ThuongHieu> danhsachThuonghieu = thuongHieuService.getTatCaThuongHieu();
		return new ModelAndView("admin/thuonghieu/ThuongHieu", "listThuongHieu", danhsachThuonghieu);
	}
	

	@GetMapping("/chi-tiet-thuong-hieu")
	public ModelAndView getChitietThuonghieu(String id) {
		ThuongHieu thuongHieu = thuongHieuService.getThuonghieuBangMa(id);
		return new ModelAndView("admin/thuonghieu/ChiTietThuongHieu", "thuongHieu", thuongHieu);
	}

	/**
	 * get form add
	 * @param id
	 * @return
	 */
	@GetMapping("/them-thuong-hieu")
	public String ThemThuongHieu(String id, Model model) {
		ThuongHieu thuongHieu = new ThuongHieu();
		model.addAttribute("formTitle", "Thêm thương hiệu");
		model.addAttribute("formButton", "Thêm");
		model.addAttribute("thuongHieu", thuongHieu);
		return "admin/thuonghieu/FormThuongHieu";
	}
	
	/**
	 * save thuong hieu
	 * @param id
	 * @return
	 */
	@PostMapping("/them-thuong-hieu")
	public String ThemThuongHieu(@ModelAttribute("thuongHieu") ThuongHieu thuonghieu, BindingResult bindingResult) {
		thuongHieuValidator.validate(thuonghieu, bindingResult);
		if(bindingResult.hasErrors()) {
			return "addmin/thuonghieu/FormThuongHieu";
		}
		thuongHieuService.ThemThuonghieu(thuonghieu);
		return "redirect:/admin/thuong-hieu/danh-sach-thuong-hieu";
	}
	
	@GetMapping(value = "/xoa-thuong-hieu")
	public String xoaThuonghieu(@RequestParam("id") String id) {

		thuongHieuService.XoaThuonghieu(id);

		return "redirect:/admin/thuong-hieu/danh-sach-thuong-hieu";
	}
	
	/**
	 * form update thuong hieu
	 * @param id
	 * @return
	 */
	@GetMapping("/cap-nhat-thuong-hieu")
	public String CapNhatThuongHieu(@RequestParam("id") String id, Model model) {
		ThuongHieu thuongHieu = thuongHieuService.getThuonghieuBangMa(id);
		model.addAttribute("formTitle", "Cập nhật thương hiệu");
		model.addAttribute("formButton", "Cập nhật");
		model.addAttribute("thuongHieu", thuongHieu);
		return "admin/thuonghieu/FormThuongHieu";
	}
	
	/**
	 * save thuong hieu
	 * @param id
	 * @return
	 */
	@PostMapping("/cap-nhat-thuong-hieu")
	public String CapNhatThuongHieu(@ModelAttribute("thuongHieu") ThuongHieu thuonghieu, BindingResult bindingResult) {
		thuongHieuValidator.validate(thuonghieu, bindingResult);
		if(bindingResult.hasErrors()) {
			return "admin/thuonghieu/FormThuongHieu";
		}
		thuongHieuService.CapnhatThuonghieu(thuonghieu);
		return "redirect:/admin/thuong-hieu/danh-sach-thuong-hieu";
	}
	
}
