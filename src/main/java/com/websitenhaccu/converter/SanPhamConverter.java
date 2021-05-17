package com.websitenhaccu.converter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.dto.SanPhamDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.service.DongSanPhamService;
import com.websitenhaccu.service.NhaCungCapService;

@Component
public class SanPhamConverter {

	@Autowired
	NhaCungCapService nhaCungCapService;

	@Autowired
	DongSanPhamService dongSanPhamService;

	@Autowired
	MauSanPhamConverter mauSanPhamConverter;

	public SanPham toSanPham(SanPhamDTO sanPhamDTO)  {

		if (sanPhamDTO == null)
			return null;

		String id = sanPhamDTO.getId();
		String tenSanPham = sanPhamDTO.getTenSanPham();
		String moTa = sanPhamDTO.getMoTa();
		double giaBan = sanPhamDTO.getGiaBan();
		double giaNhap = sanPhamDTO.getGiaNhap();
		String xuatXu = sanPhamDTO.getXuatXu();
		boolean trangThai = sanPhamDTO.isTrangThai();
		int baoHanh = sanPhamDTO.getBaoHanh();
		int namSanXuat = sanPhamDTO.getNamSanXuat();
		NhaCungCap nhaCungCap = nhaCungCapService.getNhaCungCapTheoMaNCC(sanPhamDTO.getMaNhaCungCap());
		DongSanPham dongSanPham = dongSanPhamService.getDongSanPhamBangMa(sanPhamDTO.getMaDongSanPham());

		List<MauSanPham> mauSanPhams = new ArrayList<MauSanPham>();

//		List<MauSanPhamDTO> mauSanPhamDTOs = sanPhamDTO.getMauSanPhamDTOs();
//		for (MauSanPhamDTO mauSanPhamDTO : mauSanPhamDTOs) {
//			try {
//				mauSanPhams.add(mauSanPhamConverter.toMauSanPham(mauSanPhamDTO));
//			} catch (UnsupportedEncodingException | SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

		SanPham sanPham = new SanPham(id, tenSanPham, moTa, giaNhap, giaBan, xuatXu, trangThai, baoHanh, namSanXuat,
				nhaCungCap, null, null, null, mauSanPhams, dongSanPham);

		return sanPham;
	}

	public SanPhamDTO tosanPhamDTO(SanPham sanPham) {

		if (sanPham == null)
			return null;

		String id = sanPham.getId();
		String moTa = sanPham.getTenSanPham().replace("\"", "\\\"");
		double giaNhap = sanPham.getGiaNhap();
		double giaBan = sanPham.getGiaBan();
		String xuatXu = sanPham.getXuatXu();
		boolean trangThai = sanPham.isTrangThai();
		int baoHanh = sanPham.getBaoHanh();
		int namSanXuat = sanPham.getNamSanXuat();
		String maNhaCungCap = sanPham.getNhaCungCap().getMaNhaCungCap();
		String maDongSanPham = sanPham.getDongSanPham().getId();
		String maLoaiSanPham = sanPham.getDongSanPham().getLoaiSanPham().getId();
		String maThuongHieu = sanPham.getDongSanPham().getThuongHieu().getId();
		
		List<MauSanPhamDTO> mauSanPhamDTOs = new ArrayList<MauSanPhamDTO>();
		sanPham.getMauSanPhams().forEach(mauSanPham->{
			try {
				mauSanPhamDTOs.add(mauSanPhamConverter.toMauSanPhamDTO(mauSanPham));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});

		return new SanPhamDTO(
				id, maLoaiSanPham, moTa, giaNhap, giaBan, xuatXu, trangThai, baoHanh, namSanXuat, maNhaCungCap, null, mauSanPhamDTOs, maDongSanPham, maLoaiSanPham, maThuongHieu);
	}
}
