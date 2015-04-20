package com.pwweb.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.pojo.Clothes;
import com.pwweb.service.Imp.ClothesServiceImp;

public class ClothesAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8690763859731566034L;

	private Clothes clothes;
	private ClothesServiceImp clothesServiceImp;
	private List<Clothes> clothesList;
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	
	public List<Clothes> getClothesList() {
		return clothesList;
	}
	public void setClothesList(List<Clothes> clothesList) {
		this.clothesList = clothesList;
	}
	
	
	public ClothesServiceImp getClothesServiceImp() {
		return clothesServiceImp;
	}
	public void setClothesServiceImp(ClothesServiceImp clothesServiceImp) {
		this.clothesServiceImp = clothesServiceImp;
	}
	public String ActionDeleteClothes(Clothes clothes){
		this.clothesServiceImp.deleteClothes(clothes);
		return SUCCESS;
	}
	
	public String ActionUpdateClothes(Clothes clothes){
		this.clothesServiceImp.updateClothes(clothes);
		return SUCCESS;
	}
	
	public String ActionSaveClothes(Clothes clothes){
		this.clothesServiceImp.saveClothes(clothes);
		return SUCCESS;
	}
	
//	public String ActionFindAllClothes(){
//		clothesList = this.clothesService.findAllClothes();
//		return SUCCESS;
//	}
 }

