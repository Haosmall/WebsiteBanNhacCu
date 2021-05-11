package com.websitenhaccu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.NhaCungCap;

public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, String> {

	public List<NhaCungCap> findAll();
	
	public NhaCungCap findByTenNhaCungCap(String tenNhaCungCap);
		

}
