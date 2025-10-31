package com.product.product;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class ProductWebService {
	
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context){
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/webservices/*");
	}
	
	@Bean(name = "products")
	public DefaultWsdl11Definition defaultWsdldef(XsdSchema xsdSchema) {
		DefaultWsdl11Definition wsdlDef = new DefaultWsdl11Definition();
		wsdlDef.setPortTypeName("ProductPort");
		wsdlDef.setLocationUri("/webservices/product/feature");
		wsdlDef.setTargetNamespace("http://product.com/productDetails");
		wsdlDef.setSchema(xsdSchema);
		return wsdlDef;
		}
	
	
	
	@Bean
	public XsdSchema xsdSchema() {
		return new SimpleXsdSchema(new ClassPathResource("product.xsd"));
	}
	
	

}
