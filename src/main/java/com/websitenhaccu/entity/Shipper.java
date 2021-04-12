package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Shippers")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Shipper {
	
	@Id
	@Column(name = "shipper_id")
	private String shipperId;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "company_name")
	private String companyName;

}
