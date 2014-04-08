package com.starinno.portal.common.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.starinno.portal.personnel.pojo.TbPersonnel;

public class MyInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
//		if(arg0.getAction() instanceof LoginAction){
//			return arg0.invoke();
//		}
		//System.out.println("在吗");
		//判断是否有 账户如果账户不存在 也就是session没有了 或者说压根没登陆
		//System.out.println("fdjl ");
		Map<String,Object> session = arg0.getInvocationContext().getSession();
		TbPersonnel tp = (TbPersonnel)session.get("user");
		if(tp != null){
			return arg0.invoke();
		}
		session.put("login_info", "由于您长时间没有操作!请重新登陆!");
		return "login";
	}

}
