package com.pwweb.service.Imp;

import java.util.List;

import com.pwweb.dao.BaseDAO;
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

	public void deleteSuit(Suit suit) {
		// TODO Auto-generated method stub
		try {
			suitDAO.deleteObjectById(suit.getClass(), suit.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
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
