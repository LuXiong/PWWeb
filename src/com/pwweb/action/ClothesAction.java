package com.pwweb.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pwweb.common.DataBaseListener;
import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.ClothesType;
import com.pwweb.pojo.Suit;
import com.pwweb.service.Imp.ClothesServiceImp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ClothesAction extends ActionSupport{

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private static final long serialVersionUID = 8690763859731566034L;

	private String uuid;
	private String userId;
	private Integer color;
	private Integer category;
	private Integer exponent;
	private Date createTime;
	private Date lastEdit;
	private String img;
	private String suits;
	private String description;
	private int isLike;
	private String thumb;
	
	public int page;
	public int pageIndex = 1;
	public String keyWord;
	
	@ManyToOne
	private Clothes clothes;
	@ManyToOne
	private ClothesServiceImp clothesServiceImp;


	private HashMap<String, String> jsonData;
	private ArrayList<HashMap<String, String>> arrayData;

	
	
	
	
	public int isLike() {
		return isLike;
	}
	public void setLike(int isLike) {
		this.isLike = isLike;
	}
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

	public HashMap<String, String> getJsonData(){
		return jsonData;
	}
	public void setJsonData(HashMap<String, String> jsonData) {
		this.jsonData = jsonData;
	}


	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	
	
	public int getIsLike() {
		return isLike;
	}
	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
	public ClothesServiceImp getClothesServiceImp() {
		return clothesServiceImp;
	}
	public void setClothesServiceImp(ClothesServiceImp clothesServiceImp) {
		this.clothesServiceImp = clothesServiceImp;
	}
	
	public String ActionDeleteClothes(){
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.deleteClothes(uuid,
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
		cs.updateClothes(uuid,color,category,img,description,new DataBaseListener<Clothes>(){
			public void onSuccess(Clothes clothes){
				if(clothes!=null){
					jsonData.put("clothes",clothes.subJson());
				}
			}
		});
		
		return SUCCESS;
	}
	
	public String ActionAddClothes(){
        System.out.println("start");
		jsonData = new HashMap<String,String>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.addClothes(userId,color,category,img,thumb,description,isLike,new DataBaseListener<Clothes>(){
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
		cs.queryClothesById(uuid,new DataBaseListener<Clothes>(){
			public void onSuccess(Clothes clothes){
				if(clothes!=null){
					jsonData.put("clothes", clothes.subJson());
				}
			}
		});
		return SUCCESS;
	}
	

	
	public String ActionQueryClothesByUserId(){
		arrayData = new ArrayList<HashMap<String,String>>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.queryClothesByUserId(userId,page,new DataBaseListener<Clothes>(){
			public void onSuccess(List<Clothes> clothesList){
				if(clothesList!=null){
//					for(int i = (pageIndex-1)*20;i<pageIndex*2;i++)
					for(int i = 0;i<clothesList.size();i++)
					{
						jsonData = new HashMap<String, String>();
						jsonData.put("clothes",clothesList.get(i).subJson());
						arrayData.add(jsonData);
					}
				}
			}
		});
		return SUCCESS;
	}
	
	public String ActionQueryClothesByKeyWord(){
		arrayData = new ArrayList<HashMap<String,String>>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.queryClothesByKeyWord(keyWord,page,new DataBaseListener<Clothes>(){
			public void onSuccess(List<Clothes> clothesList){
				if(clothesList!=null){
					for(int i = 0;i<clothesList.size();i++)
					{
						jsonData = new HashMap<String, String>();
						jsonData.put("clothes",clothesList.get(i).subJson());
						arrayData.add(jsonData);
					}
				}
			}
			
		});
		return SUCCESS;
	}


	
	public String ActionShowClothesType(){
		
		arrayData = new ArrayList<HashMap<String,String>>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.showClothesType(new DataBaseListener<ClothesType>(){
			public void onSuccess(List<ClothesType> clothesTypeList){
				if(clothesTypeList!=null){
					for(int i = 0;i<clothesTypeList.size();i++)
					{

						jsonData = new HashMap<String, String>();
						jsonData.put("clothesType",clothesTypeList.get(i).subJson());
						arrayData.add(jsonData);
					}

				}
			}		
		});	

		return SUCCESS;
	}
	
	public String ActionUpdateSuitsId(){
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.updateSuitsId(uuid,
				new DataBaseListener<Clothes>() {
			public void onSuccess(Clothes clothes) {
				if (clothes != null) {
					jsonData.put("clothes", clothes.subJson())	;
								}
							}
			});
		return SUCCESS;
	}
	
	public String ActionUpdateClothesIsLike(){
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.updateClothesIsLike(uuid,
				new DataBaseListener<Clothes>() {
			public void onSuccess(Clothes clothes) {
				if (clothes != null) {
					jsonData.put("clothes", clothes.subJson())	;
								}
							}
			});
		return SUCCESS;
	}
	public String ActionQuerySuitByClothesId(){
		arrayData = new ArrayList<HashMap<String,String>>();
		final ClothesServiceImp cs = new ClothesServiceImp();
		cs.querySuitByClothesId(uuid, new DataBaseListener<Suit>(){
			public void onSuccess(List<Suit> suitList){
				if(suitList!=null){
					for(int i = 0;i<suitList.size();i++){
						jsonData = new HashMap<String, String>();
						jsonData.put("suit", suitList.get(i).subJson());
						arrayData.add(jsonData);
					}
				}
			}
		});
		return SUCCESS;
	}
 }
