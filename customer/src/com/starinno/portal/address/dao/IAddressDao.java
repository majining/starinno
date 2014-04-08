package com.starinno.portal.address.dao;

import java.util.List;

import com.starinno.portal.address.pojo.TbQu;
import com.starinno.portal.address.pojo.TbSheng;
import com.starinno.portal.address.pojo.TbShi;
import com.starinno.portal.common.util.IBaseDao;

public interface IAddressDao extends IBaseDao {
	//查询全部省
	public List<TbSheng> findBySheng();
	//根据省查询市
	public List<TbShi> findShiByShengid(String shengid);
	//根据市查询区
	public List<TbQu> findQuByShiid(String shiid);
	//查询全部市
	public List<TbShi> findshiByAll();
	//查询全部区
	public List<TbQu> findQuByAll();
}
