package com.starinno.portal.customer.dao.impl;

import java.util.List;

import com.starinno.portal.common.util.BaseDaoImpl;
import com.starinno.portal.customer.dao.ICustHistoryDao;
import com.starinno.portal.customer.pojo.TbCustomerinfo;
import com.starinno.portal.customer.pojo.TbCustomertxl;

public class CustHistoryDaoImpl extends BaseDaoImpl implements ICustHistoryDao {
	//根据客户id查询用户记录对象
	@Override
	public List<TbCustomertxl> findTxlByCustid(String[] params,int page,int pageSize) {
		// TODO Auto-generated method stub
		return getListByRequPaging("from TbCustomertxl tc where tc.tbCustomerinfo.customerId=? order by customertxlLxtime desc",params, ((page-1)*pageSize), pageSize);
	}
	//根据客户id查询用户记录对象 不分页
	@Override
	public List<TbCustomertxl> findTxlByCustid(Integer[] params) {
		// TODO Auto-generated method stub
		return getListByRequirement("from TbCustomertxl tc where tc.tbCustomerinfo.customerId=? order by customertxlLxtime desc",params);
	}
	@Override
	public int findTxlByCustidCount(String[] params){
		String hql="select count(*) from TbCustomertxl tc where tc.tbCustomerinfo.customerId=?";
		int count=getjuheCount(hql, params);
		return count;
	}
	//删除指定
	@Override
	public void deleteBySelect(Integer[] custid) {
		// TODO Auto-generated method stub
		for (Integer integer : custid) {
			this.getHibernateTemplate().delete(new TbCustomertxl(integer));
		}
	}
	
}
