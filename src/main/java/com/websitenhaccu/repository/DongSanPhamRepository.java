package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.DongSanPham;

public interface DongSanPhamRepository extends JpaRepository<DongSanPham, String>{
	
	public List<DongSanPham> findAll();
	
	public List<DongSanPham> findByTenDongSanPhamContaining(String tenDongSanPham);
	
	public List<DongSanPham> findByLoaiSanPhamIdAndThuongHieuId(String maLoaiSanPham, String maThuongHieu);

	public List<DongSanPham> findByTenDongSanPhamContainingAndLoaiSanPhamIdContainingAndThuongHieuIdContaining(String tenDongSanPham, String maLoaiSanPham, String maThuongHieu);
}
