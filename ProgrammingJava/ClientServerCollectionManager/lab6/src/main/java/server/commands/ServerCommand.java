package server.commands;

import common.product.Product;

public abstract class ServerCommand {
	private String errorMessage = "Команда выполнена без ошибок!";
	protected String response = "";
	public abstract String execute(Integer id, Product product);
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void addToResponse(String response) {
		this.response += response;
	}
}
