package com.pwweb.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONObject;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "pwdb")
public class User implements java.io.Serializable {

	// Fields

	private String uid;
	private String name;
	private Integer gender;
	private String password;
	private String phone;
	private String avatar;
	private Date createTime;
	private Date lastUse;
	private String deviceId;
	private String description;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, Integer gender, String password, String phone,
			Date createTime, Date lastUse, String deviceId) {
		this.name = name;
		this.gender = gender;
		this.password = password;
		this.phone = phone;
		this.createTime = createTime;
		this.lastUse = lastUse;
		this.deviceId = deviceId;
	}

	/** full constructor */
	public User(String uid,String name, Integer gender, String password, String phone,
			String avatar, Date createTime, Date lastUse, String deviceId,
			String description) {
		this.uid = uid;
		this.name = name;
		this.gender = gender;
		this.password = password;
		this.phone = phone;
		this.avatar = avatar;
		this.createTime = createTime;
		this.lastUse = lastUse;
		this.deviceId = deviceId;
		this.description = description;
	}

	// Property accessors
	@Id
	@Column(name = "uid", unique = true, nullable = false)
	public String getUid() {
		return this.uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "gender", nullable = false)
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "avatar")
	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_use", nullable = false, length = 19)
	public Date getLastUse() {
		return this.lastUse;
	}

	public void setLastUse(Date lastUse) {
		this.lastUse = lastUse;
	}

	@Column(name = "device_id", nullable = false)
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
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
		result.put("uid", uid);
		result.put("name", name);
		result.put("gender", gender);
		result.put("password", password);
		result.put("phone", phone);
		result.put("deviceId", deviceId);
		result.put("avatar", avatar);
		result.put("createTime", createTime.getTime());
		result.put("lastUse", createTime.getTime());
		result.put("description",description);
		return result.toString();
	}

}