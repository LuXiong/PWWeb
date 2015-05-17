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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class SuitAction extends ActionSupport {

	/**
	 * 
	 */
	@Id
	@GeneratedValue
	private static final long serialVersionUID = 7355503326610945820L;

	private String id;
	private String userId;
	private String img;
	private String clothes;
	private Integer weather;
	private Integer occasion;
	private Date createTime;
	private Date lastEdit;
	private String description;
	private int isLike;
    private String thumb;
	
	@ManyToOne
	private Suit suit;
	@ManyToOne
	private SuitServiceImp suitServiceImp;
	@OneToMany
	private List<Suit> suitList;
	
	private HashMap<String, String> jsonData;
	private ArrayList<HashMap<String, String>> arrayData;
	
	public int page;
	public int pageIndex;
	public String keyWord;
	
	
	
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	
	public int getIsLike() {
		return isLike;
	}
	public void setIsLike(int isLike) {
		this.isLike = isLike;
	}
	public HashMap<String, String> getJsonData() {
		return jsonData;
	}
	public void setJsonData(HashMap<String, String> jsonData) {
		this.jsonData = jsonData;
	}
	public ArrayList<HashMap<String, String>> getArrayData() {
		return arrayData;
	}
	public void setArrayData(ArrayList<HashMap<String, String>> arrayData) {
		this.arrayData = arrayData;
	}
	public Suit getSuit() {
		return suit;
	}
	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
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
		return SUCCESS;
	}	
	
	public String ActionUpdateSuit(){

		jsonData  = new HashMap<String,String>();
		final SuitServiceImp ss = new SuitServiceImp();
		ss.updateSuit(id,weather,occasion,description,new DataBaseListener<Suit>(){
			public void onSuccess(Suit suit){
				if(suit != null){
					jsonData.put("suit", suit.subJson());
				}
			}
		});
		return SUCCESS;
	}
	

	
	public String ActionAddSuit(){
		jsonData = new HashMap<String,String>();
		final SuitServiceImp ss = new SuitServiceImp();
		System.out.println("start");
		ss.addSuit(userId,img,thumb,weather,occasion,clothes,description,isLike,new DataBaseListener<Suit>(){
			public void onSuccess(Suit suit){
				if(suit!=null){
					jsonData.put("suit", suit.subJson());
				}
			}
		});
		return SUCCESS;
	}
	
	public String ActionQuerySuitById(){
		jsonData = new HashMap<String,String>();
		final SuitServiceImp ss = new SuitServiceImp();
		ss.QuerySuitById(id, new DataBaseListener<Suit>(){
			public void onSuccess(Suit suit){
				if(suit != null){
					jsonData.put("suit", suit.subJson());
				}
			}
		});
		return SUCCESS;
	}
	

	
	/**这个列表还是让我很困惑啊，page是对外获取的，指定返回某一页的数据，一页数据20行*/
	public String ActionQuerySuitByUserId(){
		arrayData = new ArrayList<HashMap<String,String>>();
		final SuitServiceImp ss = new SuitServiceImp();
		ss.querySuitByUserId(userId, page, new DataBaseListener<Suit>(){
			public void onSuccess(List<Suit> suitList){
				if(suitList != null){
					for(int i = 0;i<suitList.size();i++)
					{
						jsonData = new HashMap<String, String>();
						jsonData.put("suit",suitList.get(i).subJson());
						arrayData.add(jsonData);
					}
				}
			}
			
		});
		return SUCCESS;
	}
	
	public String ActionQuerySuitByKeyWord(){
		arrayData = new ArrayList<HashMap<String,String>>();
		final SuitServiceImp ss = new SuitServiceImp();
		ss.querySuitByKeyWord(keyWord, page, new DataBaseListener<Suit>(){
			public void onSuccess(List<Suit> suitList){
				if(suitList != null){
					for(int i = 0;i<suitList.size();i++)
					{
						jsonData = new HashMap<String, String>();
						jsonData.put("suit",suitList.get(i).subJson());
						arrayData.add(jsonData);
					}
				}
			}
			
		});
		return SUCCESS;
	}
	
	public String ActionUpdateSuitIsLike(){
		final SuitServiceImp ss = new SuitServiceImp();
		ss.updateSuitIsLike(id,
				new DataBaseListener<Suit>() {
			public void onSuccess(Suit suit) {
				if (suit != null) {
					jsonData.put("suit", suit.subJson())	;
								}
							}
			});
		return SUCCESS;
	}
	
	public String ActionQueryClothesBySuitId(){
		arrayData = new ArrayList<HashMap<String,String>>();
		final SuitServiceImp ss = new SuitServiceImp();
		ss.queryClothesBySuitId(id, new DataBaseListener<Clothes>(){
			public void onSuccess(List<Clothes> clothesList){
				if(clothesList!=null){
					for(int i = 0;i<clothesList.size();i++){
						jsonData = new HashMap<String, String>();
						jsonData.put("clothes",clothesList.get(i).subJson());
						arrayData.add(jsonData);
					}
				}
			}
		});
		return SUCCESS;
	}

}
