package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.repository.HoaDonRepository;
import com.websitenhaccu.service.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService {

	@Autowired
	HoaDonRepository hoaDonRepository;

	@Override
	public List<HoaDon> getTatCaHoaDons() {
		return hoaDonRepository.findAll();
	}

	@Override
	public HoaDon getHoaDonTheoId(String id) {
		return hoaDonRepository.findById(id).get();
	}

	@Override
	public HoaDon themHoaDon(HoaDon hoaDon) {
		return hoaDonRepository.save(hoaDon);
	}

	@Override
	public void xoaHoaDon(String id) {
		hoaDonRepository.deleteById(id);
		
	}


}
