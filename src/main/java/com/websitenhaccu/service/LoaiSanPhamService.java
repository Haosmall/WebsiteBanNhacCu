package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.LoaiSanPham;

public interface LoaiSanPhamService {
	public List<LoaiSanPham> getTatCaLoaiSanPham();
	public LoaiSanPham getLoaiSanPhamBangTenLoaiSanPham (String tenLoaiSanPham);
	public LoaiSanPham getLoaiSanPhamBangMa (String maLoaiSanPham);
	public void ThemLoaiSanPham (LoaiSanPham loaiSanPham);
	public void XoaLoaiSanPham (String maLoaiSanPham);
	public void CapnhatLoaiSanPham (LoaiSanPham oaiSanPham);
	public List<LoaiSanPham> getDanhSachLoaiSanPhamBangTenLoaiSanPham (String tenLoaiSanPham, int page, int size);
	public LoaiSanPham getLoaiSanPhamTheoTen(String tenLoaiSanPham);
}
