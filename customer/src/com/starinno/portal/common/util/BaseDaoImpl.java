package com.starinno.portal.common.util;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDaoImpl extends HibernateDaoSupport implements IBaseDao {
	@Override
	public boolean delete(Object entityClass) {
		try{
			this.getHibernateTemplate().delete(entityClass);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public <T> T get(Class<T> entityClass, Serializable id){
		return (T)getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public <T> T save(T entityClass) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().save(entityClass);
			return entityClass;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean update(Object entityClass) {
		// TODO Auto-generated method stub
		try{
			this.getHibernateTemplate().update(entityClass);
			return true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public int getjuheCount(String hql,String[] params) {
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Query query=session.createQuery(hql);
		if(params!=null){
			for (int i = 0; i < params.length; i++) {
				query.setString(i, params[i]);
			}
		}
		Object count1=query.uniqueResult();
	    int count=Integer.parseInt(String.valueOf(count1));
		session.close();
	    return count;
	}
	@Override
	public <T> List<T> getListByRequirement(String hql, Object[] params) {
		//这个方法必须送  具体类型的值 
		return (List<T>)this.getHibernateTemplate().find(hql,params);
	}
	@Override
	public <T> List<T> getListByRequPaging(String hql,String[] params, int offset, int pageSize) {
		Session session=this.getHibernateTemplate().getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		if(params!=null){
			for (int i = 0; i < params.length; i++) {
				query.setString(i, params[i]);
			}
		}
		query.setFirstResult(offset);
		query.setMaxResults(pageSize);
		List<T> list=query.list();
		session.close();
		return list;
	}
	
}
