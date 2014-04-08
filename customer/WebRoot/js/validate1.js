//登陆验证
function loginvalidate(){
	var qxid=document.getElementById("qxid").value;
	var perid=document.getElementById("perid").value;
	var pwd=document.getElementById("pwd").value;
	if(qxid==-1){
		alert("请选择类别!");
		return false;
	}else if(pwd==""){
		alert("请输入密码!");
		return false;
	}
	return true;
}

//客户信息提交验证
function customerinfoval(){
	//alert("2322");
	var customerinfo=document.getElementById("customerinfo").innerHTML;
	var customername=document.getElementById("customername").value;
	var suoshuhangye=document.getElementById("suoshuhangye").value;
	var yixiangqingkuang=document.getElementById("yixiangqingkuang").value;
	//alert(yixiangqingkuang);
//	return false;
	var txlname=document.getElementById("txlname").value;
	var gphone=document.getElementById("gphone").value;
	var mphone=document.getElementById("mphone").value;
	var address=document.getElementById("address").value;
	var sheng=document.getElementById("sheng").value;
	var shi=document.getElementById("shi").value;
	var qu=document.getElementById("qu").value;
	var zyyw=document.getElementById("zyyw").value;
	if(customername==""){
		alert("请输入客户名称!");
		return false;
	}else if(customerinfo.replace(/(^\s*)|(\s*$)/g,"")!="正常"){
		alert("请更换客户名称!");
		return false;
	}else if(suoshuhangye==""){
		alert("请输入所属行业!");
		return false;
	}else if(yixiangqingkuang==""){
		alert("请输入意向情况!");
		return false;
	}else if(txlname==""){
		alert("请输入联系人名字!");
		return false;
	}else if(gphone==""){
		alert("请输入固定电话!");
		return false;
	}else if(mphone==""){
		alert("请输入移动电话!");
		return false;
	}else if(address==""){
		alert("请输入地址!");
		return false;
	}else if(sheng=="-1"){
		alert("请选择省!");
		return false;
	}else if(shi=="-1"){
		alert("请选择市!");
		return false;
	}else if(qu=="-1"){
		alert("请选择区!");
		return false;
	}else if(zyyw==""){
		alert("请输入主营业务!");
		return false;
	}
	return true;
}
//联系记录验证
	function txlval(){
		var date=document.getElementById("date").value;
		var lxcontent=document.getElementById("lxcontent").value;
		//alert(lxcontent);
		if(date==""){
			alert("请选择时间!");
			return false;
		}else if(lxcontent==""){
			alert("请输入联系内容!");
			return false;
		}
		return true;
	}
//业务员
		function perval(){
			//alert("ff");
			var custname=document.getElementById("custname").value;
			if(custname==""){
				alert("请输入业务员名字!");
				return false;
			}
			var pwd=document.getElementById("pwd").value;
			if(pwd==""){
				alert("请输入密码!");
				return false;
			}
//			var pwd1=document.getElementById("pwd1").value;
//			if(pwd1==pwd){
//				alert("两次密码输入不一样!");
//				return false;
//			}
			var custphone=document.getElementById("custphone").value;
			if(custphone==""){
				alert("请输入电话");
				return false;
			}
			var sex=document.getElementById("sex").value;
			if(sex=="-1"){
				alert("请选择性别!");
				return false;
			}
			var qxid=document.getElementById("qxid").value;
			if(qxid=="-1"){
				alert("请选择权限!");
				return false;
			}
			var age=document.getElementById("age").value;
			if(age==""){
				alert("请输入年龄!");
				return false;
			}
			return true;
		}
	//省
		function shengval(){
			var shengname=document.getElementById("shengname").value;
			if(shengname==""){
				alert("请输入添加省!");
				return false;
			}
			return true;
		}
//市验证
function shival(){
	var sheng=document.getElementById("shengid").value;
	if(sheng=="-1"){
		alert("请选择省!");
		return false;
	}
//	var shi=document.getElementById("shi").value;
//	if(shi=="-1"){
//		alert("请选择市!");
//		return false;
//	}
	var shiname=document.getElementById("shiname").value;
	if(shiname==""){
		alert("请输入要添加的市!");
		return false;
	}
	return true;
}

//区验证
function quval(){
	var sheng=document.getElementById("sheng").value;
	if(sheng=="-1"){
		alert("请选择省!");
		return false;
	}
	var shi=document.getElementById("shi").value;
	if(shi=="-1"){
		alert("请选择市!");
		return false;
	}
	var quname=document.getElementById("quname").value;
	if(quname==""){
		alert("请输入要添加的区!");
		return false;
	}
	return true;
}
//修改密码
function update_pwd(){
	var oldpwd=document.getElementById("oldpwd").value;
	if(oldpwd==""){
		alert("请输入原密码!");
		return false;
	}
	var newpwd=document.getElementById("newpwd").value;
	if(newpwd==""){
		alert("请选择新密码!");
		return false;
	}
	var newpwd1=document.getElementById("newpwd1").value;
	if(newpwd1!=newpwd){
		alert("两次输入密码不一样!");
		return false;
	}
	return true;
}	
//修改资料
function update_ziliao(){
	var custname=document.getElementById("custname").value;
	if(custname==""){
		alert("请输入人员名字!");
		return false;
	}
	var custphone=document.getElementById("custphone").value;
	if(custphone==""){
		alert("请输入人员电话!");
		return false;
	}
	var age=document.getElementById("age").value;
	if(age==""){
		alert("请输入人员年龄!");
		return false;
	}
	return true;
}
	
	
	
	