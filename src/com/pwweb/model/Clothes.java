package com.pwweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clothes")
public class Clothes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5930534599766788893L;

	@Column(name = "clothes_id")
	private String clothesId;

	@Column(name = "clothes_name")
	private String clothesName;

	@Column(name = "clothes_type")
	private int clothesType;

	@Column(name = "clothes_color")
	private int clothesColor;

	public String getClothesId() {
		return clothesId;
	}

	public void setClothesId(String clothesId) {
		this.clothesId = clothesId;
	}

	public String getClothesName() {
		return clothesName;
	}

	public void setClothesName(String clothesName) {
		this.clothesName = clothesName;
	}

	public int getClothesType() {
		return clothesType;
	}

	public void setClothesType(int clothesType) {
		this.clothesType = clothesType;
	}

	public int getClothesColor() {
		return clothesColor;
	}

	public void setClothesColor(int clothesColor) {
		this.clothesColor = clothesColor;
	}
	
	

}
