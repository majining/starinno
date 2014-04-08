var xmlHttpRequest;
function createXMLHttpRequest(){
	if(window.ActiveXObject){
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	}else{
		xmlHttpRequest = new XMLHttpRequest();
	}
}

//省操作
function loadshi(){
	var did = document.getElementById("sheng").value;
	//把区清空
	var qu=document.getElementById("qu");
	qu.options.length = 0;
	qu.options[0] = new Option("请选择", -1);
	
	if(did==-1){
		var shi = document.getElementById("shi");
		shi.options.length = 0;
		shi.options[0] = new Option("请选择", -1);
		return;
	}
	//请求
	var url = "../js/loadshi.action?shengid="+did;
	createXMLHttpRequest();
	xmlHttpRequest.open("get",url,true);
	xmlHttpRequest.onreadystatechange = callback_shi;
	xmlHttpRequest.send(null);
}


function callback_shi(){
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			var str=xmlHttpRequest.responseXML;
			var shi = document.getElementById("shi");
			var idnodelist = str.getElementsByTagName("sid");
			var namenodelist = str.getElementsByTagName("sname");
			shi.options.length = 0;
			for(var i = 0;i < idnodelist.length;i++){
				var myid = idnodelist[i].childNodes[0].nodeValue;
				var myname = namenodelist[i].childNodes[0].nodeValue;
				
				shi.options[shi.length] = new Option(myname, myid);
				//shi.add(new Option(myname,myid),null);
			}
		}
	}
}

function loadqu(){
	
	var did = document.getElementById("shi").value;
	if(did==-1){
		var qu = document.getElementById("qu");
		qu.options.length = 0;
		qu.options[0] = new Option("请选择", -1);
		return;
	}
	var url = "../js/loadqu.action?shiid="+did;
	createXMLHttpRequest();
	//alert(xmlHttpRequest);
	xmlHttpRequest.open("get",url,true);
	xmlHttpRequest.onreadystatechange = callback_qu;
	xmlHttpRequest.send(null);
}


function callback_qu(){
	
	if(xmlHttpRequest.readyState == 4){
		if(xmlHttpRequest.status == 200){
			//alert("222");
			var doc = xmlHttpRequest.responseXML;
			//alert(doc);
			var qu = document.getElementById("qu");
			//alert(shi)
			var idnodelist = doc.getElementsByTagName("qid");
			var namenodelist = doc.getElementsByTagName("qname");
			qu.options.length = 0;
			for(var i = 0;i < idnodelist.length;i++){
				//alert(street);
				var myid = idnodelist[i].childNodes[0].nodeValue;
				var myname = namenodelist[i].childNodes[0].nodeValue;
				qu.options[qu.length] = new Option(myname, myid);
				//shi.add(new Option(myname,myid),null);
			}
		}
	}
}

