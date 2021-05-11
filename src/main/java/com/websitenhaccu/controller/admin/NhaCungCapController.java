package com.websitenhaccu.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.dto.UserDTO;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.service.NhaCungCapService;
import com.websitenhaccu.service.UserService;
import com.websitenhaccu.util.CustomUserDetails;
import com.websitenhaccu.validator.NhaCungCapValidator;

/**
 * @author nhath
 *
 */
@Controller
@RequestMapping("/admin/nha-cung-cap")
public class NhaCungCapController {

	@Autowired
	NhaCungCapService nhaCungCapService;

	@Autowired
	private NhaCungCapValidator nhaCungCapValidator;

	/**
	 * xem danh sách nhà cung cấp
	 * 
	 * @return
	 */
	@RequestMapping("/danh-sach-nha-cung-cap")
	public ModelAndView getUser() {

		List<NhaCungCap> nhaCungCaps = nhaCungCapService.getTatCaNhaCungCap();

		return new ModelAndView("admin/nhacungcap/NhaCungCap", "listNhaCungCap", nhaCungCaps);
	}

	/**
	 * Xem thông tin chi tiết nhà cung cấp
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/xem-chi-tiet")
	public ModelAndView xemChiTietNhaCungCap(@RequestParam("id") String id) {

		NhaCungCap nhaCungCap = nhaCungCapService.getNhaCungCapTheoMaNCC(id);

		return new ModelAndView("admin/nhacungcap/ChiTietNhaCungCap", "nhaCungCap", nhaCungCap);
	}

	/**
	 * Hiển thi form cập nhật thông tin nhà cung cấp
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/cap-nhat-thong-tin-nha-cung-cap")
	public ModelAndView capNhatThongTinNCCView(@RequestParam("id") String id) {

		NhaCungCap nhaCungCap = nhaCungCapService.getNhaCungCapTheoMaNCC(id);

		return new ModelAndView("admin/nhacungcap/CapNhatNhaCungCap", "nhaCungCap", nhaCungCap);
	}

	/**
	 * Cập nhật thông tin nhà cung cấp
	 * 
	 * @param id
	 * @return
	 */
	@PostMapping(value = "/cap-nhat-thong-tin-nha-cung-cap")
	public ModelAndView capNhatThongTinNCC(@RequestParam("id") String id) {

		NhaCungCap nhaCungCap = nhaCungCapService.getNhaCungCapTheoMaNCC(id);

		return new ModelAndView("admin/nhacungcap/CapNhatNhaCungCap", "nhaCungCap", nhaCungCap);
	}

	/**
	 * Xóa nhà cung cấp
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/xoa-nha-cung-cap")
	public String xoaNhaCungCap(@RequestParam("id") String id) {

		nhaCungCapService.xoaNhaCungCap(id);

		return "redirect:/admin/nha-cung-cap/danh-sach-nha-cung-cap";
	}

	/**
	 * Hiển thi form thêm nhà cung cấp
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/them-nha-cung-cap")
	public String themNhaCungCap(Model model) {

		model.addAttribute("nhaCungCap", new NhaCungCap());

		return "admin/nhacungcap/ThemNhaCungCap";

	}

	/**
	 * Thêm nhà cung cấp
	 * 
	 * @param nhaCungCap
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(value = "/them-nha-cung-cap")
	public String themNhaCungCap(@ModelAttribute("nhaCungCap") NhaCungCap nhaCungCap, BindingResult bindingResult) {

		nhaCungCapValidator.validate(nhaCungCap, bindingResult);

		if (bindingResult.hasErrors()) {
			return "admin/nhacungcap/ThemNhaCungCap";
		}

		nhaCungCapService.themNhaCungCap(nhaCungCap);
//		return "redirect:/admin/nha-cung-cap/them-nha-cung-cap";
		return "redirect:/admin/nha-cung-cap/danh-sach-nha-cung-cap";

	}

}
