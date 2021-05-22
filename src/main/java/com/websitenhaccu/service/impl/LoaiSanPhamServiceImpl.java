package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.repository.LoaiSanPhamRepository;
import com.websitenhaccu.service.LoaiSanPhamService;

@Service
public class LoaiSanPhamServiceImpl implements LoaiSanPhamService{

	@Autowired
	private LoaiSanPhamRepository loaiSanPhamRepository;
	
	@Override
	public List<LoaiSanPham> getTatCaLoaiSanPham() {
		return loaiSanPhamRepository.findAll();
	}

	@Override
	public LoaiSanPham getLoaiSanPhamBangTenLoaiSanPham(String tenLoaiSanPham) {
		LoaiSanPham loaiSanPham = loaiSanPhamRepository.findByTenLoaiSanPham(tenLoaiSanPham);
		return loaiSanPham;		
	}

	@Override
	public void ThemLoaiSanPham(LoaiSanPham loaiSanPham) {
		loaiSanPhamRepository.save(loaiSanPham);
	}

	@Override
	public void XoaLoaiSanPham(String maLoaiSanPham) {
		loaiSanPhamRepository.deleteById(maLoaiSanPham);
	}

	@Override
	public void CapnhatLoaiSanPham(LoaiSanPham loaiSanPham){
		if(loaiSanPham != null) {
			loaiSanPhamRepository.save(loaiSanPham);
		}
	}

	@Override
	public LoaiSanPham getLoaiSanPhamBangMa(String maLoaiSanPham) {
		LoaiSanPham loaiSanPham = loaiSanPhamRepository.findById(maLoaiSanPham).get();
		return loaiSanPham;
	}

	@Override
	public List<LoaiSanPham> getDanhSachLoaiSanPhamBangTenLoaiSanPham(String tenLoaiSanPham, int page, int size) {
		return loaiSanPhamRepository.findByTenLoaiSanPhamContaining(tenLoaiSanPham, PageRequest.of(page, size));
	}

}
