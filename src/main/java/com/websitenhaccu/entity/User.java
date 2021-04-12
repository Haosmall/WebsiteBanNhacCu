package com.websitenhaccu.entity;

import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
@Table(name = "Users")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class User {
	
	@Id
	@Column(name = "user_id")
	private String userId;
	
	@Column(name = "first_name", columnDefinition = "NVARCHAR(MAX)")
	private String firstName;
	
	@Column(name = "last_name", columnDefinition = "NVARCHAR(MAX)")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "birthday")
	private Date birthday;
	
	@Column(name = "address", columnDefinition = "NVARCHAR(MAX)")
	private String address;
	
	@Enumerated
	@Column(name = "gender")
	private Gender gender;
	
	@Column(name = "image")
	private Blob image;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "role")
	private String role;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Order> orders;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<Comment> comments;

}
