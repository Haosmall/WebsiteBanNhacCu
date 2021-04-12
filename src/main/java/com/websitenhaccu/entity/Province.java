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
@Table(name = "Provinces")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {

	@Id
	@Column(name = "province_id")
	private int provinceId;

	@Column(name = "province_name")
	private String provinceName;

	@OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<District> districts = new ArrayList<District>();

}
