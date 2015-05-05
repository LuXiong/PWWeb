package com.pwweb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.DataBaseListener;
import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.Token;
import com.pwweb.pojo.User;
import com.pwweb.service.PassService;
import com.pwweb.service.Imp.ClothesServiceImp;

public class ClothesAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8690763859731566034L;

	private String id;
	private String userId;
	private Integer color;
	private Integer category;
	private Integer exponent;
	private Date createTime;
	private Date lastEdit;
	private String img;
	private String suits;
	
	private Clothes clothes;
	private ClothesServiceImp clothesServiceImp;
	private List<Clothes> clothesList;
	
	private HashMap<String, String> jsonData;
	
	private HashMap<String,Object> jsonResult;
	private ArrayList<HashMap<String, Object>> arrayData;
	
	
	
	public HashMap<String, Object> getJsonResult() {
		return jsonResult;
	}
	public void setJsonResult(HashMap<String, Object> jsonResult) {
		this.jsonResult = jsonResult;
	}
	public HashMap<String, String> getJsonData(){
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
	public Integer getColor() {
		return color;
	}
	public void setColor(Integer color) {
		this.color = color;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public Integer getExponent() {
		return exponent;
	}
	public void setExponent(Integer exponent) {
		this.exponent = exponent;
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
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getSuits() {
		return suits;
	}
	public void setSuits(String suits) {
		this.suits = suits;
	}
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
//	public String ActionDeleteClothes(Clothes clothes){
//		this.clothesServiceImp.deleteClothes(clothes);
//		return SUCCESS;
//	}
	
	public String ActionDeleteClothes(){
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.deleteClothes(id,
				new DataBaseListener<Clothes>() {
			public void onSuccess(Clothes clothes) {
				if (clothes != null) {
					System.out.println("delete clothes successfully");			
								}
							}
			});
		return SUCCESS;
	}
	
	public String ActionUpdateClothes(){
		jsonData =  new HashMap<String,String>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.updateClothes(id,color,category,img,new DataBaseListener<Clothes>(){
			public void onSuccess(Clothes clothes){
				if(clothes!=null){
					jsonData.put("clothes",clothes.subJson());
				}
			}
		});
		
		return SUCCESS;
	}
	
	public String ActionAddClothes(){
		jsonData = new HashMap<String,String>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.addClothes(userId,color,category,img,new DataBaseListener<Clothes>(){
			public void onSuccess(Clothes clothes){
				if(clothes!=null){
					jsonData.put("clothes", clothes.subJson());
				}
			}
		});
		return SUCCESS;
	}
	
	/**
	 * 该函数使用id来查询服装，id是唯一的
	 * @return
	 */
	public String ActionQueryClothesById(){
		jsonData = new HashMap<String,String>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.queryClothesById(id,new DataBaseListener<Clothes>(){
			public void onSuccess(Clothes clothes){
				if(clothes!=null){
					jsonData.put("clothes", clothes.subJson());
				}
			}
		});
		return SUCCESS;
	}
	
	public String ActionQueryClothesByPage(){
		arrayData = new ArrayList<HashMap<String,Object>>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.queryClothesById(id,new DataBaseListener<Clothes>(){
			public void onSuccess(Clothes clothes){
				if(clothes!=null){
					jsonData.put("clothes", clothes.subJson());
				}
			}
		});
		arrayData.add(jsonResult);
//		cs.queryClothesByPage();
		return SUCCESS;
	}
	
	public String ActionFindAllClothes(){
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.findAllClothes(userId,new DataBaseListener<Clothes>(){
			public void onSuccess(Clothes clothes){
				if(clothes != null){
					jsonResult.put("clothes", clothes.subJson());
//					clothesList.add(index, element);
				}
			}
		});
//		clothesList.addAll(jsonResult);
		return SUCCESS;
	}
 }

