package com.pwweb.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import net.sf.json.JSONObject;

/**
 * Share entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "share", catalog = "pwdb")
public class Share implements java.io.Serializable {

	// Fields

	private String id;
	private String userId;
	private String suitId;
	private String content;
	private Date createTime;
	private int isPublic;

	// Constructors

	/** default constructor */
	public Share() {
	}

	/** minimal constructor */
	public Share(String userId, String suitId, Date createTime, int isPublic) {
		this.userId = userId;
		this.suitId = suitId;
		this.createTime = createTime;
		this.isPublic = isPublic;
	}

	/** full constructor */
	public Share(String id,String userId, String suitId, String content, Date createTime,
			int isPublic) {
		this.id = id;
		this.userId = userId;
		this.suitId = suitId;
		this.content = content;
		this.createTime = createTime;
		this.isPublic = isPublic;
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

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "is_public", nullable = false)
	public int getIsPublic() {
		return this.isPublic;
	}

	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}

	public String subJson() {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		result.put("id", id);
		result.put("user_id", userId);
		result.put("suit_id", suitId);
		result.put("content", content);
		result.put("create_time", createTime.getTime());
		result.put("is_public", isPublic);
		return result.toString();
	}

}