package com.pwweb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.pojo.Suit;
import com.pwweb.service.Imp.SuitServiceImp;


public class SuitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7355503326610945820L;

	private Suit suit;
	private SuitServiceImp suitServiceImp;
	private List<Suit> suitList;
	
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public SuitServiceImp getSuitServiceImp() {
		return suitServiceImp;
	}
	public void setSuitServiceImp(SuitServiceImp suitServiceImp) {
		this.suitServiceImp = suitServiceImp;
	}
	public List<Suit> getSuitList() {
		return suitList;
	}
	public void setSuitList(List<Suit> suitList) {
		this.suitList = suitList;
	}
	
	public String ActionDeleteSuit(Suit suit){
		this.suitServiceImp.deleteSuit(suit);
		return SUCCESS;
	}	
	
	public String ActionUpdateSuit(Suit suit){
		this.suitServiceImp.updateSuit(suit);
		return SUCCESS;
	}
	
	public String ActionSaveSuit(Suit suit){
		this.suitServiceImp.saveSuit(suit);
		return SUCCESS;
	}
//	
//	public String ActionFindAllSuit(){
//		suitList = this.suitService.findAllSuit();
//		return SUCCESS;
//	}
}
