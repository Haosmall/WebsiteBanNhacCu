package com.websitenhaccu.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.converter.SanPhamConverter;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.LoaiSanPhamService;
import com.websitenhaccu.service.MauSanPhamService;
import com.websitenhaccu.service.NhaCungCapService;
import com.websitenhaccu.service.SanPhamService;
import com.websitenhaccu.service.ThuongHieuService;

@RestController
@RequestMapping("/api/san-pham")
public class SanPhamRestController {

	@Autowired
	NhaCungCapService nhaCungCapService;

	@Autowired
	DongSanPhamService dongSanPhamService;

	@Autowired
	LoaiSanPhamService loaiSanPhamService;

	@Autowired
	SanPhamService sanPhamService;

	@Autowired
	ThuongHieuService thuongHieuService;

	@Autowired
	private SanPhamConverter sanPhamConverter;

	@Autowired
	private MauSanPhamService mauSanPhamService;

	@GetMapping(value = "/danh-sach-nha-cung-cap")
	public List<NhaCungCap> getDanhSachNhaCungCap() {

		return nhaCungCapService.getTatCaNhaCungCap();

	}

	@GetMapping(value = "/danh-sach-dong-san-pham")
	public List<DongSanPham> getDanhSachDongSanPham() {

		return dongSanPhamService.getTatCaDongSanPham();

	}

	@GetMapping
	public ResponseEntity<SanPhamDTO> getSanPhamTheoMa(@RequestParam("id") String maSanPham) {
		SanPhamDTO sanPhamDTO = sanPhamService.getSanPhamDTOTheoID(maSanPham);
		if (sanPhamDTO == null)
			// status: 404
			return new ResponseEntity<SanPhamDTO>(HttpStatus.NOT_FOUND);
		// status: 200 success
		return ResponseEntity.ok(sanPhamDTO);
	}

//	@GetMapping("/danh-sach-san-pham/loai/xuat-xu/thuong-hieu")
//	public List<SanPhamDTO> getDanhSachDongSanPhamByLoaiXuatXuThuongHieu(@RequestParam("tenSanPham") String tenSanPham,
//			@RequestParam("xuatXu") String xuatXu, @RequestParam("maLoaiSanPham") String maLoaiSanPham,
//			@RequestParam("maThuongHieu") String maThuongHieu,
//			@RequestParam(value = "page", defaultValue = "0") int page,
//			@RequestParam(value = "size", defaultValue = "10") int size) { //chỉnh default size thành 20
//		
//		List<SanPhamDTO> sanPhamDTOs = new ArrayList<SanPhamDTO>();
//		List<SanPham> sanPhams = sanPhamService.timKiemSanPham(tenSanPham, maLoaiSanPham, xuatXu, maThuongHieu, page,
//				size);
//		for (SanPham sp : sanPhams) {
//			SanPhamDTO sanPhamDTO = new SanPhamDTO(sp.getId(), sp.getTenSanPham(), sp.getXuatXu(),
//					sp.getDongSanPham().getLoaiSanPham().getTenLoaiSanPham(),
//					sp.getDongSanPham().getThuongHieu().getTenThuongHieu());
//			sanPhamDTOs.add(sanPhamDTO);
//		}
//
//		return sanPhamDTOs;
//
//	}

	@GetMapping("/danh-sach-san-pham/loai/xuat-xu/thuong-hieu")
	public List<SanPhamDTO> getDanhSachDongSanPhamByLoaiXuatXuThuongHieu(
			@RequestParam("tenSanPham") String tenSanPham, @RequestParam("xuatXu") String xuatXu,
			@RequestParam("maLoaiSanPham") String maLoaiSanPham, @RequestParam("maThuongHieu") String maThuongHieu,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {

		List<SanPham> sanPhams = sanPhamService.timKiemSanPham(tenSanPham, maLoaiSanPham, xuatXu, maThuongHieu, page,
				size);
		List<SanPhamDTO> listSanPhamSoLuong = new ArrayList<>();

		for (SanPham sp : sanPhams) {
			List<MauSanPham> mauSanPhams = mauSanPhamService.getMauSanPhamTheoMaSanPham(sp.getId());
			int soLuong = 0;
			for (MauSanPham msp : mauSanPhams) {
				soLuong += msp.getSoLuong();
			}
			SanPhamDTO sanPhamDTO = sanPhamConverter.toSanPhamDTO_TrangSanPham(sp);
			sanPhamDTO.setTongSoLuong(soLuong);
			listSanPhamSoLuong.add(sanPhamDTO);
		}

		return listSanPhamSoLuong;

	}

}
