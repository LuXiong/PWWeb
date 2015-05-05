package com.pwweb.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.ListIterator;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseListener;
import com.pwweb.pojo.Token;
import com.pwweb.pojo.User;
import com.pwweb.service.PassService;

import javax.persistence.Entity;

@Entity
public class PassAction extends ActionSupport {

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
	private String code;

	private HashMap<String, String> jsonData;
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

	public Integer getGender() {
		return gender;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public HashMap<String, String> getJsonData() {
		return jsonData;
	}

	public void setJsonData(HashMap<String, String> jsonData) {
		this.jsonData = jsonData;
	}

	public ArrayList<HashMap<String, Object>> getArrayData() {
		return arrayData;
	}

	public void setArrayData(ArrayList<HashMap<String, Object>> arrayData) {
		this.arrayData = arrayData;
	}

	public String execute() throws Exception {
		return "json";
	}

	public String ActionLogin() {
		jsonData = new HashMap<String, String>();
		PassService ps = new PassService();
		final String result = ps.login(getPhone(), getPassword(),
				new DataBaseListener<User>() {
					public void onSuccess(User user) {
						if(user!=null){
							jsonData.put("user", user.subJson());
						}
					}
				});
	
//		arrayData.add(jsonData);
		return SUCCESS;
	}

	public String regist() {
		jsonData = new HashMap<String, String>();
		final PassService ps = new PassService();
		ps.regist(name, gender, password, phone, avatar, deviceId, code,
				new DataBaseListener<User>() {

					@Override
					public void onSuccess(User user) {
						if (user != null) {
							jsonData.put("user", user.subJson());
							ps.getToken(user.getPhone(), user.getPassword(),
									new DataBaseListener<Token>() {
										@Override
										public void onSuccess(Token token) {
											jsonData.put("token",
													token.subJson());
										}
									});
						}
					}

					@Override
					public void onFailure(String s) {
						jsonData.put("error", s);
					}
				});
		return SUCCESS;
	}
}
