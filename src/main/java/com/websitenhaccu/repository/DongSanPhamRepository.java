package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.DongSanPham;

public interface DongSanPhamRepository extends JpaRepository<DongSanPham, String>{
	
	public List<DongSanPham> findAll();
	
	public DongSanPham findByTenDongSanPham(String tenDongSanPham);
}
