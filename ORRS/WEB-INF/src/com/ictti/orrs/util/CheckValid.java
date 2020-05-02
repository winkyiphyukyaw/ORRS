package com.ictti.orrs.util;
import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;



public class CheckValid {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static String CheckCredit(String type,String cardno,String holdername,String expire,Integer amount) throws Exception {
        String endpoint = "http://192.168.56.183:8080/CreditCard/services/Credit";
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setTargetEndpointAddress(new java.net.URL(endpoint));
        call.setOperationName(new QName("http://192.168.56.183:8080/", "isValid"));
        Object[] obj = new Object[] {type, cardno,holdername,expire,amount};
        String ret = (String) call.invoke(obj);
        System.out.println(ret);
        return ret;
   }
	
}
