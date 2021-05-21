package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.SanPham;

public interface SanPhamRepository extends JpaRepository<SanPham, String> {

	public List<SanPham> findByTenSanPhamContainingAndDongSanPhamTenDongSanPhamAndXuatXuAndDongSanPhamThuongHieuTenThuongHieu(
			String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu);

	public SanPham findByTenSanPhamAndDongSanPhamTenDongSanPhamAndXuatXuAndDongSanPhamThuongHieuTenThuongHieu(
			String tenSanPham, String tenDongSanPham, String xuatXu, String tenThuongHieu);

	public List<SanPham> findByTenSanPhamContainingAndXuatXuContainingAndDongSanPhamThuongHieuIdContainingAndDongSanPhamLoaiSanPhamIdContaining(
			String tenSanPham, String xuatXu, String idThuongHieu, String idLoaiSanPham);
}
