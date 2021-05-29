package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.websitenhaccu.entity.HoaDon;
import com.websitenhaccu.repository.HoaDonRepository;
import com.websitenhaccu.service.HoaDonService;
import com.websitenhaccu.util.Constant;

@Service
public class HoaDonServiceImpl implements HoaDonService {

	@Autowired
	HoaDonRepository hoaDonRepository;

	@Override
	public List<HoaDon> getTatCaHoaDons() {
		return hoaDonRepository.findAll(Sort.by(Sort.Direction.DESC, "ngayLapHoaDon"));
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

	@Override
	public void capNhatHoaDon(String maHoaDon, int trangThai) {
		HoaDon hoaDon = hoaDonRepository.findById(maHoaDon).get();
		String trangThaiStr = null;
		switch (trangThai) {
		case 1:
			trangThaiStr = Constant.DANG_CHO_XU_LY;
			break;
		case 2:
			trangThaiStr = Constant.DA_TIEP_NHAN;
			break;
		case 3:
			trangThaiStr = Constant.DANG_DONG_GOI;
			break;
		case 4:
			trangThaiStr = Constant.BAN_GIAO_VAN_CHUYEN;
			break;
		case 5:
			trangThaiStr = Constant.GIAO_THANH_CONG;
			break;
		case 6:
			trangThaiStr = Constant.DA_HUY;
			break;

		default:
			trangThaiStr = Constant.DANG_CHO_XU_LY;
			break;
		}
		hoaDon.setTrangThai(trangThaiStr);

		hoaDonRepository.save(hoaDon);
	}

	public HoaDon getHoaDonByNguoiDungId(String idNguoiDung) {
		return hoaDonRepository.getHoaDonByNguoiDungId(idNguoiDung);
	}

	@Override
	public List<HoaDon> getHoaDonTheoNguoiDung(String id) {
		return hoaDonRepository.findByNguoiDungId(id, Sort.by(Sort.Direction.DESC, "ngayLapHoaDon"));
	}

}
