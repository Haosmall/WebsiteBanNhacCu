package com.websitenhaccu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "TinhThanhs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TinhThanh {

	@Id
	@Column(name = "tinh_thanh_id")
	private int id;

	@Column(name = "ten_tinh_thanh", columnDefinition = "NVARCHAR(MAX)")
	private String tenTinhThanh;

	@OneToMany(mappedBy = "tinhThanh", fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<QuanHuyen> quanHuyens = new ArrayList<QuanHuyen>();

}
