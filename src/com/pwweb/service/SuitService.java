package com.pwweb.service;

import java.util.List;

import com.pwweb.model.Suit;

public interface SuitService {


	public void saveSuit(Suit suit);      //������� 
    public void deleteSuit(Suit suit);              //ɾ������
    public void updateSuit(Suit suit);              //�޸Ĵ�������
    public List<Suit> findAllSuit();
}
