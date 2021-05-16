package com.websitenhaccu.converter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialException;

import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.DongSanPham;
import com.websitenhaccu.entity.ThuongHieu;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class ThuongHieuConverter {
	/**
	 * 
	 * @param thuongHieuDTO khong co truyen biến String base 64
	 * @param inputStream
	 * @return
	 */
	public ThuongHieu toThuongHieu(ThuongHieuDTO thuongHieuDTO, byte[] bytes) {
		if(thuongHieuDTO == null)
			return null;
		
		ThuongHieu thuongHieu = new ThuongHieu();
		
		String id = thuongHieuDTO.getId();
		String tenThuongHieu = thuongHieuDTO.getTenThuongHieu();
		List<DongSanPham> dongSanPhams = thuongHieuDTO.getDongSanPhams();
//		if (inputStream != null) {
//            byte[] bytes;
			try {
//				bytes = IOUtils.toByteArray(inputStream);
				
	            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
	            thuongHieu.setHinhAnh(blob);
			} catch (SerialException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
//        }
		thuongHieu.setDongSanPhams(dongSanPhams);
		thuongHieu.setId(id);
		thuongHieu.setTenThuongHieu(tenThuongHieu);
		
		return thuongHieu;
	}
	
	public ThuongHieuDTO toThuongHieuDTO(ThuongHieu thuongHieu) {
		
		if(thuongHieu == null) {
			return null;
		}
		
		ThuongHieuDTO thuongHieuDTO = new ThuongHieuDTO();
		thuongHieuDTO.setId(thuongHieu.getId());
		thuongHieuDTO.setTenThuongHieu(thuongHieu.getTenThuongHieu());
		thuongHieuDTO.setDongSanPhams(thuongHieu.getDongSanPhams());
		
		Blob blob = thuongHieu.getHinhAnh();
		try {
			if (blob != null) {
	            InputStream inputStream = blob.getBinaryStream();
	            ByteArrayOutputStream outputstream = new ByteArrayOutputStream();
	            byte[] buffer = new byte[4069];
	            int bytesRead = -1;
	            while ((bytesRead = inputStream.read(buffer)) != -1) {
	                outputstream.write(buffer, 0, bytesRead);
	            }
	            byte[] imageBytes = outputstream.toByteArray();
	            String base64Image = Base64.getEncoder().encodeToString(imageBytes);
	            thuongHieuDTO.setHinhAnhBase64(base64Image);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return thuongHieuDTO;
	}
}
