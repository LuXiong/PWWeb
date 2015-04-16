package com.pwweb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.model.Suit;
import com.pwweb.service.SuitService;

public class SuitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7355503326610945820L;

	private Suit suit;
	private SuitService suitService;
	private List<Suit> suitList;
	
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}
	public SuitService getSuitService() {
		return suitService;
	}
	public void setSuitService(SuitService suitService) {
		this.suitService = suitService;
	}
	public List<Suit> getSuitList() {
		return suitList;
	}
	public void setSuitList(List<Suit> suitList) {
		this.suitList = suitList;
	}
	
	public String ActionDeleteSuit(Suit suit){
		this.suitService.deleteSuit(suit);
		return SUCCESS;
	}	
	
	public String ActionUpdateSuit(Suit suit){
		this.suitService.updateSuit(suit);
		return SUCCESS;
	}
	
	public String ActionSaveSuit(Suit suit){
		this.suitService.saveSuit(suit);
		return SUCCESS;
	}
	
	public String ActionFindAllSuit(){
		suitList = this.suitService.findAllSuit();
		return SUCCESS;
	}
}
