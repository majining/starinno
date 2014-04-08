var xmlHttpRequest;
function createXMLHttpRequest(){
	if(window.ActiveXObject){
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}else{
		xmlHttpRequest = new XMLHttpRequest();
	}
}

//验证客户名称是否存在
function isflag(){
	var customername = document.getElementById("customername").value;
	if(customername==""){
		return ;
	}
	//alert(customername);
	var url = "../js/iscustname.action?customername="+customername;
	createXMLHttpRequest();
	xmlHttpRequest.open("get",url,true);
	xmlHttpRequest.onreadystatechange = callback_isflag;
	xmlHttpRequest.send(null);
}


function callback_isflag(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var str=xmlHttpRequest.responseText;
			document.getElementById("customerinfo").innerHTML=str;
		}
	}
}