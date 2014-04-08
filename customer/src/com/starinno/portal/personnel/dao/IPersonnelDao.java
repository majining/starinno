package com.starinno.portal.personnel.dao;

import java.util.List;

import com.starinno.portal.common.util.IBaseDao;
import com.starinno.portal.personnel.pojo.TbPersonnel;

public interface IPersonnelDao extends IBaseDao {
	//根据用户名密码查询结果集
	public List<TbPersonnel> findByTbPersonnel(String[] params);
	//查询全部数据
	public List<TbPersonnel> findByAll(int page,int pageSize);
	//查询全部数据不分页
	public List<TbPersonnel> findByAll();
	//查询某个权限的对象集合
	public List<TbPersonnel> findByquanxian(String qxname);
}
