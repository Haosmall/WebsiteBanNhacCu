package com.websitenhaccu.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.converter.ThuongHieuConverter;
import com.websitenhaccu.dto.ThuongHieuDTO;
import com.websitenhaccu.entity.ThuongHieu;
import com.websitenhaccu.service.ThuongHieuService;

@RestController
@RequestMapping("/api/thuong-hieu")
public class ThuongHieuRestController {
	
	@Autowired
	private ThuongHieuService thuongHieuService;
	
	@Autowired
	private ThuongHieuConverter thuongHieuConverter;
	
	@GetMapping("/danh-sach")
	public List<ThuongHieuDTO> getDanhSachThuongHieuBangTenThuongHieu(@RequestParam("tenThuongHieu") String tenThuongHieu){
		List<ThuongHieu> thuongHieus = thuongHieuService.getDanhSachThuongHieuBangTenThuongHieu(tenThuongHieu);
		List<ThuongHieuDTO> thuongHieuDTOs = new ArrayList<ThuongHieuDTO>();
		for(ThuongHieu th : thuongHieus) {
			ThuongHieuDTO thuongHieuDTO = thuongHieuConverter.toThuongHieuDTO(th);
			thuongHieuDTO.setDongSanPhams(null);
			thuongHieuDTOs.add(thuongHieuDTO);
		}
		return thuongHieuDTOs;
	}
}
