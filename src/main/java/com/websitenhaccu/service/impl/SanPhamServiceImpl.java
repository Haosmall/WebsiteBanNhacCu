package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.repository.SanPhamRepository;
import com.websitenhaccu.service.SanPhamService;

public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	SanPhamRepository sanPhamRepository;

	@Override
	public List<SanPham> getSanPhams(String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu,
			int page, int size) {
		List<SanPham> sanPhams = sanPhamRepository
				.findByTenSanPhamContainingAndDongSanPhamTenDongSanPhamAndXuatXuAndDongSanPhamThuongHieuTenThuongHieu(
						tenSanPham, tenDongSanPham, xuatXu, tenThuongHieu, PageRequest.of(page, size));
		return sanPhams;
	}

}
