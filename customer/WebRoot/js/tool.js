//提示用户是否删除客户信息
function isdelete(){
	if(confirm("请问你真的要删除选定的内容?")){
		var obj = document.getElementsByName("delid");
		for (var i=0;i<obj.length;i++){
				if(obj[i].checked == true){
					return true;
				}
		}
		return false;
	}else{
		return false;
	}
}
//提示用户是否删除员工
function isdeleteper(obj){
//	alert(obj);
	if(confirm("请问你真的删除员工！")){
		location.href="deleteperobj?gonghao="+obj;
	}
}
//提示用户是否导出
function isimport(obj){
	if(confirm("请问您真的想导出查询出来的数据?")){
		var url = window.location.href; 
		url=url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
		//alert(url);
		if(url=="findlist"){
			location.href="importcust.action";
		}else if(url=="findByCondition"){
	//		alert("f");
			location.href="importcust.action?"+obj;
		}else if(url=="findtxlBycustId"){
			location.href="importhistory.action";
		}else if(url=="findperlist"){
			location.href="importper.action";
		}
	}
	//alert(url); 

}

//提示用户是否删除
function address_delete(obj){
	if(confirm("请问是否要删除?包括此结点包含下的节点全部删除,请慎重!")){
		location.href=obj;
	}
}
//查询全部省
function address_cksheng(){
	//alert('fdf');
	location.href="cksheng.action";
//	location.href='cksheng.action';
}
//查询对应省的市
function address_ckshi(){
	var shengid=document.getElementById("shengid").value;
	if(shengid=="-1"){
		alert("请选择省!");
		return;
	}
	location.href="ckshibyshengid.action?shengid="+shengid;
}
//查询对应市的区
function address_ckqu(){
	var shengid=document.getElementById("sheng").value;
	var shiid=document.getElementById("shi").value;
	if(shengid=="-1"){
		alert("请先选择省!");
		return;
	}else if(shiid=="-1"){
		alert("请选择市哦");
		return;
	}
	location.href="ckqubyshiid.action?shiid="+shiid;
}