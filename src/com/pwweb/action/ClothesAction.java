package com.pwweb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.model.Clothes;
import com.pwweb.service.ClothesService;

public class ClothesAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8690763859731566034L;

	private Clothes clothes;
	private ClothesService clothesService;
	private List<Clothes> clothesList;
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	public ClothesService getClothesService() {
		return clothesService;
	}
	public void setClothesService(ClothesService clothesService) {
		this.clothesService = clothesService;
	}
	public List<Clothes> getClothesList() {
		return clothesList;
	}
	public void setClothesList(List<Clothes> clothesList) {
		this.clothesList = clothesList;
	}
	
	public String ActionDeleteClothes(Clothes clothes){
		this.clothesService.deleteClothes(clothes);
		return SUCCESS;
	}
	
	public String ActionUpdateClothes(Clothes clothes){
		this.clothesService.updateClothes(clothes);
		return SUCCESS;
	}
	
	public String ActionSaveClothes(Clothes clothes){
		this.clothesService.saveClothes(clothes);
		return SUCCESS;
	}
	
	public String ActionFindAllClothes(){
		clothesList = this.clothesService.findAllClothes();
		return SUCCESS;
	}
}

