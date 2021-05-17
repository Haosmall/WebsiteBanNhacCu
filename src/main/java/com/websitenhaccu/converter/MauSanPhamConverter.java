package com.websitenhaccu.converter;

import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.MauSanPhamDTO;
import com.websitenhaccu.entity.Mau;
import com.websitenhaccu.entity.MauSanPham;
import com.websitenhaccu.entity.SanPham;
import com.websitenhaccu.service.MauService;
import com.websitenhaccu.service.SanPhamService;

@Component
public class MauSanPhamConverter {

	@Autowired
	private MauService mauService;
	
	@Autowired
	private SanPhamService sanPhamService;
	
	public MauSanPham toMauSanPham(MauSanPhamDTO mauSanPhamDTO) throws UnsupportedEncodingException, SerialException, SQLException {

		if (mauSanPhamDTO == null)
			return null;

		int maMau = mauSanPhamDTO.getMaMau();
		Mau mau = mauService.getMauTheoId(maMau);
		
		String maSanPham = mauSanPhamDTO.getMaSanPham();
		SanPham sanPham = null;
		
		Optional<String> optional = Optional.ofNullable(maSanPham);
		
		if(optional.isPresent()) {
			sanPham = sanPhamService.getSanPhamTheoID(maSanPham);
		}
		
		int soLuong = mauSanPhamDTO.getSoLuong();
		
		String hinhAnhBase64 = mauSanPhamDTO.getHinhAnhBase64();
		byte[] bytes = hinhAnhBase64.getBytes("UTF-8");
		Blob hinhAnh = new SerialBlob(bytes);

		MauSanPham mauSanPham = new MauSanPham(mau, sanPham, soLuong, hinhAnh);
		
		return mauSanPham;
	}

	
	public MauSanPhamDTO toMauSanPhamDTO(MauSanPham mauSanPham) throws SQLException {

		if (mauSanPham == null)
			return null;

		int maMau = mauSanPham.getMau().getId();
		String maSanPham = mauSanPham.getSanPham().getId();
		int soLuong = mauSanPham.getSoLuong();
		
		Blob blob = mauSanPham.getHinhAnh();
		int blobLength = (int) blob.length();
		byte[] bytes = blob.getBytes(1, blobLength);
		
		String hinhAnhBase64 = Base64.getEncoder().encodeToString(bytes);
		
		MauSanPhamDTO mauSanPhamDTO = new MauSanPhamDTO(maMau, maSanPham, soLuong, hinhAnhBase64);
		return mauSanPhamDTO;
	}
}
