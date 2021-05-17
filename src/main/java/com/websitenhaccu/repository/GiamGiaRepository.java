package com.websitenhaccu.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.GiamGia;

public interface GiamGiaRepository extends JpaRepository<GiamGia, Integer> {

	public List<GiamGia> findAll();
	
	public GiamGia findByNgayBatDauBeforeAndNgayKetThucAfter(Date ngayHienTai, Date ngayKetThuc);
	
}
