package server.commands;

import common.exception.FalseValuesException;
import common.exception.NoElementException;
import common.product.Product;
import server.database.DBParser;
import server.database.Migrations;

import java.sql.SQLException;

public abstract class ServerCommand {
	private String errorMessage = "Команда выполнена без ошибок!";
	protected String response = "";
	protected final Migrations migrations = DBParser.migrations;
	
	public ServerCommand() {
	}
	
	public abstract String execute(Integer id, Product product, String login) throws FalseValuesException, SQLException;
	
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
