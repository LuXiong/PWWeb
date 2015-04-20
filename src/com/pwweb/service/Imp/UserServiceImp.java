package com.pwweb.service.Imp;


import java.util.List;
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

	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			userDAO.deleteObjectById(userDAO.getClass(), user.getUid());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			userDAO.updateObject(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
