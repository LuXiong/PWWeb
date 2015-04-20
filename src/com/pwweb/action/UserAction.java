package com.pwweb.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.pojo.User;
import com.pwweb.service.Imp.UserServiceImp;

@Entity
@SuppressWarnings("serial")
public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3818409212370094336L;
	
	 private User user; 
	 private UserServiceImp userServiceImp;
	 private List<User> userList;
	 
	 private HashMap<String, Object> jsonData;
	 private ArrayList<HashMap<String, Object>> arrayData;
	 
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

	

	public HashMap<String, Object> getJsonData() {
		return jsonData;
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

	public String ActionDeleteUser(User user){	
		 jsonData = new HashMap<String, Object>();
		 arrayData = new ArrayList<HashMap<String, Object>>();
		 this.userServiceImp.deleteUser(this.user);
		 return SUCCESS;
	}
	
	public String ActionUpdateUser(User user){
		this.userServiceImp.updateUser(this.user);
		return SUCCESS;
	}
	
	public String ActionSaveUser(User user){
	    this.userServiceImp.saveUser(this.user);	
		return SUCCESS;
	}

//	public String ActionQueryByUsername(String username){
//		user = this .userService.queryByUsername(user.getName());
//		return SUCCESS;
//	}
//
//	public String ActionFindAllUser(){
//		userList = this.userService.findAllUser();
//		return SUCCESS;
//	}
}
