package server.commands;

import common.product.Product;
import server.MainCollection;
import common.exception.NoElementException;
import common.exception.UniqueException;
import server.ServerValidator;

public class ReplaceIfLowerServerCommand extends ServerCommand{
	private final ServerValidator validator = new ServerValidator();
	
	public ReplaceIfLowerServerCommand() {
	}
	
	public String execute(Integer id, Product product){
		try {
			validator.idExistCheck(id);
			validator.isPartNumberUnique(product.getPartNumber());
			validator.isIdUnique(product.getManufacturer().getId());
			validator.isFullNameUnique(product.getManufacturer().getFullName());
			if (MainCollection.getCollection().get(id).compare(product)) {
				new UpdateServerCommand().execute(id, product);
				return "Объект в коллекции был изменен!";
			}
		} catch (NumberFormatException exception) {
			setErrorMessage("Этой команде необходимо передать параметр типа int!");
		} catch (UniqueException | NoElementException exception) {
			setErrorMessage(exception.getMessage());
		}
		return "Объект в коллекции не был изменен!";
	}
}