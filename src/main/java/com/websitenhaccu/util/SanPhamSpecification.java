package com.websitenhaccu.util;

import java.util.List;

import javax.persistence.criteria.Join;

import org.springframework.data.jpa.domain.Specification;

import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.LoaiSanPham;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.entity.ThuongHieu;

public final class SanPhamSpecification {

	public static Specification<SanPham> timKiemSanPhamTheoXuatXu(List<String> xuatXus) {

		return (root, query, criteriaBuilder) -> root.get("id").in(xuatXus);
	}

	public static Specification<SanPham> timKiemSanPhamTheoKhoangGia(double giaDau, double giaCuoi) {

		return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("giaBan"), giaDau, giaCuoi);
	}

	public static Specification<SanPham> timKiemSanPhamTheoDongSanPham(List<String> listDongSanPhamId) {

		return (root, query, criteriaBuilder) -> {
			Join<SanPham, DongSanPham> dongSanPhamJoin = root.join("dongSanPham");
			return dongSanPhamJoin.get("id").in(listDongSanPhamId);
		};
		
	}
	
	
	public static Specification<SanPham> timKiemSanPhamTheoThuongHieu(List<String> listThuongHieuId) {
		
		return (root, query, criteriaBuilder) -> {
			Join<SanPham, DongSanPham> dongSanPhamJoin = root.join("dongSanPham");
			Join<DongSanPham,ThuongHieu> thuongHieuJoin = dongSanPhamJoin.join("thuongHieu");
			return thuongHieuJoin.get("id").in(listThuongHieuId);
		};
		
	}
	
	public static Specification<SanPham> timKiemSanPhamTheoLoaiSanPham(List<String> listLoaiSanPhamId) {
		
		return (root, query, criteriaBuilder) -> {
			Join<SanPham, DongSanPham> dongSanPhamJoin = root.join("dongSanPham");
			Join<DongSanPham, LoaiSanPham> loaiSanPhamJoin = dongSanPhamJoin.join("loaiSanPham");
			return loaiSanPhamJoin.get("id").in(listLoaiSanPhamId);
		};
		
	}
}
