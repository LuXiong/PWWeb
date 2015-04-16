package com.pwweb.service;

import java.util.List;

import com.pwweb.common.Constant;
import com.pwweb.dao.UserDAO;
import com.pwweb.model.User;
import javax.persistence.Entity;

@Entity
public class RegisterService {

    private UserDAO userDAO;                  //用户DAO接口引用  
	public void setUserDAO(UserDAO userDAO) {  
	        this.userDAO = userDAO;  
	    } 	    
	public String Register(String username,String password,int gender){
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		user.setGender(gender);
		
		if(userDAO.queryByUsername(username) == null){
			userDAO.saveUser(user);//保存用户           
			return Constant.SUCCESS;
		}else{
			return Constant.FAILURE;
		}
		
	}
}
