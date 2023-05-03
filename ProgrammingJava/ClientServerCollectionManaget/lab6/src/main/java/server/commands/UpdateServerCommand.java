package server.commands;

import common.product.Product;
import server.MainCollection;

import java.util.TreeMap;

public class UpdateServerCommand extends ServerCommand {
	
	public UpdateServerCommand() {
	}
	
	public String execute(Integer id, Product product) {
		TreeMap<Integer, Product> collection = MainCollection.getCollection();
		collection.remove(id);
		collection.put(id, product);
		MainCollection.setCollection(collection);
		return "Элемент коллекции обновлен!";
	}
}