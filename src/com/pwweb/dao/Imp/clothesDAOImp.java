package com.pwweb.dao.Imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pwweb.dao.ClothesDAO;
import com.pwweb.model.Clothes;
import com.pwweb.model.User;


public class clothesDAOImp extends HibernateDaoSupport implements ClothesDAO{

	@Override
	public void deleteClothes(Clothes clothes) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().delete(clothes); 
	}

	@Override
	public void saveClothes(Clothes clothes) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().save(clothes); 
	}

	@Override
	public void updateClothes(Clothes clothes) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(clothes); 
	}

	@Override
	public List<Clothes> findAllClothes() {
		// TODO Auto-generated method stub
		 String sql = "from Clothes clothes order by clothes.id desc"; 
		 return (List<Clothes>) this.getHibernateTemplate().find(sql);
	}

}
