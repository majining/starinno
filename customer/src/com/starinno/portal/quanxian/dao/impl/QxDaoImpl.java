package com.starinno.portal.quanxian.dao.impl;

import java.util.List;

import com.starinno.portal.common.util.BaseDaoImpl;
import com.starinno.portal.quanxian.dao.IQxDao;
import com.starinno.portal.quanxian.pojo.TbQx;

public class QxDaoImpl extends BaseDaoImpl implements IQxDao {
	@Override
	public List<TbQx> findByAll() {
		// TODO Auto-generated method stub
		return getListByRequirement("from TbQx", null);
	}
}
