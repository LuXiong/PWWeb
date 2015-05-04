package com.pwweb.service.Imp;

import java.util.Date;
import java.util.List;

import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseListener;
import com.pwweb.common.Utils;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.Suit;

public class SuitServiceImp{
	public BaseDAO suitDAO = new BaseDAO();

	public void saveSuit(Suit suit) {
		// TODO Auto-generated method stub
		try {
			suitDAO.saveObject(suit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public String addSuit(String img,int weather,int ocassion,DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		Date date = new Date(System.currentTimeMillis());
		String id = Utils.generateUUid();
		String userId = id;
		String clothes= "123";
		Suit suit = new Suit(id,userId,img,clothes,weather,ocassion,date,date);
		
		try{
			addDAO.saveObject(suit);
			listener.onSuccess(suit);
		}catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}
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

	public void updateSuit(Suit suit) {
		// TODO Auto-generated method stub
		try {
			suitDAO.updateObject(suit);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	@Override
//	public List<Suit> findAllSuit() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	// public SuitDAO suitdao;
	//
	//
	// public SuitDAO getSuitdao() {
	// return suitdao;
	// }
	//
	// public void setSuitdao(SuitDAO suitdao) {
	// this.suitdao = suitdao;
	// }
	//
	// @Override
	// public void deleteSuit(Suit suit) {
	// // TODO Auto-generated method stub
	// this.suitdao.deleteSuit(suit);
	// }
	//
	// @Override
	// public List<Suit> findAllSuit() {
	// // TODO Auto-generated method stub
	// return this.suitdao.findAllSuit();
	// }
	//
	// @Override
	// public void saveSuit(Suit suit) {
	// // TODO Auto-generated method stub
	// this.suitdao.saveSuit(suit);
	// }
	//
	// @Override
	// public void updateSuit(Suit suit) {
	// // TODO Auto-generated method stub
	// this.suitdao.updateSuit(suit);
	// }

}
