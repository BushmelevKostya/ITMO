package server.commands;

import client.builder.ProductBuilder;
import common.product.Product;
import server.MainCollection;
import common.exception.FalseValuesException;
import common.exception.UniqueException;
import server.ServerValidator;

/**
 * Add new element to collection
 *
 * @see ProductBuilder
 */
public class InsertServerCommand extends ServerCommand{
	
	private final ServerValidator validator = new ServerValidator();
	
	public InsertServerCommand() {
	}
	
//	/**
//	 * @param value this id is key of new collection's element
//	 */

	public String execute(Integer id, Product product) throws NumberFormatException {
		try {
			validator.idCheck(id);
			validator.isPartNumberUnique(product.getPartNumber());
			validator.isIdUnique(product.getManufacturer().getId());
			validator.isFullNameUnique(product.getManufacturer().getFullName());
			MainCollection.getCollection().put(id, product);
			return "В коллекцию был добавлен новый продукт!";
		} catch (NumberFormatException exception) {
			setErrorMessage("Этой команде необходимо передать параметр типа int!");
		} catch (UniqueException | FalseValuesException exception) {
			setErrorMessage(exception.getMessage());
		}
		return "В коллекцию новый продукт добавлен не был!";
	}
}