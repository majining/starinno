package com.starinno.portal.customer.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.starinno.portal.common.util.BaseDaoImpl;
import com.starinno.portal.common.util.PageUtil;
import com.starinno.portal.customer.dao.ICustomerDao;
import com.starinno.portal.customer.pojo.TbCustomerinfo;

public class CustomerDaoImpl extends BaseDaoImpl implements ICustomerDao {
	//复杂查询
	public List<TbCustomerinfo> findByCondition(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid,int page,int pageSize){
		System.out.println(gphone);
		String hql="from TbCustomerinfo ti where 1=1";
		if(!caozuoid.equals("-1")){
			hql=hql+" and tbPersonnel.personnelId= '"+caozuoid+"'";
		}
		if(!kehuname.equals("")){
			hql=hql+" and customerKhname like '%"+kehuname+"%'";
		}
		if(!suoshuhangye.equals("")){
			hql=hql+" and customerSshy like '%"+suoshuhangye+"%'";
		}
		if(!yixiangqingkuang.equals("")){
			hql=hql+" and customerYxqk like '%"+yixiangqingkuang+"%'";
		}
		if(!txlname.equals("")){
			hql=hql+" and customerLxr like '%"+txlname+"%'";
		}
		if(!gphone.equals("")){
			hql=hql+" and customerGphone like '%"+gphone+"%'";
		}
		if(!mphone.equals("")){
			hql=hql+" and customerMphone like '%"+mphone+"%'";
		}
		
		if(!address.equals("")){
			hql=hql+" and customerAddress like '%"+address+"%'";
		}
		if(!zyyw.equals("")){
			hql=hql+" and customerZyyw like '%"+zyyw+"%'";
		}
		
		if(!quid.equals("-1")){
			hql=hql+" and tbQu.quId = "+quid;
		}else if(!shiid.equals("-1")){
			hql=hql+" and tbQu.tbShi.shiId = "+shiid;
		
		}else if(!shengid.equals("-1")){
			hql=hql+" and tbQu.tbShi.tbSheng.shengId = "+shengid;
		}
		hql=hql+" order by customercreatetime desc";
//		//先查询多少页  如果超出直接默认第一页
//		String hql1="select count(*) "+hql;
//		int count=getjuheCount(hql1, null);
//		int maxpage=PageUtil.findMaxPage(count);
//		if(page>maxpage){
//			page=1;
//		}
		return getListByRequPaging(hql, null, (page-1)*pageSize, pageSize);
	}
	//复杂查询 求出count数量
	public int findByConditionCount(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid){
		String hql="from TbCustomerinfo ti where 1=1";
		if(!caozuoid.equals("-1")){
			hql=hql+" and tbPersonnel.personnelId= '"+caozuoid+"'";
		}
		if(!kehuname.equals("")){
			hql=hql+" and customerKhname like '%"+kehuname+"%'";
		}
		if(!suoshuhangye.equals("")){
			hql=hql+" and customerSshy like '%"+suoshuhangye+"%'";
		}
		if(!yixiangqingkuang.equals("")){
			hql=hql+" and customerYxqk like '%"+yixiangqingkuang+"%'";
		}
		if(!txlname.equals("")){
			hql=hql+" and customerLxr like '%"+txlname+"%'";
		}
		if(!gphone.equals("")){
			hql=hql+" and customerSshy like '%"+suoshuhangye+"%'";
		}
		if(!mphone.equals("")){
			hql=hql+" and customerMphone like '%"+mphone+"%'";
		}
		
		if(!address.equals("")){
			hql=hql+" and customerAddress like '%"+address+"%'";
		}
		if(!zyyw.equals("")){
			hql=hql+" and customerZyyw like '%"+zyyw+"%'";
		}
		
		if(!quid.equals("-1")){
			hql=hql+" and tbQu.quId = "+quid;
		}else if(!shiid.equals("-1")){
			hql=hql+" and tbQu.tbShi.shiId = "+shiid;
		
		}else if(!shengid.equals("-1")){
			hql=hql+" and tbQu.tbShi.tbSheng.shengId = "+shengid;
		}
		hql=hql+" order by customercreatetime desc";
		//先查询多少页  如果超出直接默认第一页
		String hql1="select count(*) "+hql;
		int count=getjuheCount(hql1, null);
		return count;
	}
	//复杂查询 不分页
	@Override
	public List<TbCustomerinfo> findByCondition(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid){
		String hql="from TbCustomerinfo ti where 1=1";
		if(!caozuoid.equals("-1")){
			hql=hql+" and tbPersonnel.personnelId= '"+caozuoid+"'";
		}
		if(!kehuname.equals("")){
			hql=hql+" and customerKhname like '%"+kehuname+"%'";
		}
		if(!suoshuhangye.equals("")){
			hql=hql+" and customerSshy like '%"+suoshuhangye+"%'";
		}
		if(!yixiangqingkuang.equals("")){
			hql=hql+" and customerYxqk like '%"+yixiangqingkuang+"%'";
		}
		if(!txlname.equals("")){
			hql=hql+" and customerLxr like '%"+txlname+"%'";
		}
		if(!gphone.equals("")){
			hql=hql+" and customerSshy like '%"+suoshuhangye+"%'";
		}
		if(!mphone.equals("")){
			hql=hql+" and customerMphone like '%"+mphone+"%'";
		}
		
		if(!address.equals("")){
			hql=hql+" and customerAddress like '%"+address+"%'";
		}
		if(!zyyw.equals("")){
			hql=hql+" and customerZyyw like '%"+zyyw+"%'";
		}
		
		if(!quid.equals("-1")){
			hql=hql+" and tbQu.quId = "+quid;
		}else if(!shiid.equals("-1")){
			hql=hql+" and tbQu.tbShi.shiId = "+shiid;
		
		}else if(!shengid.equals("-1")){
			hql=hql+" and tbQu.tbShi.tbSheng.shengId = "+shengid;
		}
		hql=hql+" order by customercreatetime desc";
		return getListByRequirement(hql, null);
	}
	//根据客户名字找出数量
	@Override
	public int findCountByCustomername(String[] params) {
		// TODO Auto-generated method stub
		String hql="select count(*) from TbCustomerinfo tc where tc.customerKhname=?";
		return getjuheCount(hql, params);
	}
	//删除指定
	@Override
	public void deleteBySelect(Integer[] custid) {
		// TODO Auto-generated method stub
		Session session= this.getHibernateTemplate().getSessionFactory().openSession();
		session.beginTransaction().begin();
		
		for (Integer integer : custid) {
			this.getSession().createSQLQuery("delete from tb_customertxl t where t.customer_id='"+integer+"'").executeUpdate();   
			this.getHibernateTemplate().delete(new TbCustomerinfo(integer));
		}
		session.beginTransaction().commit();
	}
}
