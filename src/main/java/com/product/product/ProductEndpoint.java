package com.product.product;

import org.springframework.context.support.StaticApplicationContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {
	
	private static final String TARGET_NAMESPACE_URI = "http://product.com/productDetails";
	
	@PayloadRoot(namespace = TARGET_NAMESPACE_URI, localPart = "ProductRequest")
	@ResponsePayload
	public ProductResponse processProduct(@RequestPayload ProductRequest request) {
		ProductResponse response = new ProductResponse();
		response.setName(request.getName().toUpperCase());
		response.setColor(request.getColor().toUpperCase());
		System.out.println("Program Completed - 12");

		return response;
	}

}
