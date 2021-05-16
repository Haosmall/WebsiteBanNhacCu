package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.repository.ChiTietHoaDonRepository;
import com.websitenhaccu.repository.SanPhamRepository;
import com.websitenhaccu.service.SanPhamService;

public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	SanPhamRepository sanPhamRepository;
	@Autowired
	ChiTietHoaDonRepository chiTietHoaDonRepository;

	@Override
	public void themSanPham(SanPham sanPham) {
		sanPhamRepository.save(sanPham);
		
	}

	@Override
	public boolean xoaSanPham(String id) {
		
		if(chiTietHoaDonRepository.findBySanPhamId(id).size() > 0)
			return false;
		
		sanPhamRepository.deleteById(id);
		return true;
	}

	@Override
	public void capNhatSanPham(SanPham sanPham) {
		sanPhamRepository.save(sanPham);
	}
	
	@Override
	public List<SanPham> timKiemSanPham(String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu,
			int page, int size) {
		List<SanPham> sanPhams = sanPhamRepository
				.findByTenSanPhamContainingAndDongSanPhamTenDongSanPhamAndXuatXuAndDongSanPhamThuongHieuTenThuongHieu(
						tenSanPham, tenDongSanPham, xuatXu, tenThuongHieu, PageRequest.of(page, size));
		return sanPhams;
	}

	@Override
	public List<SanPham> getTatCaSanPham() {
		
		return sanPhamRepository.findAll();
	}

}
