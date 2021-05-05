package com.websitenhaccu.entity;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "QuangCaos")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class QuangCao {
	@Id
	@Column(name = "quang_cao_id")
	private String quangCaoId;
	
	@Column(name = "hinh_anh")
	private Blob hinhAnh;
	
	@Column(name = "link")
	private String link;

}
