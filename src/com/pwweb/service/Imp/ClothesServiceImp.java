package com.pwweb.service.Imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.pwweb.common.Constant;
import com.pwweb.common.DataBaseListener;
import com.pwweb.common.Utils;
import com.pwweb.dao.BaseDAO;
import com.pwweb.pojo.Clothes;
import com.pwweb.pojo.ClothesType;
import com.pwweb.pojo.Suit;
import com.pwweb.pojo.User;

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
	public String addClothes(String userId,int color,int category,String img,String thumb,String description,int isLike,DataBaseListener<Clothes> listener) {
		listener.onStart();
		BaseDAO addDAO = new BaseDAO();
		Date date = new Date(System.currentTimeMillis());
		String id = Utils.generateUUid();
		String suits = null;  //后期进行联系
//		int exponent = findClothesType(category);
		int exponent = 2;
		Clothes clothes = new Clothes(id,userId, color, category,exponent, date, date, img,
				suits,description,isLike,thumb);
//		Token token = new Token(Utils.generateUUid(), userId, date, color,
//				category, exponent,date,date, img );
		System.out.println("userId:"+userId);
		try {
			
			System.out.println("user:"+addDAO.findObjectById(User.class, userId).toString());
			if(addDAO.findObjectById(User.class, userId)!= null){		
			addDAO.saveObject(clothes);
			listener.onSuccess(clothes);
//	        System.out.println("clothes:"+clothes.toString());
			} else {
				listener.onFailure("the user does not exist");
			}
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
/**删除该衣服的同时删除该衣服所包含的suit*/
	public void deleteClothes(String clothesId,DataBaseListener<Clothes> listener) {
		listener.onStart();
		BaseDAO deleteDAO = new BaseDAO();
		BaseDAO updateSuitDAO = new BaseDAO();//保存服装删除后的搭配的clothes
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.disjunction()
				.add(Restrictions.like("clothes", clothesId,MatchMode.ANYWHERE))
				.add(Restrictions.like("clothes", clothesId,MatchMode.END))
				.add(Restrictions.like("clothes", clothesId,MatchMode.START)));
		try {
			List<Suit> suitList = (List<Suit>)updateSuitDAO.findObjectByCriteria(Suit.class, res);	
            for(int i=0;i<suitList.size();i++){
            	suitList.get(i).setClothes(suitList.get(i).getClothes().replaceFirst(clothesId, ""));
            	updateSuitDAO.updateObject(suitList.get(i));
            	
            }
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
	public void updateClothes(String id,int color,int category,String img,String description,DataBaseListener<Clothes> listener) {
		listener.onStart();
        BaseDAO updateDAO = new BaseDAO();
        Clothes c = (Clothes)updateDAO.findObjectById(Clothes.class,id);
		
        if(color != c.getColor()){
        	c.setColor(c.getColor());
        }else{
        	c.setColor(color);
        }
        if(category != c.getCategory()){
        	c.setCategory(c.getCategory());
        }else{
        	c.setCategory(category);
        }
        if(img == null){
        	c.setImg(c.getImg());
        }else{
        	c.setImg(img);
        }
        if(description == null){
        	c.setDescription(c.getDescription());
        }else{
        	c.setDescription(description);
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
		listener.onStart();
		BaseDAO queryByIdDAO = new BaseDAO();
		try{
			Clothes c = (Clothes)queryByIdDAO.findObjectById(Clothes.class, id);
			String userId = c.getUserId();
			if(queryByIdDAO.findObjectById(User.class, userId)!=null){
				Clothes clothes = new Clothes(c.getUuid(),c.getUserId(),c.getColor(),c.getCategory(),c.getExponent(),c.getCreateTime(),c.getLastEdit(),c.getImg(),c.getSuits(),c.getDescription(),c.getIsLike(),c.getThumb());
				System.out.println("find clothes successfully");
				listener.onSuccess(clothes);
			}else{
				listener.onFailure("该服装的用户不存在");
			}

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
 * 根据用户的id查询该用户所有的服装
 * @param userId
 * @param listener
 * @return
 */
	
	
	public void queryClothesByUserId(String userId,int page,DataBaseListener<Clothes> listener){
		listener.onStart();
		BaseDAO queryClothesByUserIdDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		ArrayList<Order> orders = new ArrayList<Order>();
		orders.add(Order.desc("lastEdit"));
		res.add(Restrictions.eq("userId", userId));
		try {

			List<Clothes> clothesList = (List<Clothes>) queryClothesByUserIdDAO
					.findObjectByCriteria(Clothes.class, res, orders);
			ArrayList<Clothes> clothesShowList = new ArrayList<Clothes>();
			if (page == 0) {
				for (int i = 0; i < clothesList.size(); i++) {
					clothesShowList.add(clothesList.get(i));
				}
				listener.onSuccess((List<Clothes>) clothesShowList);
			} else if ((page * 20 <= clothesList.size())&&(page!=0)) {
				for (int i = (page - 1) * 20; i < page * 20; i++) {
					clothesShowList.add(clothesList.get(i));
				}
				listener.onSuccess((List<Clothes>) clothesShowList);
			} else if (((page - 1) * 20 <= clothesList.size())
					&& (clothesList.size() <= page * 20)) {
				for (int i = (page - 1) * 20; i < clothesList.size(); i++) {
					clothesShowList.add(clothesList.get(i));
				}
				listener.onSuccess((List<Clothes>) clothesShowList);
			} else if (page * 20 > clothesList.size()) {
				System.out.println("no more results");
				listener.onFailure("no more");
			}
		} catch (Exception e) {
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
		ArrayList<Order> orders = new ArrayList<Order>();
		res.add(Restrictions.disjunction()
				.add(Restrictions.like("description", keyWord,MatchMode.ANYWHERE))
				.add(Restrictions.like("description", keyWord,MatchMode.END))
				.add(Restrictions.like("description", keyWord,MatchMode.START)));
//		res.add(Restrictions.like("description", keyWord,MatchMode.ANYWHERE))
//		.add(Restrictions.like("description", keyWord,MatchMode.END))
//		.add(Restrictions.like("description", keyWord,MatchMode.START));
		
		orders.add(Order.desc("lastEdit"));
	
		try {
			List<Clothes> clothesList = (List<Clothes>) queryClothesBykeyWordDAO
					.findObjectByCriteria(Clothes.class, res, orders);
			ArrayList<Clothes> clothesShowList = new ArrayList<Clothes>();
			if (page == 0) {
				for (int i = 0; i < clothesList.size(); i++) {
					clothesShowList.add(clothesList.get(i));
				}
				listener.onSuccess((List<Clothes>) clothesShowList);
			} else if ((page * 20 <= clothesList.size())&&(page!=0)) {
				for (int i = (page - 1) * 20; i < page * 20; i++) {
					clothesShowList.add(clothesList.get(i));
				}
				listener.onSuccess((List<Clothes>) clothesShowList);
			} else if (((page - 1) * 20 <= clothesList.size())
					&& (clothesList.size() <= page * 20)) {
				for (int i = (page - 1) * 20; i < clothesList.size(); i++) {
					clothesShowList.add(clothesList.get(i));
				}
				listener.onSuccess((List<Clothes>) clothesShowList);
			} else if (page * 20 > clothesList.size()) {
				System.out.println("no more results");
				listener.onFailure("no more");
			}
		} catch (Exception e) {
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

		try{
			@SuppressWarnings("unchecked")
			List<ClothesType> clothesTypeList = (List<ClothesType>) showClothesTypeDAO.findObjectByCriteria(ClothesType.class, res);
			listener.onSuccess(clothesTypeList);
			
		} catch (Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}

/**
 * 根据category来判断该件衣服的穿衣指数，并且返回
 * @param category
 * @return
 */

	public int findClothesType(int category){
		int exponent = 0;
		BaseDAO findClothesTypeDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.eq("detailCode", category));
		List<ClothesType> clothesTypeList = (List<ClothesType>)findClothesTypeDAO.findObjectByCriteria(ClothesType.class, res);
		exponent = clothesTypeList.get(0).getDetailCode();
		return exponent;
		
	}
	/**
	 * 当用户添加新的套装时，对应衣服的suitId的更新
	 * @param id
	 * @param listener
	 */
	public void updateSuitsId(String id,DataBaseListener<Clothes> listener) {
		listener.onStart();
		String suitsId = null;
		BaseDAO updateSuitsIdDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.disjunction()
				.add(Restrictions.like("clothes", id,MatchMode.ANYWHERE))
				.add(Restrictions.like("clothes", id,MatchMode.END))
				.add(Restrictions.like("clothes", id,MatchMode.START)));
		List<Suit> suitsList = (List<Suit>) updateSuitsIdDAO.findObjectByCriteria(Suit.class, res);
		for(int i = 0;i<suitsList.size();i++)
		{
			
			suitsId = suitsId + suitsList.get(i).getId();
		}

		try{
		Clothes clothes = (Clothes) updateSuitsIdDAO.findObjectById(Clothes.class, id);
		clothes.setSuits(suitsId);
		updateSuitsIdDAO.updateObject(clothes);
		listener.onSuccess(clothes);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		listener.onFinish();
	}
	/**
	 * 改变用户对服装的喜爱
	 * @param id
	 * @param listener
	 */
	public void updateClothesIsLike(String id,DataBaseListener<Clothes> listener) {
		listener.onStart();
		BaseDAO updateClothesIsLikeDAO = new BaseDAO();
		try{
		Clothes clothes = (Clothes) updateClothesIsLikeDAO.findObjectById(Clothes.class, id);
		if(clothes.getIsLike() == 0){
			clothes.setIsLike(1);
			updateClothesIsLikeDAO.updateObject(clothes);
			listener.onSuccess(clothes);
		}else if(clothes.getIsLike() == 1){
			clothes.setIsLike(0);
			updateClothesIsLikeDAO.updateObject(clothes);
			listener.onSuccess(clothes);
		}
		} catch (Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}
	
	public void querySuitByClothesId(String clothesId,DataBaseListener<Suit> listener){
		listener.onStart();
		BaseDAO queryDAO = new BaseDAO();
		ArrayList<Criterion> res = new ArrayList<Criterion>();
		res.add(Restrictions.disjunction()
				.add(Restrictions.like("clothes", clothesId,MatchMode.ANYWHERE))
				.add(Restrictions.like("clothes", clothesId,MatchMode.END))
				.add(Restrictions.like("clothes", clothesId,MatchMode.START)));
		try{
			List<Suit> suitList = (List<Suit>)queryDAO.findObjectByCriteria(Suit.class, res);
			listener.onSuccess(suitList);
		} catch(Exception e){
			e.printStackTrace();
		}
		listener.onFinish();
	}
}
