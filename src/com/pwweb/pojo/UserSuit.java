package com.pwweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONObject;

/**
 * UserSuit entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_suit", catalog = "pwdb")
public class UserSuit implements java.io.Serializable {

	// Fields

	private String id;
	private String userId;
	private String suitId;
	private int isCollect;

	// Constructors

	/** default constructor */
	public UserSuit() {
	}

	/** full constructor */
	public UserSuit(String id,String userId, String suitId, int isCollect) {
		this.id = id;
		this.userId = userId;
		this.suitId = suitId;
		this.isCollect = isCollect;
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

	@Column(name = "suit_id", nullable = false)
	public String getSuitId() {
		return this.suitId;
	}

	public void setSuitId(String suitId) {
		this.suitId = suitId;
	}

	@Column(name = "is_collect", nullable = false)
	public int getIsCollect() {
		return this.isCollect;
	}

	public void setIsCollect(int isCollect) {
		this.isCollect = isCollect;
	}

	public String subJson() {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		result.put("id", id);
		result.put("user_id",userId);
		result.put("suit_id", suitId);
		result.put("is_collect", isCollect);
		return result.toString();
	}

}