package com.pwweb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.DataBaseListener;
import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.ClothesType;
import com.pwweb.service.Imp.ClothesServiceImp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class ClothesAction extends ActionSupport{

	/**
	 * 
	 */
	@Id
	@GeneratedValue
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
	private String description;
	
	public int page;
	public int pageIndex;
	public String keyWord;
	
	@ManyToOne
	private Clothes clothes;
	@ManyToOne
	private ClothesServiceImp clothesServiceImp;
//	@OneToMany
//	private List<Clothes> clothesList;
//	private ArrayList<ClothesType> clothesTypeList;
//	
//	private ClothesType clothesType;
//	
	private HashMap<String, String> jsonData;
	private ArrayList<HashMap<String, String>> arrayData;
//	private HashMap<String,Object> jsonResult;
//
//	private ArrayList<ClothesType> arrayDataT;
	
	
	
	public int getPageIndex() {
		return pageIndex;
	}
	public ArrayList<HashMap<String, String>> getArrayData() {
		return arrayData;
	}
	public void setArrayData(ArrayList<HashMap<String, String>> arrayData) {
		this.arrayData = arrayData;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
//	public ArrayList<ClothesType> getArrayDataT() {
//		return arrayDataT;
//	}
//	public void setArrayDataT(ArrayList<ClothesType> arrayDataT) {
//		this.arrayDataT = arrayDataT;
//	}
//	public ArrayList<ClothesType> getClothesTypeList() {
//		return clothesTypeList;
//	}
//	public void setClothesTypeList(ArrayList<ClothesType> clothesTypeList) {
//		this.clothesTypeList = clothesTypeList;
//	}
//	public ClothesType getClothesType() {
//		return clothesType;
//	}
//	public void setClothesType(ClothesType clothesType) {
//		this.clothesType = clothesType;
//	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
//	public HashMap<String, Object> getJsonResult() {
//		return jsonResult;
//	}
//	public void setJsonResult(HashMap<String, Object> jsonResult) {
//		this.jsonResult = jsonResult;
//	}
	public HashMap<String, String> getJsonData(){
		return jsonData;
	}
	public void setJsonData(HashMap<String, String> jsonData) {
		this.jsonData = jsonData;
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
	
//	public List<Clothes> getClothesList() {
//		return clothesList;
//	}
//	public void setClothesList(List<Clothes> clothesList) {
//		this.clothesList = clothesList;
//	}
	
	
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
		cs.addClothes(userId,color,category,img,description,new DataBaseListener<Clothes>(){
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
	
//	public String ActionQueryClothesByPage(){
//		arrayData = new ArrayList<HashMap<String,Object>>();
//		final ClothesServiceImp cs = new ClothesServiceImp();
//		cs.queryClothesById(id,new DataBaseListener<Clothes>(){
//			public void onSuccess(Clothes clothes){
//				if(clothes!=null){
//					jsonData.put("clothes", clothes.subJson());
//				}
//			}
//		});
//		arrayData.add(jsonResult);
//		cs.queryClothesByPage();
//		return SUCCESS;
//	}
	
//	public String ActionFindAllClothes(){
//		final ClothesServiceImp cs = new ClothesServiceImp();
//		cs.findAllClothes(userId,new DataBaseListener<Clothes>(){
//			public void onSuccess(Clothes clothes){
//				if(clothes != null){
//					jsonResult.put("clothes", clothes.subJson());
////					clothesList.add(index, element);
//				}
//			}
//		});
//		clothesList.addAll(jsonResult);
//		return SUCCESS;
//	}
	
//	public String ActionQueryClothesByUserId(){
//		final ClothesServiceImp cs = new ClothesServiceImp();
//		cs.queryClothesByUserId(userId, page, new DataBaseListener<Clothes>(){
//			public void onSuccess(List<Clothes> clothesList){
//				if(clothesList!=null){
//					for(int i = (pageIndex-1)*20;i<pageIndex*2;i++)
//					{
//						jsonResult.put("clothes", clothesList.get(i).subJson());
//						arrayData.add(jsonResult);
//					}
//				}
//			}
//		});
//		return SUCCESS;
//	}
	
//	public String ActionQueryClothesByKeyWord(){
//		final ClothesServiceImp cs = new ClothesServiceImp();
//		cs.queryClothesByKeyWord(keyWord, page, new DataBaseListener<Clothes>(){
//			public void onSuccess(List<Clothes> clothesList){
//				if(clothesList!=null){
//					for(int i = (pageIndex-1)*20;i<pageIndex*2;i++)
//					{
//						jsonResult.put("clothes", clothesList.get(i).subJson());
//						arrayData.add(jsonResult);
//					}
//				}
//			}
//			
//		});
//		return SUCCESS;
//	}
	
	public String ActionShowClothesType(){
		
		arrayData = new ArrayList<HashMap<String,String>>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.showClothesType(new DataBaseListener<ClothesType>(){
			public void onSuccess(List<ClothesType> clothesTypeList){
				if(clothesTypeList!=null){
					for(int i = 0;i<clothesTypeList.size();i++)
					{
//						jsonData.put("clothesType", clothesTypeList.get(i).subJson());
//						jsonResult.put("clothesType", clothesTypeList.get(i).subJson());
//						arrayData.add(jsonResult);
						jsonData = new HashMap<String, String>();
						jsonData.put("clothesType",clothesTypeList.get(i).subJson());
						arrayData.add(jsonData);
					}
//					System.out.println("chengongle");
				}
			}		
		});	
//		System.out.println("chengongle");
		return SUCCESS;
	}
 }

