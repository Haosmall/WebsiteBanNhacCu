package com.websitenhaccu.entity;

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
@Table(name = "Attributes")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class Attribute {

	@Id
	@Column(name = "attribute_id")
	private String attributeID;

	@Column(name = "attribute_name", columnDefinition = "NVARCHAR")
	private String attributeName;
	
	@OneToMany(mappedBy = "attribute", fetch = FetchType.LAZY)
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private List<AttributeValue> attributeValues; 
}
