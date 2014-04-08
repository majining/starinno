package com.starinno.portal.common.util;

import com.starinno.portal.common.Globals;

public class PageUtil {
	public static int findMaxPage(int count){
		int page=1;
		try{
			int pagesize=Globals.pageSize;
			page=(count%10==0)?(count/pagesize):(count/pagesize+1);  //算出一共多少页面,用三元取值符
			if(page==0){
				return 1;
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return page;
	}
}
