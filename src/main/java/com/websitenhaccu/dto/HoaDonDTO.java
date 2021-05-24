package com.websitenhaccu.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonDTO {

	private String id;

	private Date ngayLapHD;

	private String diaChiGiaoHang;

	private String soDienThoai;

	private String trangThai;

	private NguoiDungDTO nguoiDung;

	private List<ChiTietHoaDonDTO> chiTietHoaDonDTOs = new ArrayList<ChiTietHoaDonDTO>();

}
