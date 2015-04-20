package com.pwweb.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.ListIterator;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.Constant;
import com.pwweb.model.User;
import com.pwweb.service.RegisterService;

import javax.persistence.Entity;

@Entity
public class RegisterAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2913082730224697730L;
	private String uid;
	private String name;
	private Integer gender;
	private String password;
	private String phone;
	private String avatar;
	private Date createTime;
	private Date lastUse;
	private String deviceId;

	private HashMap<String, Object> jsonData;
	private ArrayList<HashMap<String, Object>> arrayData;
	
	
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUse() {
		return lastUse;
	}
	public void setLastUse(Date lastUse) {
		this.lastUse = lastUse;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public HashMap<String, Object> getJsonData() {
		return jsonData;
	}
	public int getGender() {
		return gender;
	}

	public void setJsonData(HashMap<String, Object> jsonData) {
		this.jsonData = jsonData;
	}
	public ArrayList<HashMap<String, Object>> getArrayData() {
		return arrayData;
	}
	public void setArrayData(ArrayList<HashMap<String, Object>> arrayData) {
		this.arrayData = arrayData;
	}
	
	public String execute() throws Exception{
		return "json";
	}

	public String ActionRegister(){
		jsonData = new HashMap<String, Object>();
		arrayData = new ArrayList<HashMap<String, Object>>();
		RegisterService rs = new RegisterService();
		String result = rs.Register(getName(),getGender(),getPassword(),getPhone(),getAvatar(),getCreateTime(),getLastUse(),getDeviceId());
        if(result.equals(Constant.FAILURE)){
           jsonData.put("code", "-1");
		}else{
			jsonData.put("access_token",result);
		}
		arrayData.add(jsonData);
		return SUCCESS;
	}
}
