package com.starinno.portal.customer.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.transaction.annotation.Transactional;

import com.starinno.portal.common.Globals;
import com.starinno.portal.common.util.PageUtil;
import com.starinno.portal.customer.dao.ICustHistoryDao;
import com.starinno.portal.customer.pojo.TbCustomerinfo;
import com.starinno.portal.customer.pojo.TbCustomertxl;

public class CustomerHistoryService{
	private ICustHistoryDao icd;
	public ICustHistoryDao getIcd() {
		return icd;
	}
	public void setIcd(ICustHistoryDao icd) {
		this.icd = icd;
	}
	/**
	 * 根据数量查询最大页数
	 * @param count
	 * @return
	 */
	public int findMaxPage(int count){
		return PageUtil.findMaxPage(count);
	}
	/**
	 * 根据客户id查询联系记录
	 * @param params
	 * @return
	 */
	public List<TbCustomertxl> findByCustId(String[] params,int page){
		return icd.findTxlByCustid(params,page,Globals.pageSize);
	}
	//方法同上 就是不查询数量
	public List<TbCustomertxl> findByCustId(Integer[] params){
		return icd.findTxlByCustid(params);
	}
	/**
	 * 根据客户id查询数量
	 * @param params
	 * @return
	 */
	public int findByCustIdCount(String[] params){
		return icd.findTxlByCustidCount(params);
	}
	/**
	 * 新增
	 */
	public boolean save(String custid,String txldate,String txlcontent){
		TbCustomerinfo ti=new TbCustomerinfo();
		ti.setCustomerId(Integer.parseInt(custid));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			icd.save(new TbCustomertxl(ti, sdf.parse(txldate), txlcontent));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * get获取
	 */
	public TbCustomertxl get(String id){
		return icd.get(TbCustomertxl.class, Integer.parseInt(id));
	}
	/**
	 * 修改
	 */
	public boolean update(String txlid,String txldate,String txlcontent){
		TbCustomertxl txl=get(txlid);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			txl.setCustomertxlLxtime(sdf.parse(txldate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		txl.setCustomertxlLxcontent(txlcontent);
		return icd.update(txl);

	}
	/**
	 * 删除
	 */
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public boolean delete(String[] params){
		try{
			Integer[] intes=new Integer[params.length];
			for (int i=0;i<params.length; i++) {
				intes[i]=Integer.parseInt(params[i]);
			}
			 icd.deleteBySelect(intes);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
			return true;
	}
	/**
	 * 导出
	 */
	public InputStream imphistory(String custid){
		 try {
			ByteArrayOutputStream out = new ByteArrayOutputStream(); 
            
			WritableWorkbook book = Workbook.createWorkbook(out);   
            WritableSheet sheet = book.createSheet("sheet1", 0);  
            //添加表头, 第一个参数是列，第二个是行   
            Label label1 = new Label(3, 0 , "联系id"); //第一列第一行   
            Label label2 = new Label(4, 0, "客户名字");  //第二列第一行  
            Label label3 = new Label(5, 0 , "联系时间");
            Label label4 = new Label(6, 0, "联系内容");
            //添加到sheet1中   
            sheet.addCell(label1);  
            sheet.addCell(label2); 
            sheet.addCell(label3);  
            sheet.addCell(label4);  
           
            List<TbCustomertxl> list=findByCustId(new Integer[]{Integer.parseInt(custid)});
            
            System.out.println(list.size());
            //调用
             if (list.size() != 0) {  
                    Iterator<TbCustomertxl> it = list.iterator();  
                    int i = 1; //表示行   
                   while (it != null && it.hasNext()) {  
                	   TbCustomertxl tc = (TbCustomertxl) it.next();   //list里存放学生   
                           Label l1 = new Label(3, i,tc.getCustomertxlId().toString());  
                           Label l2 = new Label(4, i, tc.getTbCustomerinfo().getCustomerKhname());
                           Label l3 = new Label(5, i, tc.getCustomertxlLxtime().toString());  
                           Label l4 = new Label(6, i,tc.getCustomertxlLxcontent());  
                            sheet.addCell(l1);  
                            sheet.addCell(l2);
                            sheet.addCell(l3);  
                            sheet.addCell(l4);  
                           i++;  
                   }  
            }  
             book.write();  
             book.close();  
             return   new ByteArrayInputStream(out.toByteArray());
      } catch (Exception e) {  
             e.printStackTrace();
             return null;
      }  
}
}
