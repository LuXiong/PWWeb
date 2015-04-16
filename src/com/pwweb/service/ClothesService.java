package com.pwweb.service;

import java.util.List;

import com.pwweb.model.Clothes;

public interface ClothesService {

	public void saveClothes(Clothes clothes);      //�����װ  
    public void deleteClothes(Clothes clothes);              //ɾ����װ
    public void updateClothes(Clothes clothes);              //�޸ķ�װ����
    public List<Clothes> findAllClothes();
}
