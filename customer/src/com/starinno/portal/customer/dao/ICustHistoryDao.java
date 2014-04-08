package com.starinno.portal.customer.dao;

import java.util.List;

import com.starinno.portal.common.util.IBaseDao;
import com.starinno.portal.customer.pojo.TbCustomertxl;

public interface ICustHistoryDao extends IBaseDao {
	//根据客户id查询用户记录对象
	public List<TbCustomertxl> findTxlByCustid(String[] params,int page,int pageSize);
	//根据客户id查询联系记录  不分页
	public List<TbCustomertxl> findTxlByCustid(Integer[] params);
	//根据客户id查询用户对象数量
	public int findTxlByCustidCount(String[] params);
	public void deleteBySelect(Integer[] custid);
}
