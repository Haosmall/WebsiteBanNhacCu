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
@Table(name = "Ads")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Ads {
	@Id
	@Column(name = "ads_id")
	private String adsId;
	
	@Column(name = "image")
	private Blob image;
	
	@Column(name = "link")
	private String link;

}
