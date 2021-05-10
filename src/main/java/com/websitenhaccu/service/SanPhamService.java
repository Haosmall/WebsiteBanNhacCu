package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.SanPham;

public interface SanPhamService {

	public List<SanPham> getSanPhams(String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu, int page, int size);

}
