package com.pwweb.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name = "suit")
public class Suit implements Serializable {

	/**
	 * 
	 */
	@GeneratedValue
	private static final long serialVersionUID = 4445057162444660626L;
	
	@Column(name = "suit_id")
	private String suitId;
  
	@Column(name = "suit_name")
	private String suitName;
	
	@Column(name = "suit_type")
	private int suitType;

	public String getSuitId() {
		return suitId;
	}

	public void setSuitId(String suitId) {
		this.suitId = suitId;
	}

	public String getSuitName() {
		return suitName;
	}

	public void setSuitName(String suitName) {
		this.suitName = suitName;
	}

	public int getSuitType() {
		return suitType;
	}

	public void setSuitType(int suitType) {
		this.suitType = suitType;
	}
	
	
	
}
