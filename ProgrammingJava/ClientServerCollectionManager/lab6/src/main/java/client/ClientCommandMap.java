package client;

import client.commands.ExecuteClientCommand;
import client.commands.InsertClientCommand;
import client.commands.ReplaceCommand;

import java.util.HashMap;

public class ClientCommandMap {
	private final HashMap<String, ClientCommand> commandMap;
	
	public ClientCommandMap() {
		commandMap = new HashMap<>();
		
		commandMap.put("insert", new InsertClientCommand());
		commandMap.put("replace_if_greater", new ReplaceCommand());
		commandMap.put("replace_if_lower", new ReplaceCommand());
		commandMap.put("update", new ReplaceCommand());
		commandMap.put("execute", new ExecuteClientCommand());
	}
	
	public HashMap<String, ClientCommand> getMap(){
		return this.commandMap;
	}
}
