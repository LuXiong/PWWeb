package com.pwweb.service.Imp;

import java.util.List;

import com.pwweb.pojo.Clothes;
import com.pwweb.dao.BaseDAO;

public class ClothesServiceImp {
	
	public BaseDAO clothesdao;

	public void saveClothes(Clothes clothes) {
		// TODO Auto-generated method stub
		try {
			clothesdao.saveObject(clothes);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteClothes(Clothes clothes) {
		// TODO Auto-generated method stub
		try {
			clothesdao.deleteObjectById(clothes.getClass(), clothes.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateClothes(Clothes clothes) {
		// TODO Auto-generated method stub
		try {
			clothesdao.updateObject(clothes);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
