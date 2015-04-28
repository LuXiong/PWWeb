package com.pwweb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseListener;
import com.pwweb.common.Utils;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.Token;
import com.pwweb.pojo.User;

@Entity
public class PassService {

	@SuppressWarnings("unchecked")
	public String login(String phone, String password,
			DataBaseListener<User> listener) {
		listener.onStart();
		BaseDAO userdao = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.eq("phone", phone));
		res.add(Restrictions.eq("password", password));
		List<User> users = (List<User>) userdao.findObjectByCriteria(
				User.class, res);
		if (users.size() == 1) {
			listener.onSuccess(users.get(0));
		} else {
			listener.onFailure("not exist");
		}
		listener.onFinish();
		return Constant.SUCCESS;

	}

	public String regist(String name, Integer gender, String password,
			String phone, String avatar, String deviceId, String code,
			DataBaseListener<User> listener) {
		listener.onStart();
		if (getUser(phone) == null) {
			BaseDAO registDAO = new BaseDAO();
			Date date = new Date(System.currentTimeMillis());
			String uid = Utils.generateUUid();
			User user = new User(uid, name, gender, password, phone, avatar,
					date, date, deviceId);
			Token token = new Token(Utils.generateUUid(), uid, date, password,
					phone, date, deviceId);

			try {
				registDAO.saveObject(user);
				registDAO.saveObject(token);
				listener.onSuccess(user);
			} catch (Exception e) {
				e.printStackTrace();
				listener.onFailure("can not save user");
				return Constant.FAILURE;
			}
			listener.onFinish();
		} else {
			listener.onFailure("user exist");
		}

		return Constant.SUCCESS;

	}

	@SuppressWarnings("unchecked")
	public String getToken(String phone, String password,
			DataBaseListener<Token> listener) {
		listener.onStart();
		BaseDAO tokenDao = new BaseDAO();
		try {
			ArrayList<Criterion> res = new ArrayList<Criterion>();
			res.add(Restrictions.eq("userPhone", phone));
			res.add(Restrictions.eq("userPassword", password));
			List<Token> tokens = (List<Token>) tokenDao.findObjectByCriteria(
					Token.class, res);
			if (tokens.size() == 1) {
				listener.onSuccess(tokens.get(0));
			} else {
				listener.onFailure("cannot get token");
			}
		} catch (Exception e) {
			e.printStackTrace();
			listener.onFailure("database error");
			return Constant.FAILURE;
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public User getUser(String phone) {
		BaseDAO userDao = new BaseDAO();
		User user = null;
		try {
			ArrayList<Criterion> res = new ArrayList<Criterion>();
			res.add(Restrictions.eq("phone", phone));
			List<User> users = (List<User>) userDao.findObjectByCriteria(
					User.class, res);
			if (users.size() == 1) {
				user = users.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return user;
	}
}
