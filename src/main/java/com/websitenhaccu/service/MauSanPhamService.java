package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;

public interface MauSanPhamService {
	
	public List<MauSanPham> getMauSanPhamTheoMaSanPham(String id);

	public Mau getMauSanPhamTheoTenMau(String tenMau);
	
	public void themMauSanPham(MauSanPham mauSanPham);
	
	public void xoaMauSanPham(String id);
	
	public void capNhatMauSanPham(MauSanPham mauSanPham);
	
}
