package com.starinno.portal.address.dao.impl;

import java.util.List;

import com.starinno.portal.address.dao.IAddressDao;
import com.starinno.portal.address.pojo.TbQu;
import com.starinno.portal.address.pojo.TbSheng;
import com.starinno.portal.address.pojo.TbShi;
import com.starinno.portal.common.util.BaseDaoImpl;

public class AddressDaoImpl extends BaseDaoImpl implements IAddressDao {
	
	//查询全部省
	public List<TbSheng> findBySheng(){
		return getListByRequirement("from TbSheng",null);
	}
	//根据省查询市
	public List<TbShi> findShiByShengid(String shengid){
		return getListByRequirement("from TbShi ts where ts.tbSheng.shengId=?", new Integer[]{Integer.parseInt(shengid)});
	}
	//根据市查询区
	public List<TbQu> findQuByShiid(String shiid){
		return getListByRequirement("from TbQu tq where tq.tbShi.shiId=?",new Integer[]{Integer.parseInt(shiid)});
	}
	//查询全部市
	@Override
	public List<TbShi> findshiByAll() {
		// TODO Auto-generated method stub
		return getListByRequirement("from TbShi", null);
	}
	//查询全部区
	@Override
	public List<TbQu> findQuByAll() {
		// TODO Auto-generated method stub
		return getListByRequirement("from TbQu", null);
	}
}
