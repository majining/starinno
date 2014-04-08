var xmlHttpRequest;
function createXMLHttpRequest(){
	if(window.ActiveXObject){
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}else{
		xmlHttpRequest = new XMLHttpRequest();
	}
}

//省操作
function findperbyquanxian(){

	var qxid = document.getElementById("qxid");
	//alert(qxid);
	if(qxid.value==-1){
		var perid = document.getElementById("perid");
		perid.options.length=0;
		perid.options[0]=new Option("请先选择权限类别",-1);
		return;
	}
	//请求
	var url = "js/findperbyquanxian?qxid="+qxid.value;
	createXMLHttpRequest();
	xmlHttpRequest.open("get",url,true);
	xmlHttpRequest.onreadystatechange = callback;
	xmlHttpRequest.send(null);
}


function callback(){
	if(xmlHttpRequest.readyState == 4){
		//alert(xmlHttpRequest.status);
		if(xmlHttpRequest.status == 200){
			
			var str=xmlHttpRequest.responseXML;
			//清空
			var perid = document.getElementById("perid");
			perid.options.length = 0;
			var idnodelist = str.getElementsByTagName("perid");
			var namenodelist = str.getElementsByTagName("pername");
			for(var i = 0;i < idnodelist.length;i++){
				var myid = idnodelist[i].childNodes[0].nodeValue;
				var myname = namenodelist[i].childNodes[0].nodeValue;
				perid.options[perid.length] = new Option(myname, myid);
			}
		}
	}
}
