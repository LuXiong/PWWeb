package com.pwweb.service.Imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.pwweb.common.DataBaseListener;
import com.pwweb.common.Utils;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.Comment;
import com.pwweb.pojo.Share;
import com.pwweb.pojo.User;
import com.pwweb.pojo.UserShare;
import com.pwweb.pojo.UserSuit;

public class ShareServiceImp {

	public void addShare(String userId, String suitId, String content,
			int isPublic, DataBaseListener<Share> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		Date date = new Date(System.currentTimeMillis());
		String id =  Utils.generateUUid();
		
		Share share = new Share(id,userId,suitId,content,date,isPublic);
		try{
			if(addDAO.findObjectById(User.class, userId)!=null)
			{
			addDAO.saveObject(share);
			listener.onSuccess(share);
			}else {
				listener.onFailure("the user does not exist");
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

	public void deleteShare(String id, DataBaseListener<Share> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO deleteDAO = new BaseDAO();
		try{
			deleteDAO.deleteObjectById(Share.class, id);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

	public void updateCurrentShare(long currentTime,DataBaseListener<Share> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO updateDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("createTime"));
//		res.add(Restrictions.le("createTime", ));
		res.add(Restrictions.eq("isPublic", 1));
		if(currentTime == 0){
			currentTime = System.currentTimeMillis();
		}
		try{
			List<Share> shareList =(List<Share>) updateDAO.findObjectByCriteria(Share.class,res,orders);
			ArrayList<Share> shareShowList = new ArrayList<Share>();
			if(shareList.size()>=20){
			for(int i = 0;i<20;i++){
				if(shareList.get(i).getCreateTime().getTime()<=currentTime)
				{
				shareShowList.add(shareList.get(i));
				}
			}
			listener.onSuccess((List<Share>) shareShowList);
			}else{
				for(int i = 0;i<shareList.size();i++){
					if(shareList.get(i).getCreateTime().getTime()<=currentTime)
					{
					shareShowList.add(shareList.get(i));
					}
				}
				listener.onSuccess((List<Share>) shareShowList);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

	public void addComment(String commentShareId, String commentUserId,
			String commentContent, DataBaseListener<Comment> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		Date date = new Date(System.currentTimeMillis());
		String id = Utils.generateUUid();
		
		Comment comment = new Comment(id,commentShareId,commentUserId,date,commentContent);
		System.out.println("content:" + commentContent);
		try{
			addDAO.saveObject(comment);
			listener.onSuccess(comment);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

	public void getComment(String commentShareId,
			DataBaseListener<Comment> listener) {
		// TODO Auto-generated method stub
	    listener.onStart();
	    BaseDAO getDAO = new BaseDAO();
	    ArrayList<Criterion> res = new ArrayList<Criterion>();
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("createTime"));
		res.add(Restrictions.eq("shareId", commentShareId));
		try{
			List<Comment> commentList = (List<Comment>) getDAO.findObjectByCriteria(Comment.class, res, orders);
			listener.onSuccess(commentList);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 通过userId查询该用户的所有share以及每个share下所对应的comment
	 * @param userId
	 * @param listener
	 */

	public void queryShareByUserId(String userId,
			DataBaseListener<Share> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO queryDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.eq("userId", userId));
		try{
			List<Share> shareList = (List<Share>)queryDAO.findObjectByCriteria(Share.class, res);
			listener.onSuccess(shareList);
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

	public void getIsLike(String uShareShareId,
			DataBaseListener<UserShare> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO getDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.eq("shareId", uShareShareId));
		try{
			List<UserShare> userShareList = (List<UserShare>)getDAO.findObjectByCriteria(UserShare.class, res);
			ArrayList<UserShare> shareShowList = new ArrayList<UserShare>();
			for(int i = 0;i<userShareList.size();i++){
				if(userShareList.get(i).getIsLike()==1){
					shareShowList.add(userShareList.get(i));
				}
			}
			listener.onSuccess((List<UserShare>)shareShowList);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

	public void getIsCollect(String uSuitSuitId,
			DataBaseListener<UserSuit> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO getDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.eq("suitId", uSuitSuitId));
		try{
			List<UserSuit> userSuitList = (List<UserSuit>)getDAO.findObjectByCriteria(UserSuit.class, res);
			ArrayList<UserSuit> suitShowList = new ArrayList<UserSuit>();
			for(int i =0;i<userSuitList.size();i++){
				if(userSuitList.get(i).getIsCollect()==1){
					suitShowList.add(userSuitList.get(i));
				}
			}
			listener.onSuccess((List<UserSuit>)suitShowList);
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

	public void addLike(String uShareUserId, String uShareShareId,
			int isLike, DataBaseListener<UserShare> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		String id = Utils.generateUUid();
		System.out.println("id:" + id);
		System.out.println("uShareUserId:" + uShareUserId);
		System.out.println("uShareShareId:" + uShareShareId);
		System.out.println("isLike:" + isLike);
		UserShare userShare = new UserShare(id,uShareUserId,uShareShareId,isLike);
		
		try{
			addDAO.saveObject(userShare);
			listener.onSuccess(userShare);		
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

	public void addCollect(String uSuitUserId, String uSuitSuitId,
			int isCollect, DataBaseListener<UserSuit> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		String id = Utils.generateUUid();
		System.out.println("id:" + id);
		System.out.println("uSuitUserId:" + uSuitUserId);
		System.out.println("uSuitSuitId:" + uSuitSuitId);
		System.out.println("isCollect:" + isCollect);
		UserSuit userSuit = new UserSuit(id,uSuitUserId,uSuitSuitId,isCollect);
		
		try{
			addDAO.saveObject(userSuit);
			listener.onSuccess(userSuit);
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

}
