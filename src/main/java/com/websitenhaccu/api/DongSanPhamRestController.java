package com.websitenhaccu.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.dto.DongSanPhamDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.ThuongHieuService;

@RestController
@RequestMapping("/api/dong-san-pham")
public class DongSanPhamRestController {

	@Autowired
	private LoaiSanPhamService loaiSanPhamService;

	@Autowired
	private ThuongHieuService thuongHieuService;

	@Autowired
	private DongSanPhamService dongSanPhamService;
	
	@GetMapping("/id")
	public ResponseEntity<DongSanPhamDTO> getDongSanPhamTheoMa(@RequestParam("maDongSanPham") String maDongSanPham) {
		DongSanPham dongSanPham =  dongSanPhamService.getDongSanPhamBangMa(maDongSanPham);
		DongSanPhamDTO dongSanPhamDTO = new DongSanPhamDTO(dongSanPham.getId(), dongSanPham.getThuongHieu().getId(), dongSanPham.getLoaiSanPham().getId(), dongSanPham.getTenDongSanPham(), dongSanPham.getThue());
		if(dongSanPhamDTO == null)
			// status: 404
			return new ResponseEntity<DongSanPhamDTO>(HttpStatus.NOT_FOUND);
		// status: 200 success
		return ResponseEntity.ok(dongSanPhamDTO);
	}
/**
 * chi tim bang ten
 */
	@GetMapping("/danh-sach-maloaisanpham-mathuonghieu") //ko có bị lỗi do tìm ra 2 mapping có tham số string
	public List<DongSanPhamDTO> getDanhSachDongSanPhamTheoLoaiSanPhamVaThuongHieu
	(@RequestParam("maLoaiSanPham") String maLoaiSanPham, @RequestParam("maThuongHieu") String maThuongHieu) {
		List<DongSanPhamDTO> listDongSanPhamDTOs = new ArrayList<DongSanPhamDTO>();
		List<DongSanPham> listDongSanPhams = dongSanPhamService.getDanhSachDongSanPhamTheoLoaiSanPhamVaThuongHieu(maLoaiSanPham, maThuongHieu);
		for(DongSanPham d : listDongSanPhams) {
			DongSanPhamDTO d1 = new DongSanPhamDTO(d.getId(), d.getThuongHieu().getId(), d.getLoaiSanPham().getId(), d.getTenDongSanPham(), d.getThue());
			listDongSanPhamDTOs.add(d1);
		}
		return listDongSanPhamDTOs;
	}
	
	@GetMapping("/danh-sach") //ko có bị lỗi do tìm ra 2 mapping có tham số string
	public List<DongSanPhamDTO> getDanhSachDongSanPhamTheoLoaiSanPhamVaThuongHieu
	(@RequestParam("tenDongSanPham") String tenDongSanPham, @RequestParam("maLoaiSanPham") String maLoaiSanPham, @RequestParam("maThuongHieu") String maThuongHieu,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "20") int size) { //doi size thanh 20
		List<DongSanPhamDTO> listDongSanPhamDTOs = new ArrayList<DongSanPhamDTO>();
		List<DongSanPham> listDongSanPhams = dongSanPhamService.getDanhSachDongSanPhamTheoTenVaLoaiSanPhamVaThuongHieu(tenDongSanPham, maLoaiSanPham, maThuongHieu, page, size);
		for(DongSanPham d : listDongSanPhams) {
			DongSanPhamDTO d1 = new DongSanPhamDTO(d.getId(), d.getThuongHieu().getTenThuongHieu(), d.getLoaiSanPham().getTenLoaiSanPham(), d.getTenDongSanPham(), d.getThue());
			listDongSanPhamDTOs.add(d1);
		}
		return listDongSanPhamDTOs;
	}
}
