package com.pwweb.service.Imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
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
 * ������װ
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
	 * ������װ
	 * @param userId
	 * @param img
	 * @param weather
	 * @param ocassion
	 * @param listener
	 * @return
	 */
	public String addSuit(String userId,String img,String thumb,int weather,int ocassion,String clothes,String description,int isLike,DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		Date date = new Date(System.currentTimeMillis());
		String id = Utils.generateUUid();
		Suit suit = new Suit(id,userId,img,clothes,weather,ocassion,date,date,description,isLike,thumb);
		System.out.println("start");
		System.out.println("suit:"+suit.getImg());
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
	 * ɾ����װ�����ǲ�ɾ������װ�������ķ�װ
	 * @param id
	 * @param listener
	 */
	/**Ҫע����delete suit��ͬʱҪɾ��clothes��Ӧ��id*/
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
	 * ������װ�������볡����Ϣ
	 * @param id
	 * @param weather
	 * @param occasion
	 * @param listener
	 */
	public void updateSuit(String id,int weather,int occasion,String description,DataBaseListener<Suit> listener) {

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
		
		if (description == null) {
			s.setDescription(s.getDescription());
		} else {
			s.setDescription(description);
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
	 * ͨ����װ��id����ѯ����װ����Ϣ
	 * @param id
	 * @param listener
	 */
	public void QuerySuitById(String id,DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO queryByIdDAO = new BaseDAO();
		
		try{
			Suit s = (Suit)queryByIdDAO.findObjectById(Suit.class, id);
			Suit suit = new Suit(s.getId(),s.getUserId(),s.getImg(),s.getClothes(),s.getWeather(),s.getOccasion(),s.getCreateTime(),s.getLastEdit(),s.getDescription(),s.getIsLike(),s.getThumb());
			listener.onSuccess(suit);
		} catch (Exception e){
			e.printStackTrace();			
		}
		listener.onFinish();
	}
/**
 * ������������ֵ�����������
 * @param weather
 * @return
 */
	public String CheckWeather(int weather){
		String weatherW = null;
		switch(weather){
		case 20:weatherW = "��װ";break;
		case 30:weatherW = "��װ";break;
		case 15:weatherW = "��װ";break;
		case 10:weatherW = "��װ";break;
		}
		return weatherW;
	}
	
/**
 * ���ó��ϵ���ֵ������ĳ���
 * @param occasion
 * @return
 */
	public String CheckOccasion(int occasion){
		String occasionW = null;
		switch(occasion){
		case 1:occasionW = "��ѧ";break;
		case 2:occasionW = "���";break;
		case 3:occasionW = "����";break;
		case 4:occasionW = "party";break;
		case 5:occasionW = "Լ�� ";break;
		case 6:occasionW = "���� ";break;
		}
		return occasionW;
	}
/**
 * ��ѯ��ǰ�û����еĴ�����װ
 * @param userId
 * @param listener
 * @return
 */

	
	public String querySuitByUserId(String userId,int page,DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO querySuitByUserIdDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		ArrayList<Order> orders = new ArrayList<Order>();
		res.add(Restrictions.eq("userId", userId));
		orders.add(Order.desc("lastEdit"));

		try {

			List<Suit> suitsList = (List<Suit>) querySuitByUserIdDAO
					.findObjectByCriteria(Suit.class, res);
			ArrayList<Suit> suitShowList = new ArrayList<Suit>();
			if (page == 0) {
				for (int i = 0; i < suitsList.size(); i++) {
					suitShowList.add(suitsList.get(i));
				}
				listener.onSuccess((List<Suit>) suitShowList);
			} else if ((page * 20 <= suitsList.size())&&(page!=0)) {
				for (int i = (page - 1) * 20; i < page * 20; i++) {
					suitShowList.add(suitsList.get(i));
				}
				listener.onSuccess((List<Suit>) suitShowList);
			} else if (((page - 1) * 20 <= suitsList.size())
					&& (suitsList.size() <= page * 20)) {
				for (int i = (page - 1) * 20; i < suitsList.size(); i++) {
					suitShowList.add(suitsList.get(i));
				}
				listener.onSuccess((List<Suit>) suitShowList);
			} else if (page * 20 > suitsList.size()) {
				System.out.println("no more results");
				listener.onFailure("no more");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}
	/**
	 * ͨ���ؼ��ֲ�ѯ����
	 * @param keyWord
	 * @param page
	 * @param listener
	 * @return
	 */
	public String querySuitByKeyWord(String keyWord,int page, DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO querySuitBykeyWordDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		ArrayList<Order> orders = new ArrayList<Order>();
		res.add(Restrictions.disjunction()
				.add(Restrictions.like("description", keyWord,MatchMode.ANYWHERE))
				.add(Restrictions.like("description", keyWord,MatchMode.END))
				.add(Restrictions.like("description", keyWord,MatchMode.START)));
		orders.add(Order.desc("lastEdit"));
		try {
			List<Suit> suitsList = (List<Suit>) querySuitBykeyWordDAO
					.findObjectByCriteria(Suit.class, res);
			ArrayList<Suit> suitShowList = new ArrayList<Suit>();
			if (page == 0) {
				for (int i = 0; i < suitsList.size(); i++) {
					suitShowList.add(suitsList.get(i));
				}
				listener.onSuccess((List<Suit>) suitShowList);
			} else if ((page * 20 <= suitsList.size())&&(page!=0)) {
				for (int i = (page - 1) * 20; i < page * 20; i++) {
					suitShowList.add(suitsList.get(i));
				}
				listener.onSuccess((List<Suit>) suitShowList);
			} else if (((page - 1) * 20 <= suitsList.size())
					&& (suitsList.size() <= page * 20)) {
				for (int i = (page - 1) * 20; i < suitsList.size(); i++) {
					suitShowList.add(suitsList.get(i));
				}
				listener.onSuccess((List<Suit>) suitShowList);
			} else if (page * 20 > suitsList.size()) {
				System.out.println("no more results");
				listener.onFailure("no more");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}
	/**
	 * �ı��û��Դ����ϲ��
	 * @param id
	 * @param listener
	 */
	public void updateSuitIsLike(String id,DataBaseListener<Suit> listener) {
		listener.onStart();
		BaseDAO updateSuitIsLikeDAO = new BaseDAO();
		try{
		Suit suit = (Suit) updateSuitIsLikeDAO.findObjectById(Suit.class, id);
		if(suit.getIsLike() == 0){
			suit.setIsLike(1);
			updateSuitIsLikeDAO.updateObject(suit);
			listener.onSuccess(suit);
		}else if(suit.getIsLike() == 1){
			suit.setIsLike(0);
			updateSuitIsLikeDAO.updateObject(suit);
			listener.onSuccess(suit);
		}
		} catch (Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}
	
	public String mergeClothesId(List<Clothes> clothesList){
		String clothesIdTotal = null;
		for(int i = 0;i<clothesList.size();i++)
		{
			clothesIdTotal = clothesIdTotal + clothesList.get(i).getUuid() + "-";
		}
		return clothesIdTotal;
	}

	public void queryClothesBySuitId(String suitId,DataBaseListener<Clothes> listener){
		listener.onStart();
		BaseDAO queryDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.disjunction()
				.add(Restrictions.like("suits", suitId,MatchMode.ANYWHERE))
				.add(Restrictions.like("suits", suitId,MatchMode.END))
				.add(Restrictions.like("suits", suitId,MatchMode.START)));
		try{
			List<Clothes> clothesList = (List<Clothes>)queryDAO.findObjectByCriteria(Clothes.class, res);
			listener.onSuccess(clothesList);
		} catch (Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}
}
