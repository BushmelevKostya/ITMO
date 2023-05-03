package common;

import common.product.Product;

import java.io.Serializable;

public class Response implements Serializable {
	private Product product;
	private String answer;
	
	public Response(String answer, Product product) {
		this.answer = answer;
		this.product = product;
	}
	
	public Response(){}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
