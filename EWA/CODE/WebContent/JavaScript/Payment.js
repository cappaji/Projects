function paymentLogo(){
	//console.log("Inside paymentLogo function");
	var cardNumber=document.getElementById("cardNumber").value;
	//console.log("cardNumber:"+cardNumber);

    var Visa=new RegExp("^4");//41
    var MasterCard=new RegExp("^5");//54
    var AmericanExpress=new RegExp("^3[47]");//34
    var DiscoverCard=new RegExp("^(6011|622(12[6-9]|1[3-9][0-9]|[2-8][0-9]{2}|9[0-1][0-9]|92[0-5]|64[4-9])|65)");
    var Diners=new RegExp("^36");
    var JCB=new RegExp("^35(2[89]|[3-8][0-9])");//3528

    if(Visa.test(cardNumber)){
    	console.log("Entered card is Visa");
		document.getElementById("paymentSystems").innerHTML="<i class='pf pf-visa'></i>";
    }//style='background-color: white;width: 80px;color: #0051a3;'
    else if(MasterCard.test(cardNumber)){
    	console.log("Entered card is MasterCard");
		document.getElementById("paymentSystems").innerHTML="<i class='pf pf-mastercard-alt'></i>";
    }else if(AmericanExpress.test(cardNumber)){
    	console.log("Entered card is AmericanExpress");
		document.getElementById("paymentSystems").innerHTML="<i class='pf pf-american-express'></i>";	
    }else if(DiscoverCard.test(cardNumber)){
    	console.log("Entered card is DiscoverCard");
		document.getElementById("paymentSystems").innerHTML="<i class='pf pf-discover'></i>";	
    }else if(Diners.test(cardNumber)){
    	console.log("Entered card is Diners");
		document.getElementById("paymentSystems").innerHTML="<i class='pf pf-diners'></i>";	
    }else if(JCB.test(cardNumber)){
    	console.log("Entered card is JCB");
		document.getElementById("paymentSystems").innerHTML="<i class='pf pf-jcb'></i>";	
    }else{
		document.getElementById("paymentSystems").innerHTML="";	
	}
}