package com.starinno.steel.portal.user.dao.impl;



import com.starinno.steel.portal.common.util.BaseDAOImpl;
import com.starinno.steel.portal.user.dao.IUserInfoDao;
import com.starinno.steel.portal.user.pojo.UserInfo;

public class UserInfoDaoImpl extends BaseDAOImpl  implements  IUserInfoDao {
	@Override
	public boolean delete(UserInfo myuser) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(myuser);
		return true;
	}

	
}
