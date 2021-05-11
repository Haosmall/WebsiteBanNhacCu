package com.websitenhaccu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.websitenhaccu.util.MyGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "ThuongHieus")
@Data
@AllArgsConstructor 
@NoArgsConstructor
public class ThuongHieu {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "thuongHieu_generator")
    @GenericGenerator(
        name = "thuongHieu_generator",
        strategy = "com.websitenhaccu.util.MyGenerator", 
        parameters = {
            @Parameter(name = MyGenerator.INCREMENT_PARAM, value = "1"),
            @Parameter(name = MyGenerator.VALUE_PREFIX_PARAMETER, value = "TH"),
            @Parameter(name = MyGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d") }) //Tạo id có dạng TH00001, TH00002,...
	@Column(name = "thuong_hieu_id")
	private String id;
	
	@Column(name = "ten_thuong_hieu", columnDefinition = "NVARCHAR(MAX)")
	private String tenThuongHieu;
	
	@OneToMany(mappedBy = "thuongHieu", fetch = FetchType.LAZY)
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
    private List<DongSanPham> dongSanPhams;

}
