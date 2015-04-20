package com.pwweb.service;

import java.util.Date;

import com.pwweb.common.Constant;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.User;
import javax.persistence.Entity;

@Entity
public class RegisterService {

//	private BaseDAO userDAO = new BaseDAO(); // 用户DAO接口引用

	public String Register(String name, Integer gender, String password,
			String phone,String avatar, Date createTime, Date lastUse, String deviceId) {
		
		BaseDAO userDAO = new BaseDAO();
		User user = new User();
		user.setUid("2");
		user.setName(name);
		user.setGender(gender);
		user.setPassword(password);
		user.setPhone(phone);
		user.setAvatar(avatar);
		user.setCreateTime(createTime);
		user.setLastUse(lastUse);
		user.setDeviceId(deviceId);
		
		try {
			userDAO.saveObject(user);
		} catch (Exception e) {
			e.printStackTrace();
			return Constant.FAILURE;
		}
		return Constant.SUCCESS;

	}
}
