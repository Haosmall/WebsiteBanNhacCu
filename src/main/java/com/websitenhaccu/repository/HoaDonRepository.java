package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, String> {

	public List<HoaDon> findAll(Sort sort);

	public List<HoaDon> findByNguoiDungId(String id, Sort sort);

	public HoaDon getHoaDonByNguoiDungId(String idNguoiDung);

}
