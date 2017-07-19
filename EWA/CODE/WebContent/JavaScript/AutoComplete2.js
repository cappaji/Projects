function getAJAXObject()
{
	var xmlHttp=false;//XHRObject
	/* try{
		xmlHttp=new ActiveXObject("Msxml2.XMLHTTP")
	}
	catch(e){
		xmlHttp=new ActiveXObject("Microsoft.XMLHTTP")
	}
	catch(e2){
		xmlHttp=false
	}
	if(!xmlHttp && typeof XMLHttpRequest != 'undefined'){
		xmlHttp=new XMLHttpRequest();
	} */
	xmlHttp=new XMLHttpRequest();
	return xmlHttp;	
}

var ajaxObj=new getAJAXObject();
ajaxObj.overrideMimeType('text/xml');

var AutoCompleteTable2=document.getElementById("AutoCompleteTable2");

function init(){
	console.log("Inside init() function");
	var arrivalAirport=document.getElementById("arrivalAirport");
	var autoRow2=document.getElementById("autoRow2");
	console.log("arrivalAirport:"+arrivalAirport);
}

function doCompletion2(){
	console.log("Inside doCompletion2() function"+arrivalAirport.value);
	var url="searchAutoComplete2?action=complete&searchId="+escape(arrivalAirport.value);
	ajaxObj.open("get",url,true);
	ajaxObj.send(null);//data is sent/submitted in the url as the request method type is get.So data to be sent is null.
	ajaxObj.onreadystatechange=callBack2;
}

function callBack2(){
	console.log("Inside callBack2() function")
	if(ajaxObj.readyState==3){
		document.getElementById("progressIndicator").style.display="block";
	}
	if(ajaxObj.readyState==4)//Complete response has come to XHRObject
	{
		console.log("Ready State : 4");
		if(ajaxObj.status==200)//response Status is 200:Success
		{
			console.log("Response status : 200"+ajaxObj.responseXML);
			parseMessages(ajaxObj.responseXML);
		}
	}	
}

function parseMessages(xmlData){
	console.log("Inside parseMessages() function"+xmlData);
	AutoCompleteTable2.innerHTML="";
	
	if(xmlData==null||xmlData==""){
		console.log("Response is null");
		return false;
	}
	else
	{	
		console.log("Response is not null"+xmlData);
		var airports=xmlData.getElementsByTagName("Airports")[0];
		if(airports.childNodes.length>0){
			
			for(loop=0;loop<airports.childNodes.length;loop++){
				var airport=airports.childNodes[loop];
				var cityName=airport.getElementsByTagName("CityName")[0].childNodes[0].nodeValue;
				var cityCode=airport.getElementsByTagName("CityCode")[0].childNodes[0].nodeValue;
				console.log("CITY NAME : "+cityName+" CITY CODE : "+cityCode);
				appendProduct(cityName,cityCode);
			}
		}
	}
}

function appendProduct(cityName,cityCode){
	console.log("Inside appendProduct() function");
	AutoCompleteTable2.style.display="table";
	var tableRow=document.createElement("tr");
	var tableData=document.createElement("td");
	tableRow.appendChild(tableData);
	AutoCompleteTable2.appendChild(tableRow);
	
	tableData.className="popupCell";
	
	var productLink=document.createElement("p");
	productLink.setAttribute("onclick", "fillSearchBox2('"+cityName+"');");
	productLink.appendChild(document.createTextNode(cityName));
	tableData.appendChild(productLink);
}

function fillSearchBox2(cityName){
	console.log("inside function fillSearchBox2");
	document.getElementById('arrivalAirport').value=cityName;
	document.getElementById('autoRow2').style.display='none';
}