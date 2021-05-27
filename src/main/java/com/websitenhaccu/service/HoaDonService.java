package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.HoaDon;

public interface HoaDonService {
	public List<HoaDon> getTatCaHoaDons();

	public HoaDon getHoaDonTheoId(String id);

	public HoaDon themHoaDon(HoaDon hoaDon);
	
	public void xoaHoaDon(String id);

	public HoaDon getHoaDonByNguoiDungId(String idNguoiDung);
}
