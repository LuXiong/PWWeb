package com.pwweb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.DataBaseListener;
import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.User;
import com.pwweb.service.Imp.ClothesServiceImp;
import com.pwweb.service.Imp.UserServiceImp;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private static final long serialVersionUID = -3818409212370094336L;

	private String uid;
	private String name;
	private Integer gender;
	private String password;
	private String phone;
	private String avatar;
	private Date createTime;
	private Date lastUse;
	private String deviceId;
	private String description;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private UserServiceImp userServiceImp;
	@OneToMany
	private List<User> userList;

	private HashMap<String, String> jsonData;
	private ArrayList<HashMap<String, Object>> arrayData;

	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HashMap<String, String> getJsonData() {
		return jsonData;
	}

	public void setJsonData(HashMap<String, String> jsonData) {
		this.jsonData = jsonData;
	}

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public UserServiceImp getUserServiceImp() {
		return userServiceImp;
	}

	public void setUserServiceImp(UserServiceImp userServiceImp) {
		this.userServiceImp = userServiceImp;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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

	public String ActionDeleteUser() {
		
		final UserServiceImp us = new UserServiceImp();
		us.deleteUser(uid,new DataBaseListener<User>(){
			public void onSuccess(User user){
				if(user!=null){
					System.out.println("delete user successfully");
				}
			}
		});
		return SUCCESS;
	}
/**
 * 每次update就相当于把值重新输入改变下，但是有部分参数不能进行修改
 * 这个方法是只能更新name和avatar
 * @return
 */
	public String ActionUpdateUser() {
		jsonData = new HashMap<String,String>();
		final UserServiceImp us = new UserServiceImp();
		us.updateUser(uid,name,avatar,description,new DataBaseListener<User>(){
			public void onSuccess(User user){
				if(user!=null){
					jsonData.put("user", user.subJson());
				}
			}
		});
		return SUCCESS;
	}

	public String ActionSaveUser(User user) {
		this.userServiceImp.saveUser(this.user);
		return SUCCESS;
	}

   public String ActionQueryUserById(){
	   jsonData = new HashMap<String,String>();
	   final UserServiceImp us = new UserServiceImp();
	   us.queryUserById(uid, new DataBaseListener<User>(){
		   public void onSuccess(User user){
			   if(user!=null){
				   jsonData.put("user", user.subJson());
			   }
		   }
	   });
	   return SUCCESS;
   }

}
