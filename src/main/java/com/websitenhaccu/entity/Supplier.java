package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Suppliers")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Supplier {

	@Id
	@Column(name = "supplier_id")
	private String supplierID;

	@Column(name = "company_name", columnDefinition = "NVARCHAR(MAX)")
	private String companyName;

	@Column(name = "address", columnDefinition = "NVARCHAR(MAX)")
	private String address;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "home_page")
	private String homePage;



}
