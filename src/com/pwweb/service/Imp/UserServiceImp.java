package com.pwweb.service.Imp;


import java.util.List;

import com.pwweb.common.DataBaseListener;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.User;


public class UserServiceImp{

	BaseDAO userDAO = new BaseDAO();
	
	public void saveUser(User user) {
		try {
			userDAO.saveObject(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public User queryByUsername(String username) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	public void deleteUser(String uid,DataBaseListener<User> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO deleteDAO = new BaseDAO();
		try {
			deleteDAO.deleteObjectById(User.class, uid);
//			System.out.println("delete user successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
        listener.onFinish();
	}

	public void updateUser(User user,String name,String avatar,DataBaseListener<User>listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO updateDAO = new BaseDAO();
		user.setName(name);
		user.setAvatar(avatar);
		try {
			updateDAO.updateObject(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
	}



//	public List<User> findAllUser() {
//		// TODO Auto-generated method stub
//
//		return null;
//	}

	// public UserDAO userdao;
//	
//	
//
//	public UserDAO getUserdao() {
//		return userdao;
//	}
//
//	public void setUserdao(UserDAO userdao) {
//		this.userdao = userdao;
//	}
//
//	public void deleteUser(User user) {
//		// TODO Auto-generated method stub
//		this.userdao.deleteUser(user);
//		
//	}
//
//	
//	public List<User> findAllUser() {
//		// TODO Auto-generated method stub
//		return this.userdao.findAllUser();
//
//	}
//
//	
//	public User queryByUsername(String username) {
//		// TODO Auto-generated method stub
//		return this.userdao.queryByUsername(username);
//	}
//
//	
//	public void saveUser(User user) {
//		// TODO Auto-generated method stub
//		this.userdao.saveUser(user);
//		
//	}
//
//	
//	public void updateUser(User user) {
//		// TODO Auto-generated method stub
//		this.userdao.updateUser(user);
//		
//	}

}
