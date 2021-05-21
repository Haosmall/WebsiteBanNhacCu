package com.websitenhaccu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websitenhaccu.entity.NguoiDung;

public interface UserRepository extends JpaRepository<NguoiDung, String> {
	public NguoiDung findByEmail(String email);

	public NguoiDung findByEmailAndTrangThai(String email, boolean trangThai);
	
	
	
	

	
}
