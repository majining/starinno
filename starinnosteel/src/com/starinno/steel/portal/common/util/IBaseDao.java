package com.starinno.steel.portal.common.util;

public interface IBaseDao {
	public Object save(Class<?> entityClass);
	public Object findById(Class<?> entityClass, String id);
}
