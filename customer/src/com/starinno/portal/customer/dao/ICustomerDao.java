package com.starinno.portal.customer.dao;

import java.util.List;

import com.starinno.portal.common.util.IBaseDao;
import com.starinno.portal.customer.pojo.TbCustomerinfo;

public interface ICustomerDao extends IBaseDao {
	//分页复杂查询
	public List<TbCustomerinfo> findByCondition(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid,int page,int pageSize);
	//根据客户名字查询局和数量
	public int findCountByCustomername(String[] params);
	//复杂查询不分页
	public List<TbCustomerinfo> findByCondition(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid);
	//复杂查询数量
	public int findByConditionCount(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid);
	//删除指定
	public void deleteBySelect(Integer[] custid);
	
}
