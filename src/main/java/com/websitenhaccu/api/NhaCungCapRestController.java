package com.websitenhaccu.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.websitenhaccu.converter.NhaCungCapConverter;
import com.websitenhaccu.dto.NhaCungCapDTO;
import com.websitenhaccu.entity.NhaCungCap;
import com.websitenhaccu.service.NhaCungCapService;


@RestController
@RequestMapping("/api/nha-cung-cap")
public class NhaCungCapRestController {
	
	@Autowired
	private NhaCungCapService nhaCungCapService;
	
	@Autowired
	private NhaCungCapConverter nhaCungCapConverter;
	
	@GetMapping("/danh-sach")
	public List<NhaCungCapDTO> getDanhSachNhaCungCapTheoTen(@RequestParam("tenNhaCungCap") String tenNhaCungCap,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size){
		List<NhaCungCap> nhaCungCaps = nhaCungCapService.timKiemNhaCungCap(tenNhaCungCap, page, size);
		List<NhaCungCapDTO> nhaCungCapDTOs = new ArrayList<NhaCungCapDTO>();
		for(NhaCungCap ncc : nhaCungCaps) {
			NhaCungCapDTO capDTO = nhaCungCapConverter.toNhaCungCapDTO(ncc);
			nhaCungCapDTOs.add(capDTO);
		}
		return nhaCungCapDTOs;
	}
	
}
