package com.pwweb.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONObject;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "pwdb")
public class Comment implements java.io.Serializable {

	// Fields

	private String id;
	private String shareId;
	private String userId;
	private Date createTime;
	private String content;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** full constructor */
	public Comment(String id,String shareId, String userId, Date createTime,
			String content) {
		this.id = id;
		this.shareId = shareId;
		this.userId = userId;
		this.createTime = createTime;
		this.content = content;
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

	@Column(name = "share_id", nullable = false)
	public String getShareId() {
		return this.shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
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

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String subJson() {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		result.put("id", id);
		result.put("share_id", shareId);
		result.put("user_id", userId);
		result.put("create_time", createTime.getTime());
		result.put("content", content);
		return result.toString();
	}

}