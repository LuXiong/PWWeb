package com.pwweb.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONObject;

/**
 * Clothes entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "clothes", catalog = "pwdb")
public class Clothes implements java.io.Serializable {

	// Fields

	private String uuid;
	private String userId;
	private Integer color;
	private Integer category;
	private Integer exponent;
	private Date createTime;
	private Date lastEdit;
	private String img;
	private String suits;
	private String description;
	private Integer isLike;
	private String thumb;

	// Constructors

	/** default constructor */
	public Clothes() {
	}

	/** minimal constructor */
	public Clothes(String userId, Integer color, Integer category,
			Integer exponent, Date createTime, Date lastEdit) {
		this.userId = userId;
		this.color = color;
		this.category = category;
		this.exponent = exponent;
		this.createTime = createTime;
		this.lastEdit = lastEdit;
	}

	/** full constructor */
	public Clothes(String uuid,String userId, Integer color, Integer category,
			Integer exponent, Date createTime, Date lastEdit, String img,
			String suits, String description, Integer isLike, String thumb) {
		this.uuid = uuid;
		this.userId = userId;
		this.color = color;
		this.category = category;
		this.exponent = exponent;
		this.createTime = createTime;
		this.lastEdit = lastEdit;
		this.img = img;
		this.suits = suits;
		this.description = description;
		this.isLike = isLike;
		this.thumb = thumb;
	}

	// Property accessors
	@Id
	@Column(name = "uuid", unique = true, nullable = false)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "is_like")
	public Integer getIsLike() {
		return this.isLike;
	}

	public void setIsLike(Integer isLike) {
		this.isLike = isLike;
	}

	@Column(name = "thumb")
	public String getThumb() {
		return this.thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String subJson() {
		JSONObject result = new JSONObject();
		result.put("uuid", uuid);
		result.put("user_id", userId);
		result.put("color", color);
		result.put("category", category);
		result.put("exponent", exponent);
		result.put("create_time", createTime.getTime());
		result.put("last_edit", lastEdit.getTime());
		result.put("img", img);
		result.put("suits", suits);
		result.put("description", description);
		result.put("is_like", isLike);
		result.put("thumb", thumb);
		System.out.println(result.toString());
		return result.toString();
	}
}