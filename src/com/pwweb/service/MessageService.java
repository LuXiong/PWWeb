package com.pwweb.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseListener;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.Message;

@Entity
public class MessageService {
	@SuppressWarnings("unchecked")
	public String saveMessage(String topic, String content,
			DataBaseListener<Message> listener) {
		listener.onStart();
		BaseDAO messageDao = new BaseDAO();
		Message msg = new Message(topic, content, new Date(
				System.currentTimeMillis()));
		try {
			messageDao.saveObject(msg);
			listener.onSuccess(msg);

		} catch (Exception e) {
			e.printStackTrace();
			listener.onFailure("can not create message");
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String getMessages(DataBaseListener<Message> listener) {
		try {
			BaseDAO messageDao = new BaseDAO();
			ArrayList<Criterion> res = new ArrayList<Criterion>();
			res.add(Restrictions.eq("topic", "PW"));
			List<Message> messages = (List<Message>) messageDao
					.findObjectByCriteria(Message.class, res);
			if (messages != null) {
				if (messages.size() >= 1) {
					listener.onSuccess(messages.get(0));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Constant.SUCCESS;
	}
}
