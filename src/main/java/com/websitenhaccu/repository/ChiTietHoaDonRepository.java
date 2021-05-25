package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.ChiTietHoaDon;
import com.websitenhaccu.entity.ChiTietHoaDon_PK;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, ChiTietHoaDon_PK> {

	public List<ChiTietHoaDon> findByMauSanPhamSanPhamId(String id);
	
}
