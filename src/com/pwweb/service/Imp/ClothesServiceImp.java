package com.pwweb.service.Imp;

import java.util.Date;
import java.util.List;

import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.Token;
import com.pwweb.pojo.User;
import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseListener;
import com.pwweb.common.Utils;
import com.pwweb.dao.BaseDAO;

public class ClothesServiceImp {
	

	public String addClothes(int color,int category,String img,DataBaseListener<Clothes> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		Date date = new Date(System.currentTimeMillis());
		String id = Utils.generateUUid();
		String userId = id;
		String suits = "12";  //后期进行联系
		int exponent = 1;
		Clothes clothes = new Clothes(id, userId, color, category,
				exponent, date, date, img,
				suits);
//		Token token = new Token(Utils.generateUUid(), userId, date, color,
//				category, exponent,date,date, img );
		try {
			addDAO.saveObject(clothes);
			listener.onSuccess(clothes);
//			clothesdao.saveObject(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}

	public void deleteClothes(String clothesId,DataBaseListener<Clothes> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO deleteDAO = new BaseDAO();
		try {
			deleteDAO.deleteObjectById(Clothes.class, clothesId);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
	}

	public void updateClothes(Clothes clothes) {
		// TODO Auto-generated method stub
        BaseDAO updateDAO = new BaseDAO();
		try {
			updateDAO.updateObject(clothes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void queryClothesById(String id, DataBaseListener<Clothes> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO queryByIdDAO = new BaseDAO();
		try{
			queryByIdDAO.findObjectById(Clothes.class, id);
			System.out.println("find clothes successfully");
		}catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
		
	}

//	@Override
//	public List<Clothes> findAllClothes() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
	

//	public ClothesDAO getClothesdao() {
//		return clothesdao;
//	}
//
//	public void setClothesdao(ClothesDAO clothesdao) {
//		this.clothesdao = clothesdao;
//	}
//
//	@Override
//	public void deleteClothes(Clothes clothes) {
//		BaseDAO dao = new BaseDAO();
//		this.clothesdao.deleteClothes(clothes);
//		
//	}
//
//	@Override
//	public List<Clothes> findAllClothes() {
//		// TODO Auto-generated method stub
//		return this.clothesdao.findAllClothes();
//	}
//
//	@Override
//	public void saveClothes(Clothes clothes) {
//		// TODO Auto-generated method stub
//		this.clothesdao.saveClothes(clothes);
//	}
//
//	@Override
//	public void updateClothes(Clothes clothes) {
//		// TODO Auto-generated method stub
//        this.clothesdao.updateClothes(clothes);		
//	}

}
