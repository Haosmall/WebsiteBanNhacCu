package com.websitenhaccu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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

	@Type(type = "org.hibernate.type.StringNVarcharType")
	@Column(name = "company_name")
	private String companyName;

	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "home_page")
	private String homePage;



}
