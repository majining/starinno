package com.starinno.portal.quanxian.dao;

import java.util.List;

import com.starinno.portal.common.util.IBaseDao;
import com.starinno.portal.quanxian.pojo.TbQx;

public interface IQxDao extends IBaseDao {
	//查看全部
	public List<TbQx> findByAll();
}
