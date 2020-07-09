package com.works.fourdays.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.works.fourdays.soapclient.SoapClient;

import https.www_java2blog_com.xml.book.GetBookRequest;
import https.www_java2blog_com.xml.book.GetBookResponse;

@RestController
public class SoapClientRestController {
	
	@Autowired
	SoapClient soapClient;
	
	@PostMapping("/getBooks")
	public GetBookResponse getBooks( GetBookRequest request) {
		
		GetBookResponse response = soapClient.getItem(request);
		
		return response;
		
	}
}
