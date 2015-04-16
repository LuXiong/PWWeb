package com.pwweb.dao;

import java.util.List;

import com.pwweb.model.Clothes;
import com.pwweb.model.User;

public interface ClothesDAO {
	
	public void saveClothes(Clothes clothes);      //保存服装  
    public void deleteClothes(Clothes clothes);              //删除服装
    public void updateClothes(Clothes clothes);              //修改服装资料
    public List<Clothes> findAllClothes();
}
