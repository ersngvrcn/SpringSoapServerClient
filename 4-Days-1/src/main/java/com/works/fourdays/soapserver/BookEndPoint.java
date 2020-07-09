package com.works.fourdays.soapserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.www_java2blog_com.xml.book.GetBookRequest;
import https.www_java2blog_com.xml.book.GetBookResponse;

@Endpoint
public class BookEndPoint {
	public static final String Name_Space_URL="https://www.java2blog.com/xml/book";
	
	@Autowired
	BookRepository bookRepository;
	
	@PayloadRoot(namespace = Name_Space_URL, localPart = "getBookRequest")
	@ResponsePayload
	public GetBookResponse getCity(@RequestPayload GetBookRequest request) {
		GetBookResponse response = new GetBookResponse();
		response.setBook(bookRepository.findBook(request.getId()));
		
		return response;
	}
}
