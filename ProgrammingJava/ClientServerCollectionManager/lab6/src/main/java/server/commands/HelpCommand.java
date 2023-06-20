package server.commands;

import client.ClientCommand;
import com.google.gson.Gson;
import common.product.Product;
import server.commands.ServerCommand;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Print all valid commands from file
 */
public class HelpCommand extends ServerCommand {
	private final HashMap<String, String> data = new HashMap<>();
	
	public HelpCommand() {
		try (BufferedReader br = new BufferedReader(new FileReader("./src/main/java/common/data/БД.json"))) {
			Gson gson = new Gson();
			var json = gson.fromJson(br, HashMap.class);
			for (Object key : json.keySet()) {
				data.put((String) key, (String) json.get(key));
			}
		} catch (IOException exception) {
			System.out.println(exception.getMessage());
		}
	}
	
	/**
	 * @param id isn't used
	 */
	public String execute(Integer id, Product product) {
		for (String key : data.keySet()) {
			addToResponse(key + " : " + data.get(key));
		}
		return response;
	}
}