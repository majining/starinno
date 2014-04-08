package com.starinno.portal.personnel.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import com.starinno.portal.common.Globals;
import com.starinno.portal.common.util.PageUtil;
import com.starinno.portal.customer.pojo.TbCustomerinfo;
import com.starinno.portal.personnel.dao.IPersonnelDao;
import com.starinno.portal.personnel.pojo.TbPersonnel;
import com.starinno.portal.quanxian.pojo.TbQx;
import com.starinno.portal.quanxian.service.QxService;

public class PersonnelService {
	//业务逻辑
	private QxService qs;
	public QxService getQs() {
		return qs;
	}
	public void setQs(QxService qs) {
		this.qs = qs;
	}
	
	
	//dao
	private IPersonnelDao ipd;
	public IPersonnelDao getIpd() {
		return ipd;
	}
	public void setIpd(IPersonnelDao ipd) {
		this.ipd = ipd;
	}
	/**
	 *根据数量查询页数
	 */
	public int findPageBySize(int count){
		return PageUtil.findMaxPage(count);
	}
	/**
	 * 登陆
	 * @param gonghao
	 * @param pwd
	 * @return
	 */
	public TbPersonnel login(String gonghao,String pwd){
		List<TbPersonnel> list=ipd.findByTbPersonnel(new String[]{gonghao,pwd});
		if(list ==null || list.size() ==0){
			return null;
		}
		return list.get(0);
	}
	/**
	 * 修改密码
	 * @param tp
	 * @param oldpwd
	 * @param newpwd
	 * @param newpwd1
	 * @return
	 */
	public boolean uppdatepwd(TbPersonnel tp, String oldpwd,String newpwd,String newpwd1){
		if(tp.getPersonnelPwd().equals(oldpwd)){
			if(newpwd.equals(newpwd1)){
				tp.setPersonnelPwd(newpwd1);
				ipd.update(tp);
				return true;
			}
		}
		return false;
		
	}
	/**
	 * 更新信息
	 * @param tp
	 * @param custname
	 * @param custphone
	 * @param sex
	 * @param age
	 * @return
	 */
	public boolean uppdateinfo(TbPersonnel tp,String custname,String custphone,String sex,String age){
		try{
			tp.setPersonnelName(custname);
			tp.setPersonnelPhone(new BigDecimal(custphone));
			tp.setPersonnelSex(sex);
			tp.setPersonnelAge(Integer.parseInt(age));
			return ipd.update(tp);
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}
	/**
	 * 根据id找出对象
	 * @param perid
	 * @return
	 */
	public TbPersonnel findObj(String perid){
		return ipd.get(TbPersonnel.class, perid);
	}
	/**
	 * 查询所有数据分页
	 * @param page
	 * @return
	 */
	public List<TbPersonnel> findByAll(int page){
		//System.out.println(page);
		return ipd.findByAll(page,Globals.pageSize);
	}
	/**
	 * 查询所有数据不分页
	 * @return
	 */
	public List<TbPersonnel> findByAll(){
		return ipd.findByAll();
	}
	/**
	 * 员工信息修改
	 * @param perid
	 * @param perpwd
	 * @param pername
	 * @param perphone
	 * @param persex
	 * @param qxid
	 * @param perage
	 * @return
	 */
	public boolean uppdateper(String perid,String perpwd,String pername,String perphone,String persex
			,String qxid,String perage){
		TbPersonnel tp= findObj(perid);
		//判断admin是否只有一个 如果只有一个不能删除
		if(tp.getTbQx().getQxName().equals("管理员")){		
			int count= ipd.findByquanxian("管理员").size();
			if(count==1){
				return false;
			}
		}
		tp.setPersonnelPwd(perpwd);
		tp.setPersonnelName(pername);
		tp.setPersonnelPhone(new BigDecimal(perphone));
		tp.setPersonnelSex(persex);
		tp.setPersonnelAge(Integer.parseInt(perage));
		tp.setTbQx(qs.findById(qxid));
		return ipd.update(tp);
	}
	/**
	 * 员工信息删除
	 * @param perid
	 * @return
	 */
	public boolean deleteper(String perid){
		TbPersonnel tp=findObj(perid);
		//判断admin是否只有一个 如果只有一个不能删除
		if(tp.getTbQx().getQxName().equals("管理员")){		
			int count= ipd.findByquanxian("管理员").size();
			if(count==1){
				return false;
			}
		}
		return	ipd.delete(tp);
	}
	/**
	 *增加对象
	 * @param perid
	 * @param pername
	 * @param perpwd
	 * @param perphone
	 * @param persex
	 * @param perqx
	 * @param perage
	 * @return
	 */
	public boolean  addper(String pername,String perpwd,String perphone,String persex,String perqx,String perage){
		TbPersonnel tp=new TbPersonnel(qs.findById(perqx),perpwd ,pername, new BigDecimal(perphone) , persex, Integer.parseInt(perage), new Date());
		Object Class= ipd.save(tp);
		if(Class!=null){
			return true;
		}
		return false;
	}
	
	public List<TbPersonnel> findPerByQuanxian(String quanxianid){
		TbQx myqx= qs.findById(quanxianid);
		//根据权限name查询权限id
		return ipd.findByquanxian(myqx.getQxName());
	}
	/**
	 * 导出
	 */
	public InputStream impper(){
		 try {
			ByteArrayOutputStream out = new ByteArrayOutputStream(); 
            
			WritableWorkbook book = Workbook.createWorkbook(out);   
            WritableSheet sheet = book.createSheet("sheet1", 0);  
            //添加表头, 第一个参数是列，第二个是行   
            Label label1 = new Label(3, 0 , "人员id"); //第一列第一行   
            Label label2 = new Label(4, 0, "人员名字");  //第二列第一行  
            Label label3 = new Label(5, 0 , "人员电话");
            Label label4 = new Label(6, 0, "人员性别");
            Label label5 = new Label(7, 0, "人员权限"); 
            Label label6 = new Label(8, 0 , "人员年龄");
            Label label7 = new Label(9, 0 , "创建时间");
            //添加到sheet1中   
            sheet.addCell(label1);  
            sheet.addCell(label2); 
            sheet.addCell(label3);  
            sheet.addCell(label4);  
            sheet.addCell(label5);  
            sheet.addCell(label6);
            sheet.addCell(label7);
           
            List<TbPersonnel> list=findByAll();
            //调用
             if (list.size() != 0) {  
                    Iterator<TbPersonnel> it = list.iterator();  
                    int i = 1; //表示行   
                   while (it != null && it.hasNext()) {  
                	   		TbPersonnel tp = (TbPersonnel) it.next();   //list里存放学生   
                           Label l1 = new Label(3, i,tp.getPersonnelId().toString());  
                           Label l2 = new Label(4, i,tp.getPersonnelName());
                           Label l3 = new Label(5, i,tp.getPersonnelPhone().toString());  
                           Label l4 = new Label(6, i,tp.getPersonnelSex());  
                           Label l5 = new Label(7, i,tp.getTbQx().getQxName());
                           Label l6 = new Label(8, i,tp.getPersonnelAge().toString());  
                           Label l7 = new Label(9, i,tp.getPersonnelCreatetime().toString());
                           
                            sheet.addCell(l1);  
                            sheet.addCell(l2);
                            sheet.addCell(l3);  
                            sheet.addCell(l4);  
                            sheet.addCell(l5);  
                            sheet.addCell(l6); 
                            sheet.addCell(l7);
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
