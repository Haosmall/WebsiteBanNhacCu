package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.ChiTietHoaDon;

public interface ChiTietHoaDonService {
	public List<ChiTietHoaDon> getChiTietHoaDonTheoMaHoaDon(String id);

	public void themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);
	
	public void xoaChiTietHoaDon(String maHoaDon);

}
