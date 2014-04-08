package com.starinno.steel.portal.common.util;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class BaseDAOImpl extends HibernateDaoSupport implements IBaseDao {
	@Override
	public Object save(Class<?> entityClass) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate() .save(entityClass);
		return entityClass;
	}
	@Override
	public Object findById(Class<?> entityClass, String id) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
