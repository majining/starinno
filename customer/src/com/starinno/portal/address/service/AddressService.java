package com.starinno.portal.address.service;

import java.util.List;

import com.starinno.portal.address.dao.IAddressDao;
import com.starinno.portal.address.pojo.TbQu;
import com.starinno.portal.address.pojo.TbSheng;
import com.starinno.portal.address.pojo.TbShi;



public class AddressService {
	private IAddressDao iad;
	public IAddressDao getIad() {
		return iad;
	}
	public void setIad(IAddressDao iad) {
		this.iad = iad;
	}
	//加载全部省
	public List<TbSheng> findBySheng(){
		return iad.findBySheng();
	}
	//根据省id加载全部市
	public List<TbShi> findShiByShengid(String shengid){
		return iad.findShiByShengid(shengid);
	}
	//根据市id加载全部区
	public List<TbQu> findQuByShiid(String shiid){
		return iad.findQuByShiid(shiid);
	}
	//根据区id查询区
	public TbQu findById(String quid){
		return iad.get(TbQu.class, Integer.parseInt(quid));
	}
	//根据市id查询市
	public TbShi findByShiId(String shiid){
		return iad.get(TbShi.class, Integer.parseInt(shiid));
	}
	//根据id查询省
	public TbSheng findByShengid(String shengid){
		return iad.get(TbSheng.class, Integer.parseInt(shengid));
	}
	//查询全部市
	public List<TbShi> findAllShi(){
		return iad.findshiByAll();
	}
	//查询全部区
	public List<TbQu> findAllQu(){
		return iad.findQuByAll();
	}
	//新增省
	public boolean addsheng(String shengname){
		Object o= iad.save(new TbSheng(shengname));
		if(o==null){
			return false;
		}
		return true;
	}
	//删除省
	public boolean dropsheng(String shengid){
		
		return iad.delete(findByShengid(shengid));
	}
	//新增市
	public boolean addshi(String shengid,String shiname){
		Object o= iad.save(new TbShi(new TbSheng(Integer.parseInt(shengid)), shiname));
		if(o!=null){
			return true;
		}
		return false;
	}
	//删除市
	public boolean dropshi(String shiid){
		return iad.delete(findByShiId(shiid));
	}
	
	//新增区
	public boolean addqu(String shiid,String quname){
		Object o=iad.save(new TbQu(new TbShi(Integer.parseInt(shiid)),quname));
		if(o!=null){
			return true;
		}
		return false;
	}
	//删除区
	public boolean dropqu(String quid){
		return iad.delete(findById(quid));
	}
	
}
