package com.product.product;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "ProductResponse", namespace = "http://product.com/productDetails")
@XmlType(name = "ProductResponse", propOrder = {"name", "color"})
public class ProductResponse {
	
	private String name;
	private String color;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}	

}
