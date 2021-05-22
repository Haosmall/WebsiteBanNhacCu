package com.websitenhaccu.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.websitenhaccu.entity.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, String> {

	public List<SanPham> findByTenSanPhamContainingAndDongSanPhamTenDongSanPhamAndXuatXuAndDongSanPhamThuongHieuTenThuongHieu(
			String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu);

	public SanPham findByTenSanPhamAndDongSanPhamTenDongSanPhamAndXuatXuAndDongSanPhamThuongHieuTenThuongHieu(
			String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu);

	public List<SanPham> findByTenSanPhamContainingAndXuatXuContainingAndDongSanPhamThuongHieuIdContainingAndDongSanPhamLoaiSanPhamIdContaining(String tenSanPham, String xuatXu, String idThuongHieu, String idLoaiSanPham, Pageable pageable);
//			String tenSanPham, String xuatXu, String idThuongHieu, String idLoaiSanPham);
	
	public List<SanPham> findByDongSanPhamLoaiSanPhamIdOrDongSanPhamIdOrDongSanPhamThuongHieuId(String maLoai, String maDong, String maThuongHieu, Pageable pageable);
	
	@Query(value = "SELECT DISTINCT xuat_xu FROM SanPhams", nativeQuery = true)
	public Set<String> getDanhSachXuatXu();
}
