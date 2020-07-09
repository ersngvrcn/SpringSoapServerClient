package com.works.fourdays.soapclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import https.www_java2blog_com.xml.book.GetBookRequest;
import https.www_java2blog_com.xml.book.GetBookResponse;

@Service
public class SoapClient {
	
	@Autowired
	Jaxb2Marshaller marshaller;
	
	private WebServiceTemplate serviceTemplate;
	
	public GetBookResponse getItem(GetBookRequest request) {
		serviceTemplate = new WebServiceTemplate(marshaller);
		String url = "http://localhost:8080/ws";
		GetBookResponse res = (GetBookResponse) serviceTemplate.marshalSendAndReceive(url,request);
		
		return res;
	}
}
