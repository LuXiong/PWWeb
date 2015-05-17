package com.pwweb.service.Imp;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pwweb.common.DataBaseListener;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.User;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;


@Entity
public class UserServiceImp{

	@ManyToOne
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

	public void updateUser(String id,String name,String avatar,String description,DataBaseListener<User>listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO updateDAO = new BaseDAO();
 
		User u = (User)updateDAO.findObjectById(User.class, id);
		if(name == null){
			u.setName(u.getName());
		}else{
			u.setName(name);
		}
		
		if(avatar == null){
			u.setAvatar(u.getAvatar());
		}else{
			u.setAvatar(avatar);
		}
		  
		Date date = new Date(System.currentTimeMillis());
	    u.setLastUse(date); 
	    u.setDescription(description);
		try {
			updateDAO.updateObject(u);
			listener.onSuccess(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
	}

    public void queryUserById(String id,DataBaseListener<User>listener){
    	listener.onStart();
    	BaseDAO queryDAO = new BaseDAO();
//    	ArrayList<Criterion> res = new ArrayList<Criterion>();
//    	res.add(Restrictions.eq("userId", id));
    	try{
    		User u = (User)queryDAO.findObjectById(User.class, id);
    		User user = new User(u.getUid(),u.getName(),u.getGender(),u.getPassword(),u.getPhone(),u.getAvatar(),u.getCreateTime(),u.getLastUse(),u.getDeviceId(),u.getDescription());
    		System.out.println("user:" + user.getName());
    		System.out.println("user:" + user.getPassword());
    		listener.onSuccess(user);
    	} catch(Exception e){
    		e.printStackTrace();
    	}
    	listener.onFinish();
    }

}
