package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.repository.ThuongHieuRepository;
import com.websitenhaccu.service.ThuongHieuService;

@Service
public class ThuongHieuServiceImpl implements ThuongHieuService{

	@Autowired
	private ThuongHieuRepository thuonghieuRepository;
	
	@Override
	public List<ThuongHieu> getTatCaThuongHieu() {
		return thuonghieuRepository.findAll();
	}

	@Override
	public ThuongHieu getThuonghieuBangTenThuonghieu(String tenThuongHieu) {
		ThuongHieu thuonghieu = thuonghieuRepository.findByTenThuongHieu(tenThuongHieu);
		return thuonghieu;		
	}

	@Override
	public void ThemThuonghieu(ThuongHieu thuongHieu) {
		thuonghieuRepository.save(thuongHieu);
	}

	@Override
	public void XoaThuonghieu(String maThuongHieu) {
		thuonghieuRepository.deleteById(maThuongHieu);
	}

	@Override
	public void CapnhatThuonghieu(ThuongHieu thuongHieu){
		if(thuongHieu != null) {
			thuonghieuRepository.save(thuongHieu);
		}
	}

	@Override
	public ThuongHieu getThuonghieuBangMa(String maThuongHieu) {
		ThuongHieu thuonghieu = thuonghieuRepository.findById(maThuongHieu).get();
		return thuonghieu;
	}

}
