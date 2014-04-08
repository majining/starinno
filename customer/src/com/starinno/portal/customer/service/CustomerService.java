package com.starinno.portal.customer.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.transaction.annotation.Transactional;



import com.starinno.portal.address.service.AddressService;
import com.starinno.portal.common.Globals;
import com.starinno.portal.common.util.PageUtil;
import com.starinno.portal.customer.dao.ICustomerDao;
import com.starinno.portal.customer.pojo.TbCustomerinfo;
import com.starinno.portal.personnel.pojo.TbPersonnel;

public class CustomerService {
	//业务逻辑
	private AddressService as;
	public AddressService getAs() {
		return as;
	}
	public void setAs(AddressService as) {
		this.as = as;
	}
	//dao
	private ICustomerDao icd;
	public ICustomerDao getIcd() {
		return icd;
	}
	public void setIcd(ICustomerDao icd) {
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
	 * 复杂查询 支持分页
	 */
	public List<TbCustomerinfo> findByCondition(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid,int page){
		return icd.findByCondition(caozuoid, kehuname, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid, page,Globals.pageSize);
	}
	/**
	 * 复杂查询 数量
	 */
	public int findByConditionCount(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid){
		return icd.findByConditionCount(caozuoid, kehuname, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid);
	}
	/**
	 * 复杂查询 不分页
	 */
	public List<TbCustomerinfo> findByCondition(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid){
		return icd.findByCondition(caozuoid, kehuname, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid);
	}
	/**
	 * 新增客户
	 */
	public boolean addCust(TbPersonnel tp,String quid,String customerkhname,String customersshy,String customeryxqk,
			String lxr,String custguding,String custphone,String address,String custzyyw
			){
		TbCustomerinfo tci=new TbCustomerinfo(tp, as.findById(quid), customerkhname, customersshy, customeryxqk, lxr, custguding, new BigDecimal(custphone), address, custzyyw,new Date());
		Object o=icd.save(tci);
		if(o==null){
			return false;
		}
		return true;
	}
	/**
	 * 删除用户
	 */
	@Transactional(readOnly=false,rollbackFor=Exception.class)
	public boolean deleteCust(String[] custid){
	try{
		Integer[] intes=new Integer[custid.length];
		for (int i=0;i<custid.length; i++) {
			//System.out.println(custid[i]);
			intes[i]=Integer.parseInt(custid[i]);
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
	 * 查询一个用户
	 */
	public TbCustomerinfo findByObj(String custid){
		return icd.get(TbCustomerinfo.class,Integer.parseInt(custid));
		
	}
	/**
	 * 修改用户
	 * 
	 */
	public boolean uppdatecust(String custid,String suoshuhangye,String yixiangqingkuang
			,String lxr,String gphone,String mphone,String address,String zzyw,String quid){
		TbCustomerinfo ti=findByObj(custid);
		ti.setCustomerSshy(suoshuhangye);
		ti.setCustomerYxqk(yixiangqingkuang);
		ti.setCustomerLxr(lxr);
		ti.setCustomerGphone(gphone);
		ti.setCustomerMphone(new BigDecimal(mphone));
		ti.setCustomerAddress(address);
		ti.setCustomerZyyw(zzyw);
		ti.setTbQu(as.findById(quid));
		return icd.update(ti);

	}
	/**
	 * 根据客户名称查看存不存在
	 */
	public String isCunzai(String custname){
		System.out.println(custname);
		int count=icd.findCountByCustomername(new String[]{custname});
		System.out.println(count);
		if(count>0){
			return "不好意思哦,此客户名称存在";
		}else{
			return "正常";
		}
	}
	
	/**
	 * 导出
	 */
	public InputStream impcust(String caozuoid,String kehuname,String suoshuhangye,
			String yixiangqingkuang,String txlname,String gphone,String mphone,
			String address,String zyyw,String shengid,String shiid,String quid){
		 try {
			ByteArrayOutputStream out = new ByteArrayOutputStream(); 
            
			WritableWorkbook book = Workbook.createWorkbook(out);   
            WritableSheet sheet = book.createSheet("sheet1", 0);  
            //添加表头, 第一个参数是列，第二个是行   
            Label label1 = new Label(3, 0 , "客户id"); //第一列第一行   
            Label label2 = new Label(4, 0, "客户名称");  //第二列第一行  
            Label label3 = new Label(5, 0 , "联系人");
            Label label4 = new Label(6, 0, "联系电话");
            Label label5 = new Label(7, 0, "联系手机"); 
            Label label6 = new Label(8, 0 , "主营业务");
            Label label7 = new Label(9, 0 , "所属行业");
            Label label8 = new Label(10, 0, "地址");
            Label label9 = new Label(11, 0, "所属省");
            Label label10 = new Label(12, 0, "所属市");
            Label label11 = new Label(13, 0, "所属区");
            Label label12 = new Label(14, 0, "业务员");
            //添加到sheet1中   
            sheet.addCell(label1);  
            sheet.addCell(label2); 
            sheet.addCell(label3);  
            sheet.addCell(label4);  
            sheet.addCell(label5);  
            sheet.addCell(label6);
            sheet.addCell(label7);
            sheet.addCell(label8);  
            sheet.addCell(label9);
            sheet.addCell(label10);
            sheet.addCell(label11);  
            sheet.addCell(label12);
           
            List<TbCustomerinfo> list=findByCondition(caozuoid, kehuname, suoshuhangye, yixiangqingkuang, txlname, gphone, mphone, address, zyyw, shengid, shiid, quid);
            //调用
             if (list.size() != 0) {  
                    Iterator<TbCustomerinfo> it = list.iterator();  
                    int i = 1; //表示行   
                   while (it != null && it.hasNext()) {  
                   		  TbCustomerinfo tc = (TbCustomerinfo) it.next();   //list里存放学生 
                   		  //System.out.println("gggg");
                           Label l1 = new Label(3, i,tc.getCustomerId().toString());  
                           Label l2 = new Label(4, i, tc.getCustomerKhname());
                           Label l3 = new Label(5, i, tc.getCustomerLxr());  
                           Label l4 = new Label(6, i,tc.getCustomerGphone());  
                           Label l5 = new Label(7, i,tc.getCustomerMphone().toString());
                           Label l6 = new Label(8, i,tc.getCustomerZyyw());
                           Label l7 = new Label(9, i,tc.getCustomerSshy());
                           Label l8 = new Label(10, i,tc.getCustomerAddress());
                           Label l9 = new Label(11, i,tc.getTbQu().getTbShi().getTbSheng().getShengName());
                           Label l10 = new Label(12, i,tc.getTbQu().getTbShi().getShiName());
                           Label l11 = new Label(13, i,tc.getTbQu().getQuName());
                           Label l13 = new Label(14, i,tc.getTbPersonnel().getPersonnelName());
                            sheet.addCell(l1);  
                            sheet.addCell(l2);
                            sheet.addCell(l3);  
                            sheet.addCell(l4);  
                            sheet.addCell(l5);  
                            sheet.addCell(l6); 
                            sheet.addCell(l7);
                            sheet.addCell(l8);  
                            sheet.addCell(l9);  
                            sheet.addCell(l10); 
                            sheet.addCell(l11);
                            sheet.addCell(l13);
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
