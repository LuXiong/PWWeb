package com.pwweb.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Clothes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clothes", catalog = "pwdb")
public class Clothes implements java.io.Serializable {

	// Fields

	private String id;
	private String userId;
	private Integer color;
	private Integer category;
	private Integer exponent;
	private Date createTime;
	private Date lastEdit;
	private String img;
	private String suits;

	// Constructors

	/** default constructor */
	public Clothes() {
	}

	/** minimal constructor */
	public Clothes(String id, String userId, Integer color, Integer category,
			Integer exponent, Date createTime, Date lastEdit) {
		this.id = id;
		this.userId = userId;
		this.color = color;
		this.category = category;
		this.exponent = exponent;
		this.createTime = createTime;
		this.lastEdit = lastEdit;
	}

	/** full constructor */
	public Clothes(String id, String userId, Integer color, Integer category,
			Integer exponent, Date createTime, Date lastEdit, String img,
			String suits) {
		this.id = id;
		this.userId = userId;
		this.color = color;
		this.category = category;
		this.exponent = exponent;
		this.createTime = createTime;
		this.lastEdit = lastEdit;
		this.img = img;
		this.suits = suits;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "user_id", nullable = false)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "color", nullable = false)
	public Integer getColor() {
		return this.color;
	}

	public void setColor(Integer color) {
		this.color = color;
	}

	@Column(name = "category", nullable = false)
	public Integer getCategory() {
		return this.category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	@Column(name = "exponent", nullable = false)
	public Integer getExponent() {
		return this.exponent;
	}

	public void setExponent(Integer exponent) {
		this.exponent = exponent;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_edit", nullable = false, length = 19)
	public Date getLastEdit() {
		return this.lastEdit;
	}

	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}

	@Column(name = "img")
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name = "suits", length = 2048)
	public String getSuits() {
		return this.suits;
	}

	public void setSuits(String suits) {
		this.suits = suits;
	}

}