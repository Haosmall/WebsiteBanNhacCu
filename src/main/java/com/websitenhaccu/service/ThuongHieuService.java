package com.websitenhaccu.service;

import java.util.List;

import com.websitenhaccu.entity.ThuongHieu;

public interface ThuongHieuService {
	public List<ThuongHieu> getTatCaThuongHieu();
	public ThuongHieu getThuonghieuBangTenThuonghieu (String tenThuongHieu);
	public ThuongHieu getThuonghieuBangMa (String maThuongHieu);
	public void ThemThuonghieu (ThuongHieu thuongHieu);
	public void XoaThuonghieu (String maThuongHieu);
	public void CapnhatThuonghieu (ThuongHieu thuongHieu);
}
