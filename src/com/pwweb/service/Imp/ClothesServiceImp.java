package com.pwweb.service.Imp;

import java.util.List;

import com.pwweb.dao.ClothesDAO;
import com.pwweb.model.Clothes;
import com.pwweb.service.ClothesService;

public class ClothesServiceImp implements ClothesService {
	
	public ClothesDAO clothesdao;
	
	

	public ClothesDAO getClothesdao() {
		return clothesdao;
	}

	public void setClothesdao(ClothesDAO clothesdao) {
		this.clothesdao = clothesdao;
	}

	@Override
	public void deleteClothes(Clothes clothes) {
		// TODO Auto-generated method stub
		this.clothesdao.deleteClothes(clothes);
		
	}

	@Override
	public List<Clothes> findAllClothes() {
		// TODO Auto-generated method stub
		return this.clothesdao.findAllClothes();
	}

	@Override
	public void saveClothes(Clothes clothes) {
		// TODO Auto-generated method stub
		this.clothesdao.saveClothes(clothes);
	}

	@Override
	public void updateClothes(Clothes clothes) {
		// TODO Auto-generated method stub
        this.clothesdao.updateClothes(clothes);		
	}

}
