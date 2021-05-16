package com.websitenhaccu.service;

import java.sql.Date;

import com.websitenhaccu.entity.GiamGia;

public interface GiamGiaService {

	public GiamGia getGiamGiaTheoNgayHienTai(Date ngayHienTai);

	public void themGiamGia(GiamGia giamGia);

	public void xoaGiamGia(int id);

	public void capNhatGiamGia(GiamGia giamGia);
}
