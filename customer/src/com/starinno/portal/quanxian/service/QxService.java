package com.starinno.portal.quanxian.service;

import java.util.List;

import com.starinno.portal.quanxian.dao.IQxDao;
import com.starinno.portal.quanxian.pojo.TbQx;


public class QxService {
		private IQxDao iqd;
		public IQxDao getIqd() {
			return iqd;
		}
		public void setIqd(IQxDao iqd) {
			this.iqd = iqd;
		}
		//根据id查询权限
		public TbQx findById(String qxid){
			TbQx tq=iqd.get(TbQx.class,Integer.parseInt(qxid));
			return tq;
		}
		//查询全部权限
		public List<TbQx> findByList(){
			return iqd.findByAll();
		}
}
