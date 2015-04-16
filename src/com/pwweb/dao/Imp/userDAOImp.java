package com.pwweb.dao.Imp;

import java.util.List;

import com.pwweb.dao.UserDAO;
import com.pwweb.model.User;

import javax.persistence.Entity;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;  

@Entity
public class userDAOImp extends HibernateDaoSupport implements UserDAO{

	@Override
	  public void saveUser(User user) {             //�����û�����  
	        this.getHibernateTemplate().save(user);  
	    }  
	@Override   
	    public User queryByUsername(String username) {   //�����û�������  
	        @SuppressWarnings("unchecked")  
	        List<User> list = this.getHibernateTemplate().  
	                find("from user where name = ?",username);  
	        if(list.size() == 0){                           //�жϲ�ѯ�����Ƿ�Ϊ��  
	            return null;  
	        }else {  
	            return list.get(0);                         //���ص�һ���û�  
	        }  
	    }

	    @Override
		public void deleteUser(User user) {
			// TODO Auto-generated method stub
			 this.getHibernateTemplate().delete(user); 
		}

		@Override
		public List<User> findAllUser() {
			// TODO Auto-generated method stub
			 String sql = "from User user order by user.id desc"; 
			 return (List<User>) this.getHibernateTemplate().find(sql);
		}

		@Override
		public void updateUser(User user) {
			// TODO Auto-generated method stub
			 this.getHibernateTemplate().update(user); 		
		}


		
}
