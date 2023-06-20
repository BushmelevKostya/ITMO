package common;

import common.product.Product;

import java.io.Serializable;

public class Request implements Serializable {
	private final String command;
	private final String value;
	private Product product;
	private String RequestType;
	
	public Request(String command, String value) {
		this.command = command;
		this.value = value;
		this.product = null;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getValue() {
		return value;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getRequestType() {
		return RequestType;
	}
	
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
}
