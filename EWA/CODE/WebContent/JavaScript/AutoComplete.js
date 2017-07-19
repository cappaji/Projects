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

var autoCompleteTable=document.getElementById("AutoCompleteTable");

function init(){
	console.log("Inside init() function");
	var departureAirport=document.getElementById("departureAirport");
	var autoRow=document.getElementById("autoRow");
	console.log("departureAirport:"+departureAirport);
}

function doCompletion(){
	console.log("Inside doCompletion() function"+departureAirport.value);
	var url="searchAutoComplete?action=complete&searchId="+escape(departureAirport.value);
	ajaxObj.open("get",url,true);
	ajaxObj.send(null);//data is sent/submitted in the url as the request method type is get.So data to be sent is null.
	ajaxObj.onreadystatechange=callBack;
}

function callBack(){
	console.log("Inside callBack() function")
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
	autoCompleteTable.innerHTML="";
	
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
	
	autoCompleteTable.style.display="table";
	
	var tableRow=document.createElement("tr");
	var tableData=document.createElement("td");
	tableRow.appendChild(tableData);
	autoCompleteTable.appendChild(tableRow);
	
	tableData.className="popupCell";
	
	var productLink=document.createElement("p");
	//var cityCode;
	//productLink.setAttribute("href", "searchAutoComplete?action=complete&searchId="+cityCode);
	productLink.setAttribute("onclick", "fillSearchBox('"+cityName+"');");
	productLink.appendChild(document.createTextNode(cityName));
	tableData.appendChild(productLink);
	//tableData.appendChild(document.createTextNode(cityName));
}

function fillSearchBox(cityName){
	console.log("inside function fillSearchBox");
	document.getElementById('departureAirport').value=cityName;
	document.getElementById('autoRow').style.display='none';
}