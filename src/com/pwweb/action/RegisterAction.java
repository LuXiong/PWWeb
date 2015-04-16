package com.pwweb.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.ListIterator;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.Constant;
import com.pwweb.model.User;
import com.pwweb.service.RegisterService;

import javax.persistence.Entity;

@Entity
public class RegisterAction extends ActionSupport{
	private String uid;
	private String username;
	private String password;
	//private String email;
	//private String phone;
	private int gender;

	private HashMap<String, Object> jsonData;
	private ArrayList<HashMap<String, Object>> arrayData;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/***
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	**/
	
	public HashMap<String, Object> getJsonData() {
		return jsonData;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
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
		String result = rs.Register(getUsername(),getPassword(),getGender());
        if(result.equals(Constant.FAILURE)){
           jsonData.put("code", "-1");
		}else{
			jsonData.put("access_token",result);
		}
		arrayData.add(jsonData);
		return SUCCESS;
	}
}
