package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.MauSanPham_PK;

public interface MauSanPhamRepository extends JpaRepository<MauSanPham, MauSanPham_PK> {

	public List<MauSanPham> findBySanPhamId(String id);

	public Mau findByMauTenMau(String tenMau);

	public MauSanPham findBySanPhamIdAndMauId(String maSanPham, int maMau);
	
//	@Query(value = "SELECT mau_id , so_luong from Mau_SanPhams", nativeQuery = true)
//	public List<MauSanPham> getDanhSachSoLuongMauBySanPhamId(@Param("id") String id);

}
