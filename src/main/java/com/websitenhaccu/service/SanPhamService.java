package com.websitenhaccu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.SanPham;

@Service
public interface SanPhamService {
	
	public List<SanPham> getTatCaSanPham();
	
	public void themSanPham(SanPham sanPham);
	
	public boolean xoaSanPham(String id);
	
	public void capNhatSanPham(SanPham sanPham);

	public List<SanPham> timKiemSanPham(String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu, int page, int size);

}
