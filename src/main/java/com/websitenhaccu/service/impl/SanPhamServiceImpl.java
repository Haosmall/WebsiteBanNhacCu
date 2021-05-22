package com.websitenhaccu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.repository.ChiTietHoaDonRepository;
import com.websitenhaccu.repository.MauSanPhamRepository;
import com.websitenhaccu.repository.SanPhamRepository;
import com.websitenhaccu.service.SanPhamService;

@Service
public class SanPhamServiceImpl implements SanPhamService {

	@Autowired
	SanPhamRepository sanPhamRepository;

	@Autowired
	MauSanPhamRepository mauSanPhamRepository;

	@Autowired
	ChiTietHoaDonRepository chiTietHoaDonRepository;

	@Override
	public void themSanPham(SanPham sanPham, MauSanPham mauSanPham) {

		SanPham affterSave = sanPhamRepository.save(sanPham);
		sanPhamRepository.flush();
//		String tenSanPham = sanPham.getTenSanPham();
//		String tenDongSanPham = sanPham.getDongSanPham().getTenDongSanPham();
//		String xuatXu = sanPham.getXuatXu();
//		String tenThuongHieu = sanPham.getDongSanPham().getThuongHieu().getTenThuongHieu();
//
//		SanPham affterSave = sanPhamRepository.findByTenSanPhamAndDongSanPhamTenDongSanPhamAndXuatXuAndDongSanPhamThuongHieuTenThuongHieu(tenSanPham, tenDongSanPham, xuatXu, tenThuongHieu);
//		sanPhamRepository.flush();
		String id = affterSave.getId();

//		affterSave.getMauSanPhams().forEach(mauSanPham -> {
		if (mauSanPham.getSanPham() == null) {
			SanPham temp = sanPhamRepository.getOne(id);
			mauSanPham.setSanPham(temp);
		}
		mauSanPhamRepository.save(mauSanPham);
//		});
	}

	@Override
	public boolean xoaSanPham(String id) {

		if (chiTietHoaDonRepository.findBySanPhamId(id).size() > 0)
			return false;

		sanPhamRepository.deleteById(id);
		return true;
	}

	@Override
	public void capNhatSanPham(SanPham sanPham) {
		sanPhamRepository.save(sanPham);
	}

	@Override
	public List<SanPham> timKiemSanPham(String tenSanPham, String maLoaiSanPham, String xuatXu, String maThuongHieu,
			int page, int size) {
		Pageable firstPageWithTwoElements = PageRequest.of(page, size);
		List<SanPham> sanPhams = sanPhamRepository
				.findByTenSanPhamContainingAndXuatXuContainingAndDongSanPhamThuongHieuIdContainingAndDongSanPhamLoaiSanPhamIdContaining(tenSanPham, xuatXu, maThuongHieu, maLoaiSanPham, firstPageWithTwoElements);
		return sanPhams;
	}

	@Override
	public List<SanPham> getTatCaSanPham() {
		
		return sanPhamRepository.findAll();
	}

	@Override
	public SanPham getSanPhamTheoID(String id) {
		return sanPhamRepository.findById(id).get();
	}

	@Override
	public SanPhamDTO getSanPhamDTOTheoID(String id) {

		SanPhamDTO sanPhamDTO = sanPhamRepository.findById(id)
				.map(sanPham -> new SanPhamDTO(sanPham.getId(), sanPham.getTenSanPham(), sanPham.getMoTa()))
				.orElse(null);
		return sanPhamDTO;
	}

}
