package com.websitenhaccu.controller.admin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.converter.ThuongHieuConverter;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.ThuongHieuService;
import com.websitenhaccu.validator.ThuongHieuValidator;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.mail.Multipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

@Controller
@MultipartConfig(maxFileSize = 16177251)
@RequestMapping("/admin/thuong-hieu")
public class ThuongHieuCotroller {
	@Autowired
	private ThuongHieuService thuongHieuService;

	@Autowired
	private ThuongHieuValidator thuongHieuValidator;

	@GetMapping("/danh-sach-thuong-hieu")
	public ModelAndView getTatcaThuonghieu() {
		List<ThuongHieu> danhsachThuonghieu = thuongHieuService.getTatCaThuongHieu();

		List<ThuongHieuDTO> listThuongHieuDTO = new ArrayList<ThuongHieuDTO>();

		ThuongHieuConverter thuongHieuConverter = new ThuongHieuConverter();

		for (ThuongHieu thuongHieu : danhsachThuonghieu) {
			ThuongHieuDTO thuongHieuDTO = thuongHieuConverter.toThuongHieuDTO(thuongHieu);
			listThuongHieuDTO.add(thuongHieuDTO);
		}

		return new ModelAndView("admin/thuonghieu/ThuongHieu", "listThuongHieu", listThuongHieuDTO);
	}

	@GetMapping("/chi-tiet-thuong-hieu")
	public ModelAndView getChitietThuonghieu(String id) {
		ThuongHieu thuongHieu = thuongHieuService.getThuonghieuBangMa(id);
		ThuongHieuConverter thuongHieuConverter = new ThuongHieuConverter();
		ThuongHieuDTO thuongHieuDTO = thuongHieuConverter.toThuongHieuDTO(thuongHieu);
		return new ModelAndView("admin/thuonghieu/ChiTietThuongHieu", "thuongHieu", thuongHieuDTO);
	}

	@GetMapping("/them-thuong-hieu")
	public String ThemThuongHieu(String id, Model model) {

		ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
		model.addAttribute("formTitle", "Thêm thương hiệu");
		model.addAttribute("formButton", "Thêm");
		model.addAttribute("thuongHieu", thuongHieuDTO);
		return "admin/thuonghieu/FormThuongHieu";

	}

	@PostMapping("/them-thuong-hieu")
	public String ThemThuongHieu(@RequestParam("hinhAnh") MultipartFile filePart,
			@ModelAttribute("thuongHieu") ThuongHieu thuongHieu, BindingResult bindingResult, Model model)
			throws IOException, SerialException, SQLException {

//		thuongHieuValidator.validate(thuongHieu, bindingResult);
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("formTitle", "Thêm thương hiệu");
//			model.addAttribute("formButton", "Thêm");
//			model.addAttribute("thuongHieu", thuongHieu);
//			return "addmin/thuonghieu/FormThuongHieu";
//		}

		byte[] bytes = filePart.getBytes();
		Blob blob = new SerialBlob(bytes);
		thuongHieu.setHinhAnh(blob);

		thuongHieuService.ThemThuonghieu(thuongHieu);

		return "redirect:/admin/thuong-hieu/danh-sach-thuong-hieu";
	}

	@GetMapping(value = "/xoa-thuong-hieu")
	public String xoaThuonghieu(@RequestParam("id") String id) {

		thuongHieuService.XoaThuonghieu(id);

		return "redirect:/admin/thuong-hieu/danh-sach-thuong-hieu";
	}

	@GetMapping("/cap-nhat-thuong-hieu")
	public String CapNhatThuongHieu(@RequestParam("id") String id, Model model) throws SQLException {
		ThuongHieu thuongHieu = thuongHieuService.getThuonghieuBangMa(id);
		model.addAttribute("formTitle", "Cập nhật thương hiệu");
		model.addAttribute("formButton", "Cập nhật");

		ThuongHieuConverter thuongHieuConverter = new ThuongHieuConverter();
		ThuongHieuDTO thuongHieuDTO = thuongHieuConverter.toThuongHieuDTO(thuongHieu);
		model.addAttribute("thuongHieu", thuongHieu);

//		Blob blob = thuongHieu.getHinhAnh();
//		int blobLength = (int) blob.length();  
//		byte[] blobAsBytes = blob.getBytes(1, blobLength);
		model.addAttribute("blob", thuongHieu.getHinhAnh());

		return "admin/thuonghieu/FormThuongHieu";
	}

	@PostMapping("/cap-nhat-thuong-hieu")
	public String CapNhatThuongHieu(@RequestParam("hinhAnh") MultipartFile filePart,
			@ModelAttribute("thuongHieu") ThuongHieu thuongHieu, BindingResult bindingResult, Model model)
			throws IOException, SerialException, SQLException {

//		thuongHieuValidator.validate(thuongHieu, bindingResult);
//		if (bindingResult.hasErrors()) {
//			model.addAttribute("formTitle", "Cập nhật thương hiệu");
//			model.addAttribute("formButton", "Cập nhật");
//
//			ThuongHieuConverter thuongHieuConverter = new ThuongHieuConverter();
////			ThuongHieuDTO thuongHieuDTO = thuongHieuConverter.toThuongHieuDTO(thuongHieu);
//			model.addAttribute("thuongHieu", thuongHieuDTO);
//			
//			return "admin/thuonghieu/FormThuongHieu";
//		}

//		System.out.println("++++++++++++++++++" + filePart);
//		
//		byte[] bytes = filePart.getBytes();
//		System.out.println("++++++++++++++++++" + bytes);
//		
//		if (bytes.length > 0) {
//			Blob blob = new SerialBlob(bytes);
//			System.out.println("++++++++++++++++++"+ blob);
//			
//			if (blob.length() > 0)
//		}
		if(filePart.getSize() > 0) {
			byte[] bytes = filePart.getBytes();
			Blob blob1 = new SerialBlob(bytes);
			thuongHieu.setHinhAnh(blob1);
		}
		
		thuongHieuService.CapnhatThuonghieu(thuongHieu);
		return "redirect:/admin/thuong-hieu/danh-sach-thuong-hieu";
	}

}
