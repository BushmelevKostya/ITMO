package server.commands;

import common.product.Product;
import server.MainCollection;

/**
 * Print all information about element collection
 */
public class ShowCommand extends ServerCommand {
	public ShowCommand() {
	}
	
	@Override
	public String execute(Integer id, Product product) {
		return MainCollection.printCollection();
	}
}