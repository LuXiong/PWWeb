package com.pwweb.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONObject;

/**
 * Suit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "suit", catalog = "pwdb")
public class Suit implements java.io.Serializable {

	// Fields

	private String id;
	private String userId;
	private String img;
	private String clothes;
	private Integer weather;
	private Integer occasion;
	private Date createTime;
	private Date lastEdit;
	private String description;

	// Constructors

	/** default constructor */
	public Suit() {
	}

	/** minimal constructor */
	public Suit(String userId, Date createTime, Date lastEdit) {
		this.userId = userId;
		this.createTime = createTime;
		this.lastEdit = lastEdit;
	}

	/** full constructor 
	 * @param clothes2 */
	public Suit(String id,String userId, String img, String clothes, Integer weather,
			Integer occasion, Date createTime, Date lastEdit, String description) {
		this.id = id;
		this.userId = userId;
		this.img = img;
		this.clothes = clothes;
		this.weather = weather;
		this.occasion = occasion;
		this.createTime = createTime;
		this.lastEdit = lastEdit;
		this.description = description;
	}

	// Property accessors
	@Id
	@GeneratedValue
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

	@Column(name = "img")
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Column(name = "clothes", length = 2048)
	public String getClothes() {
		return this.clothes;
	}

	public void setClothes(String clothes) {
		this.clothes = clothes;
	}

	@Column(name = "weather")
	public Integer getWeather() {
		return this.weather;
	}

	public void setWeather(Integer weather) {
		this.weather = weather;
	}

	@Column(name = "occasion")
	public Integer getOccasion() {
		return this.occasion;
	}

	public void setOccasion(Integer occasion) {
		this.occasion = occasion;
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

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String subJson() {
		JSONObject result = new JSONObject();
		result.put("id", id);
		result.put("user_id", userId);
		result.put("weather", weather);
		result.put("occasion", occasion);
		result.put("create_time", createTime.getTime());
		result.put("last_edit", lastEdit.getTime());
		result.put("img", img);
		result.put("clothes", clothes);
		result.put("description", description);
		System.out.println(result.toString());
		return result.toString();
	}

}