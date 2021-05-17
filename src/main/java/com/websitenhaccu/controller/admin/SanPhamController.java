package com.websitenhaccu.controller.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.websitenhaccu.converter.MauSanPhamConverter;
import com.websitenhaccu.converter.SanPhamConverter;
import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.MauService;
import com.websitenhaccu.service.NhaCungCapService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.service.ThuongHieuService;
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
	private NhaCungCapService nhaCungCapService;

	@Autowired
	private MauService mauService;

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@Autowired
	private ThuongHieuService thuongHieuService;

	@Autowired
	private DongSanPhamService dongSanPhamService;

	@Autowired
	private SanPhamValidator sanPhamValidator;
	
	@Autowired
	private SanPhamConverter sanPhamConverter;
	
	@Autowired
	private MauSanPhamConverter mauSanPhamConverter;

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

	@GetMapping(value = "/them-san-pham")
	public String hienThiTrangThemSanPham(Model model) {

		List<NhaCungCap> nhaCungCaps = nhaCungCapService.getTatCaNhaCungCap();
		List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getTatCaLoaiSanPham();
		List<ThuongHieu> thuongHieus = thuongHieuService.getTatCaThuongHieu();
		List<DongSanPham> dongSanPhams = dongSanPhamService.getTatCaDongSanPham();
		List<Mau> maus = mauService.getTatCamau();
		
		if(maus.size() <= 0) {
			List<String> list = new ArrayList<String>(Arrays.asList("Đen", "Vân gỗ", "Trắng", "Nâu"));
			for (String string : list) {
				mauService.themMau(new Mau(0, string));
			}
		}

		model.addAttribute("sanPhamDTO", new SanPhamDTO());
		model.addAttribute("nhaCungCaps", nhaCungCaps);
		model.addAttribute("loaiSanPhams", loaiSanPhams);
		model.addAttribute("thuongHieus", thuongHieus);
		model.addAttribute("dongSanPhams", dongSanPhams);
		model.addAttribute("maus", maus);

		model.addAttribute("formTitle", "Thêm Sản phẩm");
		model.addAttribute("formButton", "Thêm");

		return "admin/sanpham/SanPhamForm";

	}

	@PostMapping(value = "/them-san-pham")
	public String themSanPham(Model model, @ModelAttribute("sanPhamDTO") SanPhamDTO sanPhamDTO,
			@RequestParam("maMau") int maMau, @RequestParam("soLuong") int soLuong,
			@RequestParam("hinhAnh") MultipartFile multipartFile)  {
		
		
		byte[] bytes;
		MauSanPham mauSanPham = null;
		try {
			bytes = multipartFile.getBytes();
		
		String hinhAnh = new String(bytes);
		MauSanPhamDTO mauSanPhamDTO = new MauSanPhamDTO(maMau, null, soLuong, hinhAnh);
//		List<MauSanPhamDTO> mauSanPhamDTOs = new ArrayList<MauSanPhamDTO>(Arrays.asList(mauSanPhamDTO));
//		sanPhamDTO.setMauSanPhamDTOs(mauSanPhamDTOs);
		mauSanPham = mauSanPhamConverter.toMauSanPham(mauSanPhamDTO);
		sanPhamDTO.setTrangThai(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SanPham sanPham = sanPhamConverter.toSanPham(sanPhamDTO);

//		sanPhamValidator.validate(sanPham, bindingResult);

//		if (bindingResult.hasErrors()) {
//
//			model.addAttribute("sanPhamDTO", sanPhamDTO);
//			model.addAttribute("formTitle", "Thêm nhà cung cấp");
//			model.addAttribute("formButton", "Thêm");
//
//			return "admin/nhacungcap/NhaCungCapForm";
//		}

		sanPhamService.themSanPham(sanPham, mauSanPham);

		return "redirect:/admin/san-pham/danh-sach-san-pham";

	}

}
