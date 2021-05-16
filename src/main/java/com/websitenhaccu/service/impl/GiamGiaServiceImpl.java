package com.websitenhaccu.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.GiamGia;
import com.websitenhaccu.repository.GiamGiaRepository;
import com.websitenhaccu.service.GiamGiaService;

@Service
public class GiamGiaServiceImpl implements GiamGiaService{

	@Autowired
	private GiamGiaRepository giamGiaRepository;

	@Override
	public GiamGia getGiamGiaTheoNgayHienTai(Date ngayHienTai) {
		
		return giamGiaRepository.findByNgayBatDauBeforeAndNgayKetThucAfter(ngayHienTai);
	}

	@Override
	public void themGiamGia(GiamGia giamGia) {
		giamGiaRepository.save(giamGia);
		
	}

	@Override
	public void xoaGiamGia(int id) {
		giamGiaRepository.deleteById(id);
		
	}

	@Override
	public void capNhatGiamGia(GiamGia giamGia) {
		giamGiaRepository.save(giamGia);
		
	}


}
