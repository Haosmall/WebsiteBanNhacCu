package com.websitenhaccu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.SanPham;

@Service
public interface SanPhamService {

	public List<SanPham> getSanPhams(String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu, int page, int size);

}
