package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.DongSanPham;

public interface DongSanPhamService {
	public List<DongSanPham> getTatCaDongSanPham();
	public DongSanPham getDongSanPhamBangTenDongSanPham (String tenDongSanPham);
	public DongSanPham getDongSanPhamBangMa (String maDongSanPham);
	public void ThemDongSanPham (DongSanPham dongSanPham);
	public void XoaDongSanPham (String maDongSanPham);
	public void CapnhatDongSanPham (DongSanPham dongSanPham);
}
