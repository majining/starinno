package com.starinno.portal.common.util;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao {
	public <T> T get(Class<T> entityClass, Serializable id);
	public <T> T save(T entityClass);
	public boolean update(Object entityClass);
	public boolean delete(Object entityClass);
	public <T> List<T> getListByRequirement(String hql, Object[] params);
	public int getjuheCount(String hql,String[] params);
	public <T> List<T> getListByRequPaging(String hql,String[] params, int offset, int pageSize);
}
