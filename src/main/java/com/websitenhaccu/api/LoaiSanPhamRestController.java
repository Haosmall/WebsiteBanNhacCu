package com.websitenhaccu.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.dto.LoaiSanPhamDTO;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.service.LoaiSanPhamService;

@RestController
@RequestMapping("/api/loai-san-pham")
public class LoaiSanPhamRestController {
	
	@Autowired
	private LoaiSanPhamService loaiSanPhamService;
	
	@GetMapping("/danh-sach")
	public List<LoaiSanPhamDTO> getDanhSachLoaiSanPhamBangTenLoaiSanPham(@RequestParam("tenLoaiSanPham") String tenLoaiSanPham){
		List<LoaiSanPham> loaiSanPhams = loaiSanPhamService.getDanhSachLoaiSanPhamBangTenLoaiSanPham(tenLoaiSanPham);
		List<LoaiSanPhamDTO> loaiSanPhamDTOs = new ArrayList<LoaiSanPhamDTO>();
		for(LoaiSanPham lsp : loaiSanPhams) {
			LoaiSanPhamDTO loaiSanPhamDTO = new LoaiSanPhamDTO(lsp.getId(), lsp.getTenLoaiSanPham());
			loaiSanPhamDTOs.add(loaiSanPhamDTO);
		}
		return loaiSanPhamDTOs;
	}
}
