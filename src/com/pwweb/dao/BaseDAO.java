package com.pwweb.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Entity
public class BaseDAO {
	/**
	 * @info 添加记录
	 * @param entity
	 */
	public void saveObject(Object entity) throws Exception {
		Session session = SessionDAO.getSession();
		Transaction tx = session.beginTransaction();
		session.save(entity);
		tx.commit();
		SessionDAO.closeSession();
	}

	/**
	 * @info 通过主键删除记录
	 * @param entityClass
	 * @param entityId
	 */
	public void deleteObjectById(Class<?> entityClass, Serializable entityId)
			throws Exception {
		Session session = SessionDAO.getSession();
		Transaction tx = session.beginTransaction();
		session.delete(session.load(entityClass, entityId));
		tx.commit();
		SessionDAO.closeSession();
	}

	/**
	 * @info 通过主键查询记录
	 * @param entityClass
	 * @param entityId
	 * @return 对象有可能为空，有可能不为空
	 */
	public Object findObjectById(Class<?> entityClass, Serializable entityId) {
	
	   return SessionDAO.getSession().get(entityClass, entityId);

	}

	/**
	 * @info 通过条件查询记录
	 * @param entityClass
	 * @param res
	 * @return 对象有可能为空，有可能不为空
	 */
	public Object findObjectByCriteria(Class<?> entityClass,
			ArrayList<Criterion> res) {
		Criteria c = SessionDAO.getSession().createCriteria(entityClass);
		for (int i = 0; i < res.size(); i++) {
			c.add(res.get(i));
		}
		return c.list();
	}
	

	public Object findObjectByCriteria(Class<?> entityClass,
			ArrayList<Criterion> res, ArrayList<Order> orders) {
		Criteria c = SessionDAO.getSession().createCriteria(entityClass);
		if (res != null) {
			for (int i = 0; i < res.size(); i++) {
				c.add(res.get(i));
			}
		}
		if (orders != null) {
			for (int i = 0; i < orders.size(); i++) {
				c.addOrder(orders.get(i));
			}
		}
		return c.list();
	}

	/**
	 * @info 更新记录
	 * @param entity
	 */
	public void updateObject(Object entity) throws Exception {
		Transaction tx = SessionDAO.getSession().beginTransaction();
		SessionDAO.getSession().update(entity);
		tx.commit();
		
//		Session session = SessionDAO.getSession();
//		Transaction tx = session.beginTransaction();
//		session.update(entity);
//		tx.commit();
//		SessionDAO.closeSession();
	}

	/**
	 * @info HQL方式更新记录
	 * @param hql
	 * @param values
	 * @return
	 */
	public void updateObjectByHql(String hql, Object[] values) throws Exception {
		Query query = SessionDAO.getSession().createQuery(hql);
		if (values != null) {
			int j = values.length;
			for (int i = 0; i < j; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}

	/**
	 * @info HQL方式查询记录
	 * @param hql
	 * @param values
	 * @return
	 */
	public List<?> findObjectByHql(String hql, Object[] values) {
		List<?> list = null;
		Query query = SessionDAO.getSession().createQuery(hql);
		if (values != null) {
			int j = values.length;
			for (int i = 0; i < j; i++) {
				query.setParameter(i, values[i]);
			}
		}
		list = query.list();
		return list;
	}

	/**
	 * @info HQL方式删除记录
	 * @param hql
	 * @param values
	 * @return
	 */
	public void deleteObjectByHql(String hql, Object[] values) throws Exception {
		Query query = SessionDAO.getSession().createQuery(hql);
		if (values != null) {
			int j = values.length;
			for (int i = 0; i < j; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.executeUpdate();
	}

	/**
	 * @info
	 * @param hql
	 * @param values
	 * @return
	 */
	public Object findSingletonResultByHql(String hql, Object[] values) {
		Query query = SessionDAO.getSession().createQuery(hql);
		if (values != null) {
			int j = values.length;
			for (int i = 0; i < j; i++) {
				query.setParameter(i, values[i]);
			}
		}
		return query.uniqueResult();
	}

	/**
	 * @info HQL方式查询记录，并对结果进行分�?
	 * @param hql
	 * @param offset
	 * @param pageSize
	 * @param values
	 * @return
	 */
	public List<?> findPagingObjectByHql(String hql, int offset, int pageSize,
			Object[] values) {
		Query query = SessionDAO.getSession().createQuery(hql);
		if (values != null) {
			int j = values.length;
			for (int i = 0; i < j; i++) {
				query.setParameter(i, values[i]);
			}
		}
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		return query.list();
	}


}