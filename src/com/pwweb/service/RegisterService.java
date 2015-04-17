package com.pwweb.service;

import java.util.List;

import com.pwweb.common.Constant;
import com.pwweb.dao.BaseDAO;
import com.pwweb.model.User;
import javax.persistence.Entity;

@Entity
public class RegisterService {

	private BaseDAO userDAO = new BaseDAO(); // 用户DAO接口引用

	public String Register(String username, String password, int gender) {
		User user = new User();
		user.setName(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setId("2");
		try {
			userDAO.saveObject(user);
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.FAILURE;
		}
		return Constant.SUCCESS;

	}
}
