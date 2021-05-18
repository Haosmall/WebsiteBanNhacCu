package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.repository.MauSanPhamRepository;
import com.websitenhaccu.service.MauSanPhamService;

@Service
public class MauSanPhamServiceImpl implements MauSanPhamService{

	@Autowired
	private MauSanPhamRepository mauSanPhamRepository;

	@Override
	public List<MauSanPham> getMauSanPhamTheoMaSanPham(String id) {
		return mauSanPhamRepository.findBySanPhamId(id);
	}

	@Override
	public Mau getMauSanPhamTheoTenMau(String tenMau) {
		return mauSanPhamRepository.findByMauTenMau(tenMau);
	}

	@Override
	public void themMauSanPham(MauSanPham mauSanPham) {
		mauSanPhamRepository.save(mauSanPham);
		
	}

	@Override
	public void xoaMauSanPham(String id) {
		
		
	}

	@Override
	public void capNhatMauSanPham(MauSanPham mauSanPham) {
		mauSanPhamRepository.save(mauSanPham);
		
	}

	@Override
	public MauSanPham getMauSanPhamTheoMaSanPhamVaMaMau(String maSanPham, int maMau) {
		return mauSanPhamRepository.findBySanPhamIdAndMauId(maSanPham, maMau);
	}


}
