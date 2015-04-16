package com.pwweb.dao;

import java.util.List;

import com.pwweb.model.Clothes;
import com.pwweb.model.User;

public interface ClothesDAO {
	
	public void saveClothes(Clothes clothes);      //�����װ  
    public void deleteClothes(Clothes clothes);              //ɾ����װ
    public void updateClothes(Clothes clothes);              //�޸ķ�װ����
    public List<Clothes> findAllClothes();
}
