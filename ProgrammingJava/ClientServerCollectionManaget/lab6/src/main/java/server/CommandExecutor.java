package server;

import common.product.Product;
import common.exception.ExitException;
import common.exception.FalseValuesException;
import common.exception.NoElementException;
import common.exception.UniqueException;
import server.commands.*;

import java.util.HashMap;

public class CommandExecutor {
	private final String command;
	private final String value;
	private final HashMap<String, ServerCommand> commandMap = new ServerCommandMap().getMap();
	private final Product product;
	
	public CommandExecutor(String command, String value, Product product) {
		this.command = command;
		this.value = value;
		this.product = product;
	}
	
	public String run() throws ExitException, NumberFormatException, FalseValuesException, UniqueException, NoElementException {
		var executeCommand = commandMap.get(command);
		Integer id = null;
		if (this.product != null) id = this.product.getId();
		String answer = executeCommand.execute(id, product);
		return executeCommand.getErrorMessage() + "\n" + answer;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getValue() {
		return value;
	}
}
