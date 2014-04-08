package com.starinno.portal.personnel.dao.impl;

import java.util.List;


import com.starinno.portal.common.util.BaseDaoImpl;
import com.starinno.portal.personnel.dao.IPersonnelDao;
import com.starinno.portal.personnel.pojo.TbPersonnel;


public class PersonnelDaoImpl extends BaseDaoImpl implements IPersonnelDao {
	//根据用户名密码查询结果集
	@Override
	public List<TbPersonnel> findByTbPersonnel(String[] params) {
		// TODO Auto-generated method stub
		String hql="from TbPersonnel tp where tp.personnelId=? and tp.personnelPwd=?";
		return getListByRequirement(hql, params);
	}
	//查询所有数据分页
	@Override
	public List<TbPersonnel> findByAll(int page,int pageSize){
		String hql="from TbPersonnel tp order by tp.personnelCreatetime desc";
		return getListByRequPaging(hql,null,(page-1)*10,pageSize);
	}
	//查询所有数据不分页
	@Override
	public List<TbPersonnel> findByAll(){
		String hql="from TbPersonnel tp order by tp.personnelCreatetime desc";
		List<TbPersonnel> list=getListByRequirement(hql, null);
		return list;
	}
	//查询某个权限的对象集合
	@Override
	public List<TbPersonnel> findByquanxian(String qxname) {
		// TODO Auto-generated method stub
		String hql="from TbPersonnel t where t.tbQx.qxName=?";
		List<TbPersonnel> list=getListByRequirement(hql, new String[]{qxname});
		return list;
	}
	
}
