package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.repository.DongSanPhamRepository;
import com.websitenhaccu.service.DongSanPhamService;

@Service
public class DongSanPhamServiceImpl implements DongSanPhamService{

	@Autowired
	private DongSanPhamRepository dongSanPhamRepository;
	
	@Override
	public List<DongSanPham> getTatCaDongSanPham() {
		return dongSanPhamRepository.findAll();
	}

	@Override
	public DongSanPham getDongSanPhamBangTenDongSanPham(String tenDongSanPham) {
		DongSanPham dongSanPham = dongSanPhamRepository.findByTenDongSanPham(tenDongSanPham);
		return dongSanPham;		
	}

	@Override
	public void ThemDongSanPham(DongSanPham dongSanPham) {
		dongSanPhamRepository.save(dongSanPham);
	}

	@Override
	public void XoaDongSanPham(String maDongSanPham) {
		dongSanPhamRepository.deleteById(maDongSanPham);
	}

	@Override
	public void CapnhatDongSanPham(DongSanPham dongSanPham){
		if(dongSanPham != null) {
			dongSanPhamRepository.save(dongSanPham);
		}
	}

	@Override
	public DongSanPham getDongSanPhamBangMa(String maDongSanPham) {
		DongSanPham dongSanPham = dongSanPhamRepository.findById(maDongSanPham).get();
		return dongSanPham;
	}

}
