package com.pwweb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.DataBaseListener;
import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.Suit;
import com.pwweb.service.Imp.ClothesServiceImp;
import com.pwweb.service.Imp.SuitServiceImp;


public class SuitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7355503326610945820L;

	private String id;
	private String userId;
	private String img;
	private String clothes;
	private Integer weather;
	private Integer occasion;
	private Date createTime;
	private Date lastEdit;

	private Suit suit;
	private SuitServiceImp suitServiceImp;
	private List<Suit> suitList;
	
	private HashMap<String, String> jsonData;
	private ArrayList<HashMap<String, Object>> arrayData;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getClothes() {
		return clothes;
	}
	public void setClothes(String clothes) {
		this.clothes = clothes;
	}
	public Integer getWeather() {
		return weather;
	}
	public void setWeather(Integer weather) {
		this.weather = weather;
	}
	public Integer getOccasion() {
		return occasion;
	}
	public void setOccasion(Integer occasion) {
		this.occasion = occasion;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastEdit() {
		return lastEdit;
	}
	public void setLastEdit(Date lastEdit) {
		this.lastEdit = lastEdit;
	}
	public HashMap<String, String> getJsonData() {
		return jsonData;
	}
	public void setJsonData(HashMap<String, String> jsonData) {
		this.jsonData = jsonData;
	}
	public ArrayList<HashMap<String, Object>> getArrayData() {
		return arrayData;
	}
	public void setArrayData(ArrayList<HashMap<String, Object>> arrayData) {
		this.arrayData = arrayData;
	}
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
	
	public String ActionDeleteSuit(){
		final SuitServiceImp ss = new SuitServiceImp();
		ss.deleteSuit(id,new DataBaseListener<Suit>(){
			public void onSuccess(Suit suit){
				if(suit != null){
					System.out.println("delete suit successfully");
				}
			}
		});
//		this.suitServiceImp.deleteSuit(suit);
		return SUCCESS;
	}	
	
	public String ActionUpdateSuit(Suit suit){
		this.suitServiceImp.updateSuit(suit);
		return SUCCESS;
	}
	
//	public String ActionSaveSuit(Suit suit){
//		this.suitServiceImp.saveSuit(suit);
//		return SUCCESS;
//	}
	
	public String ActionAddSuit(){
		jsonData = new HashMap<String,String>();
		final SuitServiceImp ss = new SuitServiceImp();
		ss.addSuit(img,weather,occasion,new DataBaseListener<Suit>(){
			public void onSuccess(Suit suit){
				if(suit!=null){
					jsonData.put("suit", suit.subJson());
				}
			}
		});
		return SUCCESS;
	}
//	
//	public String ActionFindAllSuit(){
//		suitList = this.suitService.findAllSuit();
//		return SUCCESS;
//	}
}
