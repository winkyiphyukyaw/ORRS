package com.ictti.orrs.util;
import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;


public class CreditCardPayment {
	public static String withdrawCreditPayment(String type,String cardno,String holdername,Integer amount) throws Exception {
		System.out.println("credit payment 1");
		String endpoint = "http://192.168.56.183:8080/CreditCard/services/Credit";
		System.out.println("credit payment 2");
		Service service = new Service();
		System.out.println("credit payment 3");
		Call call = (Call) service.createCall();
		
		call.setTargetEndpointAddress(new java.net.URL(endpoint));
		call.setOperationName(new QName("http://192.168.56.183:8080/","settlePayment"));
		Object[] obj = new Object[] { type, cardno,holdername,amount };
		String ret = (String) call.invoke(obj);
		System.out.println(ret);
		return ret;
	}
}


