package com.works.fourdays.soapclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller mr = new Jaxb2Marshaller();
		mr.setPackagesToScan("https.www_java2blog_com.xml.book");
		
		return mr;
	}
}
