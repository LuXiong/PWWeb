package com.pwweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONObject;

/**
 * UserShare entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user_share", catalog = "pwdb")
public class UserShare implements java.io.Serializable {

	// Fields

	private String id;
	private String userId;
	private String shareId;
	private int isLike;

	// Constructors

	/** default constructor */
	public UserShare() {
	}

	/** full constructor */
	public UserShare(String id,String userId, String shareId, int isLike) {
		this.id = id;
		this.userId = userId;
		this.shareId = shareId;
		this.isLike = isLike;
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

	@Column(name = "share_id", nullable = false)
	public String getShareId() {
		return this.shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	@Column(name = "is_like", nullable = false)
	public int getIsLike() {
		return this.isLike;
	}

	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}

	public String subJson() {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		result.put("id", id);
		result.put("user_id",userId);
		result.put("share_id", shareId);
		result.put("is_like", isLike);
		return result.toString();
	}

}