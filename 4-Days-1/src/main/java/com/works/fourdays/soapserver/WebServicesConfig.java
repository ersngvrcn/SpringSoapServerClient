package com.works.fourdays.soapserver;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServicesConfig extends WsConfigurerAdapter{
	
	@Bean
	public ServletRegistrationBean message(ApplicationContext appContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(appContext);
		servlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(servlet,"/ws/*");
		
	}
	
	@Bean
	public XsdSchema bookSchema() {
		return new SimpleXsdSchema(new ClassPathResource("book.xsd"));
	}
	
	@Bean(name = "bookWsdl")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
		DefaultWsdl11Definition defult = new DefaultWsdl11Definition();
		defult.setPortTypeName("BooksPort");
		defult.setLocationUri("/ws");
		defult.setTargetNamespace(BookEndPoint.Name_Space_URL);
		defult.setSchema(schema);
		
		return defult;
	}
}
