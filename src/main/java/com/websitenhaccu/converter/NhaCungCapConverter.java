package com.websitenhaccu.converter;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.websitenhaccu.dto.NhaCungCapDTO;
import com.websitenhaccu.entity.NhaCungCap;

@Component
public class NhaCungCapConverter {

	public NhaCungCap toNhaCungCap(NhaCungCapDTO nhaCungCapDTO) {

		if (nhaCungCapDTO == null)
			return null;

		String id = nhaCungCapDTO.getMaNhaCungCap();
		String tenNhaCungCap = nhaCungCapDTO.getTenNhaCungCap();

		String soDienThoai = nhaCungCapDTO.getSoDienThoai();

		String email = nhaCungCapDTO.getEmail();
		String website = nhaCungCapDTO.getWebsite();

		StringBuffer buffer = new StringBuffer();
		buffer.append(nhaCungCapDTO.getDiaChi());
		buffer.append(", " + nhaCungCapDTO.getPhuongXa());
		buffer.append(", " + nhaCungCapDTO.getQuanHuyen());
		buffer.append(", " + nhaCungCapDTO.getTinhThanhPho());

		String diaChi = buffer.toString();

		NhaCungCap nhaCungCap = new NhaCungCap(id, tenNhaCungCap, diaChi, soDienThoai, email, website);
		return nhaCungCap;
	}

	public NhaCungCap toThemNhaCungCap(NhaCungCapDTO nhaCungCapDTO) {

		if (nhaCungCapDTO == null)
			return null;

		String tenNhaCungCap = nhaCungCapDTO.getTenNhaCungCap();

		String soDienThoai = nhaCungCapDTO.getSoDienThoai();

		String email = nhaCungCapDTO.getEmail();
		String website = nhaCungCapDTO.getWebsite();

		String diaChiDTO = nhaCungCapDTO.getDiaChi();
		String phuongXa = nhaCungCapDTO.getPhuongXa();
		String quanHuyen = nhaCungCapDTO.getQuanHuyen();
		String tinhThanh = nhaCungCapDTO.getTinhThanhPho();

		Optional<String> optionalDiaChi = Optional.ofNullable(diaChiDTO);
		Optional<String> optionalPhuongXa = Optional.ofNullable(diaChiDTO);
		Optional<String> optionalQuanHuyen = Optional.ofNullable(diaChiDTO);
		Optional<String> optionalTinhThanh = Optional.ofNullable(diaChiDTO);

		String diaChi = "";

		StringBuffer buffer = new StringBuffer();
		if (optionalDiaChi.isPresent() && optionalPhuongXa.isPresent() && optionalQuanHuyen.isPresent()
				&& optionalTinhThanh.isPresent()) {
			buffer.append(diaChiDTO);
			buffer.append(", " + phuongXa);
			buffer.append(", " + quanHuyen);
			buffer.append(", " + tinhThanh);

			diaChi = buffer.toString();
		}
		NhaCungCap nhaCungCap = new NhaCungCap(tenNhaCungCap, diaChi, soDienThoai, email, website);
		return nhaCungCap;
	}

	public NhaCungCapDTO toNhaCungCapDTO(NhaCungCap nhaCungCap) {

		if (nhaCungCap == null)
			return null;

		String id = nhaCungCap.getMaNhaCungCap();
		String tenNhaCungCap = nhaCungCap.getTenNhaCungCap();
		String soDienThoai = nhaCungCap.getSoDienThoai();
		String email = nhaCungCap.getEmail();
		String website = nhaCungCap.getWebsite();

		String tinhThanhPho = "";
		String quanHuyen = "";
		String phuongXa = "";
		String diaChi = "";

		if (nhaCungCap.getDiaChi() != null || nhaCungCap.getDiaChi() != "") {
			String[] temp = nhaCungCap.getDiaChi().split(", ");
			StringBuffer buffer = new StringBuffer();
			
			for (String string : temp) {
				if(string.contains("Tỉnh") || string.contains("Thành phố")) {
					tinhThanhPho = string;
				}
				else if(string.contains("Quận") || string.contains("Huyện") || string.contains("Thị xã")) {
					quanHuyen = string;
				}
				else if(string.contains("Phường") || string.contains("Xã") || string.contains("Thị trấn")) {
					phuongXa = string;
				}else {
					buffer.append(string+", ");
				}
			}
			String tmp = buffer.toString();
			diaChi = tmp.substring(0, tmp.length()-2);
		}

		NhaCungCapDTO nhaCungCapDTO = new NhaCungCapDTO(id, tenNhaCungCap, soDienThoai, email, website, tinhThanhPho,
				quanHuyen, phuongXa, diaChi);

		return nhaCungCapDTO;
	}
}
