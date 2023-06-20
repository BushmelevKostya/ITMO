package server;

import common.product.Product;
import common.exception.ExitException;
import common.exception.FalseValuesException;
import common.exception.NoElementException;
import common.exception.UniqueException;
import server.commands.*;

import java.sql.SQLException;
import java.util.HashMap;

public class CommandExecutor {
	private final String command;
	private final String value;
	private final HashMap<String, ServerCommand> commandMap;
	private final Product product;
	
	public CommandExecutor(String command, String value, Product product) {
		this.command = command;
		this.value = value;
		this.product = product;
		this.commandMap = new ServerCommandMap().getMap();
	}
	
	public String run(String login) throws ExitException, NumberFormatException, FalseValuesException, UniqueException, NoElementException, SQLException {
		var executeCommand = commandMap.get(command);
		Integer id = null;
		if (value != null) {
			id = Integer.parseInt(value);
		}
		String answer = executeCommand.execute(id, product, login);
		return executeCommand.getErrorMessage() + "\n" + answer;
	}
	
	public String getCommand() {
		return command;
	}
	
	public String getValue() {
		return value;
	}
}
