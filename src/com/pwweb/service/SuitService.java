package com.pwweb.service;

import java.util.List;

import com.pwweb.pojo.Suit;


public interface SuitService {


	public void saveSuit(Suit suit);      //±£´æ´îÅä 
    public void deleteSuit(Suit suit);              //É¾³ı´îÅä
    public void updateSuit(Suit suit);              //ĞŞ¸Ä´îÅä×ÊÁÏ
    public List<Suit> findAllSuit();
}
