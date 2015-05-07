package com.pwweb.service.Imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseListener;
import com.pwweb.common.Utils;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.Suit;

@Entity
public class SuitServiceImp{
	@ManyToOne
	public BaseDAO suitDAO = new BaseDAO();
/**
 * 保存套装
 * @param suit
 */
	public void saveSuit(Suit suit) {
		// TODO Auto-generated method stub
		try {
			suitDAO.saveObject(suit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 增加套装
	 * @param userId
	 * @param img
	 * @param weather
	 * @param ocassion
	 * @param listener
	 * @return
	 */
	public String addSuit(String userId,String img,int weather,int ocassion,String description,DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		Date date = new Date(System.currentTimeMillis());
		String id = Utils.generateUUid();
		String clothes= "123";
		Suit suit = new Suit(id,userId,img,clothes,weather,ocassion,date,date,description);
		
		try{
			addDAO.saveObject(suit);
			listener.onSuccess(suit);
		}catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}
	/**
	 * 删除套装，但是不删除该套装所包含的服装
	 * @param id
	 * @param listener
	 */
	public void deleteSuit(String id,DataBaseListener<Suit> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO deleteDAO = new BaseDAO();
		try {
			deleteDAO.deleteObjectById(Suit.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
	}

	/**
	 * 更新套装的天气与场合信息
	 * @param id
	 * @param weather
	 * @param occasion
	 * @param listener
	 */
	public void updateSuit(String id,int weather,int occasion,DataBaseListener<Suit> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO updateDAO = new BaseDAO();
		Suit s = (Suit) updateDAO.findObjectById(Suit.class, id);

		if (weather == 0) {
			s.setWeather(s.getWeather());
		} else {
			s.setWeather(weather);
		}

		if (occasion == 0) {
			s.setOccasion(s.getOccasion());
		} else {
			s.setOccasion(occasion);
		}
		Date date = new Date(System.currentTimeMillis());
		s.setLastEdit(date);

		try {
			updateDAO.updateObject(s);
			listener.onSuccess(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
	}
	/**
	 * 通过套装的id来查询该套装的信息
	 * @param id
	 * @param listener
	 */
	public void QuerySuitById(String id,DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO queryByIdDAO = new BaseDAO();
		
		try{
			Suit s = (Suit)queryByIdDAO.findObjectById(Suit.class, id);
			Suit suit = new Suit(s.getId(),s.getUserId(),s.getImg(),s.getClothes(),s.getWeather(),s.getOccasion(),s.getCreateTime(),s.getLastEdit(),s.getDescription());
			listener.onSuccess(suit);
		} catch (Exception e){
			e.printStackTrace();			
		}
		listener.onFinish();
	}
/**
 * 检查该天气的数值所代表的天气
 * @param weather
 * @return
 */
	public String CheckWeather(int weather){
		String weatherW = null;
		switch(weather){
		case 1:;break;
		}
		return weatherW;
	}
	
/**
 * 检查该场合的数值所代表的场合
 * @param occasion
 * @return
 */
	public String CheckOccasion(int occasion){
		String occasionW = null;
		switch(occasion){
		case 1:;break;
		}
		return occasionW;
	}
/**
 * 查询当前用户所有的搭配套装
 * @param userId
 * @param listener
 * @return
 */
	
//	public List<Suit> findAllSuit(String userId,DataBaseListener<Suit> listener) {
//		// TODO Auto-generated method stub
//		listener.onStart();
//		BaseDAO findAllDAO = new BaseDAO();
//		List<Suit> suitList = new ArrayList<Suit>();
//		try{
//			
//		} catch(Exception e){
//			e.printStackTrace();
//		}
//		listener.onFinish();
//		return suitList;
//	}
	
	public String querySuitByUserId(String userId,int page,DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO querySuitByUserIdDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.eq("userId", userId));

		try{

			List<Suit> suitsList = (List<Suit>) querySuitByUserIdDAO.findObjectByCriteria(
					Suit.class, res);
			page = suitsList.size()/20;
			if (suitsList.size() <= page*20) {
					listener.onSuccess(suitsList);
//				listener.onSuccess((ArrayList<Suit>)suits);
			} else {
				listener.onFailure("not exist");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}
	
	public String querySuitByKeyWord(String keyWord,int page, DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO querySuitBykeyWordDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.like("description", keyWord,MatchMode.ANYWHERE));
		try{
			List<Suit> suitsList = (List<Suit>) querySuitBykeyWordDAO.findObjectByCriteria(
					Suit.class, res);
			page = suitsList.size()/20;
			if (suitsList.size() <= page*20) {
					listener.onSuccess(suitsList);
		
//				listener.onSuccess((ArrayList<Suit>)suits);
			} else {
				listener.onFailure("not exist");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}

}
