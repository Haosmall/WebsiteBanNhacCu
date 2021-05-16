package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.MauSanPham_PK;

public interface MauSanPhamRepository extends JpaRepository<MauSanPham, MauSanPham_PK> {

	public List<MauSanPham> findBySanPhamId(String id);

	public Mau findByMauTenMau(String tenMau);
	
}
