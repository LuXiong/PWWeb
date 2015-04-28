package com.pwweb.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONObject;

/**
 * Token entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "token", catalog = "pwdb")
public class Token implements java.io.Serializable {

	// Fields

	private String token;
	private String userId;
	private Date createTime;
	private String userPassword;
	private String userPhone;
	private Date lastUse;
	private String deviceId;

	// Constructors

	/** default constructor */
	public Token() {
	}

	/** full constructor */
	public Token(String token, String userId, Date createTime,
			String userPassword, String userPhone, Date lastUse, String deviceId) {
		this.token = token;
		this.userId = userId;
		this.createTime = createTime;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.lastUse = lastUse;
		this.deviceId = deviceId;
	}

	// Property accessors
	@Id
	@Column(name = "token", unique = true, nullable = false)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "user_id", nullable = false)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "user_password", nullable = false)
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "user_phone", nullable = false)
	public String getUserPhone() {
		return this.userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
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

	public String subJson() {
		JSONObject result = new JSONObject();
		result.put("token", token);
		result.put("deviceId", deviceId);
		result.put("createTime", createTime.getTime());
		result.put("lastUse", createTime.getTime());
		return result.toString();
	}

}