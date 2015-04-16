package com.pwweb.action;

import java.util.List;

import javax.persistence.Entity;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.model.User;
import com.pwweb.service.UserService;

@Entity
@SuppressWarnings("serial")
public class UserAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3818409212370094336L;
	
	 private User user; 
	 private UserService userService;
	 private List<User> userList;
	 
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	
	public List<User> getUserList() {
		return userList;
	}


	public void setUserList(List<User> userList) {
		this.userList = userList;
	}


	public String ActionDeleteUser(User user){	
		 this.userService.deleteUser(this.user); 
		 return SUCCESS;
	}
	
	public String ActionUpdateUser(User user){
		this.userService.updateUser(user);
		return SUCCESS;
	}
	
	public String ActionSaveUser(User user){
		this.userService.saveUser(user);
		return SUCCESS;
	}

	public String ActionQueryByUsername(String username){
		user = this .userService.queryByUsername(user.getName());
		return SUCCESS;
	}

	public String ActionFindAllUser(){
		userList = this.userService.findAllUser();
		return SUCCESS;
	}
}
