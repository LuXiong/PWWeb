package com.pwweb.dao.Imp;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.pwweb.dao.SuitDAO;
import com.pwweb.model.Suit;
import com.pwweb.model.User;

public class suitDAOImp extends HibernateDaoSupport implements SuitDAO{

	@Override
	public void deleteSuit(Suit suit) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().delete(suit);
	}

	@Override
	public void saveSuit(Suit suit) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(suit);
	}

	@Override
	public void updateSuit(Suit suit) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(suit);
	}

	@Override
	public List<Suit> findAllSuit() {
		// TODO Auto-generated method stub
		 String sql = "from Suit suit order by suit.id desc"; 
		 return (List<Suit>) this.getHibernateTemplate().find(sql);
	}


}
