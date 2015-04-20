package com.pwweb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "message", catalog = "pwdb")
public class Message implements java.io.Serializable {

	// Fields

	private Integer id;
	private String topic;
	private String content;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** full constructor */
	public Message(Integer id, String topic, String content) {
		this.id = id;
		this.topic = topic;
		this.content = content;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "topic", nullable = false)
	public String getTopic() {
		return this.topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Column(name = "content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}