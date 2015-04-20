package com.pwweb.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class BaseDAO {
	/**
	 * @info 添加记录
	 * @param entity
	 */
	public void saveObject(Object entity) throws Exception {
		SessionDAO.getSession().save(entity);
	}

	/**
	 * @info 通过主键删除记录
	 * @param entityClass
	 * @param entityId
	 */
	public void deleteObjectById(Class<?> entityClass, Serializable entityId)
			throws Exception {
		Session session = SessionDAO.getSession();
		session.delete(session.load(entityClass, entityId));
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

	/**
	 * @info 更新记录
	 * @param entity
	 */
	public void updateObject(Object entity) throws Exception {
		SessionDAO.getSession().update(entity);
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

	public void saveUser() {
		// TODO Auto-generated method stub
		
	}
}