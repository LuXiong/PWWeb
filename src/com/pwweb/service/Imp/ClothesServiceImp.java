package com.pwweb.service.Imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.ClothesType;
import com.pwweb.pojo.Suit;
import com.pwweb.pojo.Token;
import com.pwweb.pojo.User;
import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseListener;
import com.pwweb.common.Utils;
import com.pwweb.dao.BaseDAO;

@Entity
public class ClothesServiceImp {
	
/**
 * 增加服装
 * @param userId
 * @param color
 * @param category
 * @param img
 * @param listener
 * @return
 */
	public String addClothes(String userId,int color,int category,String img,String description,DataBaseListener<Clothes> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		Date date = new Date(System.currentTimeMillis());
		String id = Utils.generateUUid();
		String suits = "12";  //后期进行联系
		int exponent = 0;
		Clothes clothes = new Clothes(id, userId, color, category,exponent, date, date, img,
				suits,description);
//		Token token = new Token(Utils.generateUUid(), userId, date, color,
//				category, exponent,date,date, img );
		try {
			addDAO.saveObject(clothes);
			listener.onSuccess(clothes);
//			clothesdao.saveObject(token);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
		return Constant.SUCCESS;
	}
/**
 * 删除该服装
 * @param clothesId
 * @param listener
 */
	public void deleteClothes(String clothesId,DataBaseListener<Clothes> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO deleteDAO = new BaseDAO();
		try {
			deleteDAO.deleteObjectById(Clothes.class, clothesId);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
	}
/**
 * 更新用户该套服装的色彩/分类/图片信息
 * @param id
 * @param color
 * @param category
 * @param img
 * @param listener
 */
	public void updateClothes(String id,int color,int category,String img,DataBaseListener<Clothes> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
        BaseDAO updateDAO = new BaseDAO();
		
        Clothes c = (Clothes)updateDAO.findObjectById(Clothes.class,id);
		
        if(color == 0){
        	c.setColor(c.getColor());
        }else{
        	c.setColor(color);
        }
        if(category == 0){
        	c.setCategory(c.getCategory());
        }else{
        	c.setCategory(category);
        }
        if(img == null){
        	c.setImg(c.getImg());
        }else{
        	c.setImg(img);
        }
        Date date = new Date(System.currentTimeMillis());
        c.setLastEdit(date);
        
		try {
//			Clothes clothes = new Clothes(c.getId(),c.getUserId(),color,category,c.getExponent(),c.getCreateTime(),c.getLastEdit(),img,c.getSuits());
			updateDAO.updateObject(c);
			listener.onSuccess(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		listener.onFinish();
	}
/**
 * 通过服装id查询该套服装的详细信息
 * @param id
 * @param listener
 */
	public void queryClothesById(String id, DataBaseListener<Clothes> listener) {
		// TODO Auto-generated method stub
		listener.onStart();
		BaseDAO queryByIdDAO = new BaseDAO();
		try{
			Clothes c = (Clothes)queryByIdDAO.findObjectById(Clothes.class, id);
			String userId = c.getUserId();
			if(queryByIdDAO.findObjectById(User.class, userId)!=null){
				Clothes clothes = new Clothes(c.getId(),c.getUserId(),c.getColor(),c.getCategory(),c.getExponent(),c.getCreateTime(),c.getLastEdit(),c.getImg(),c.getSuits(),c.getDescription());
				System.out.println("find clothes successfully");
				listener.onSuccess(clothes);
			}else{
				listener.onFailure("该服装的用户不存在");
			}
//			Clothes clothes = new Clothes(c.getId(),c.getUserId(),c.getColor(),c.getCategory(),c.getExponent(),c.getCreateTime(),c.getLastEdit(),c.getImg(),c.getSuits());
//			System.out.println("find clothes successfully");
//			listener.onSuccess(clothes);
		}catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
		
	}
/**
 * 检查该色彩的数值所代表的色调
 * @param color
 * @return
 */
	public String CheckColor(int color){
		String colorW = null;
		switch(color){
		case 1 : colorW = "冷色" ;break;
		case 2 : colorW = "中性色" ;break;
		case 3 : colorW = "暖色";break;
		}
		return colorW;
	}
	
/**
 * 检查该分类的数值所代表的分类
 * @param category
 * @return
 */
	public String CheckClothesType(int category){
		String categoryW = null;
		switch(category){
		case 11: categoryW = "女裙装";break;
		case 12: categoryW = "女上衣";break;
		case 13: categoryW = "女裤装";break;
		case 14: categoryW = "女鞋";break;
		case 15: categoryW = "女性其他用品";break;
		case 01: categoryW = "男上衣";break;
		case 02: categoryW = "男下装";break;
		case 03: categoryW = "男鞋";break;
		case 04: categoryW = "男性其他用品";break;
		}
		return categoryW;
	}
/**
 * 根据用户的id查询该用户所有的服装
 * @param userId
 * @param listener
 * @return
 */
	
	
	public void queryClothesByUserId(String userId,int page,DataBaseListener<Clothes> listener){
		listener.onStart();
		BaseDAO queryClothesByUserIdDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.eq("userId", userId));

		try{

			List<Clothes> clothesList = (List<Clothes>) queryClothesByUserIdDAO.findObjectByCriteria(
					Clothes.class, res);
			page = clothesList.size()/20;
			if (clothesList.size() <= page*20) {
					listener.onSuccess(clothesList);		
			} else {
				listener.onFailure("not exist");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}
	/**
	 * 根据关键字来对数据进行查询
	 * @param keyWord
	 * @param page
	 * @param listener
	 */
	public void queryClothesByKeyWord(String keyWord,int page, DataBaseListener<Clothes> listener){
		listener.onStart();
		BaseDAO queryClothesBykeyWordDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.like("description", keyWord,MatchMode.ANYWHERE));
		try{
			List<Clothes> clothesList = (List<Clothes>) queryClothesBykeyWordDAO.findObjectByCriteria(
					Clothes.class, res);
		    page = clothesList.size()/20;//总的页数
			if (clothesList.size() <= page*20) {
					listener.onSuccess(clothesList);
		
//				listener.onSuccess((ArrayList<Suit>)suits);
			} else {
				listener.onFailure("not exist");
			}
		} catch (Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}
	/**
	 * 显示服装种类的列表，全部返回给客户端
	 * @param listener
	 */
	public void showClothesType(DataBaseListener<ClothesType> listener){
		listener.onStart();
		BaseDAO showClothesTypeDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
//		res.add(Restrictions.eq("detail_code", 21));
		try{
			@SuppressWarnings("unchecked")
			List<ClothesType> clothesTypeList = (List<ClothesType>) showClothesTypeDAO.findObjectByCriteria(ClothesType.class, res);
			listener.onSuccess(clothesTypeList);
			
		} catch (Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}


//	public void queryClothesType
}
