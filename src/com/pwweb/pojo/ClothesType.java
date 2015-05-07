package com.pwweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONObject;

/**
 * ClothesType entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clothes_type", catalog = "pwdb")
public class ClothesType implements java.io.Serializable {

	// Fields

	private Integer detailCode;
	private String name;
	private String gender;
	private Integer genderCode;
	private String type;
	private Integer typeCode;
	private Integer exponent;

	// Constructors

	/** default constructor */
	public ClothesType() {
	}

	/** full constructor */
	public ClothesType(String name, String gender, Integer genderCode,
			String type, Integer typeCode, Integer exponent) {
		this.name = name;
		this.gender = gender;
		this.genderCode = genderCode;
		this.type = type;
		this.typeCode = typeCode;
		this.exponent = exponent;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "detail_code", unique = true, nullable = false)
	public Integer getDetailCode() {
		return this.detailCode;
	}

	public void setDetailCode(Integer detailCode) {
		this.detailCode = detailCode;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender", nullable = false)
	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "gender_code", nullable = false)
	public Integer getGenderCode() {
		return this.genderCode;
	}

	public void setGenderCode(Integer genderCode) {
		this.genderCode = genderCode;
	}

	@Column(name = "type", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "type_code", nullable = false)
	public Integer getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(Integer typeCode) {
		this.typeCode = typeCode;
	}

	@Column(name = "exponent", nullable = false)
	public Integer getExponent() {
		return this.exponent;
	}

	public void setExponent(Integer exponent) {
		this.exponent = exponent;
	}
	
	public String subJson() {
		JSONObject result = new JSONObject();
		result.put("detail_code", detailCode);
		result.put("name", name);
		result.put("gender", gender);
		result.put("gender_code", genderCode);
		result.put("exponent", exponent);
		result.put("type_code",typeCode);
		result.put("type", type);
		System.out.println(result.toString());
		return result.toString();
	}


}