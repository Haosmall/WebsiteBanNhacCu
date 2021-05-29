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

import com.websitenhaccu.converter.QuangCaoConverter;
import com.websitenhaccu.dto.QuangCaoDTO;
import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.QuangCao;
import com.websitenhaccu.service.QuangCaoService;

@Controller
@RequestMapping("/admin/quang-cao")
public class QuangCaoController {
	@Autowired
	private QuangCaoService quangCaoService;
	
	@Autowired
	private QuangCaoConverter quangCaoConverter;

	@GetMapping("/danh-quang-cao")
	public ModelAndView getTatCaQuangCao() {
		List<QuangCaoDTO> quangCaoDTOs = quangCaoService.getTatCaQuangCao();
		return new ModelAndView("admin/quangcao/QuangCao", "quangCaoDTOs", quangCaoDTOs);
	}

	@GetMapping("/chi-tiet-quang-cao")
	public ModelAndView getChitietQuangCao(int id) {

		QuangCaoDTO quangCaoDTO = quangCaoService.getQuangCaoTheoId(id);
		
		return new ModelAndView("admin/quangcao/ChiTietQuangCao", "quangCaoDTO", quangCaoDTO);
	}

	@GetMapping("/them-quang-cao")
	public String themQuangCao(Model model) {
		return "admin/quangcao/QuangCaoForm";
	}

	@PostMapping("/them-quang-cao")
	public String themQuangCao(@ModelAttribute("quangCaoDTO") QuangCaoDTO quangCaoDTO) {
		return "redirect:/admin/quang-cao/danh-sach-quang-cao";
	}

	@GetMapping(value = "/xoa-quang-cao")
	public String xoaQuangCao(@RequestParam("id") int id) {

		quangCaoService.xoaQuangCao(id);

		return "redirect:/admin/quang-cao/danh-sach-quang-cao";
	}

	@GetMapping("/cap-nhat-quang-cao")
	public String capNhatQuangCao(@RequestParam("id") int id, Model model) {
		
		return "admin/quangcao/QuangCaoForm";
	}

	@PostMapping("/cap-nhat-quang-cao")
	public String capNhatQuangCao(@ModelAttribute("quangCaoDTO") QuangCaoDTO quangCaoDTO) {
		
		return "redirect:/admin/quang-cao/danh-sach-quang-cao";
	}

}
