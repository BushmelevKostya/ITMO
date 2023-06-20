package server.commands;

import common.product.Product;
import server.MainCollection;
import common.exception.NoElementException;
import common.exception.UniqueException;
import server.ServerValidator;

import java.sql.SQLException;

public class ReplaceIfGreaterServerCommand extends ServerCommand{
	private final ServerValidator validator = new ServerValidator();
	
	public ReplaceIfGreaterServerCommand()  {
	}
	
	public String execute(Integer id, Product product, String login) throws SQLException {
		try {
			validator.idExistCheck(id);
			validator.isFullNameUniqueUpdate(id, product.getManufacturer().getFullName());
			validator.isPartNumberUniqueUpdate(id, product.getPartNumber());
			if (!MainCollection.getCollection().get(id).compare(product)) {
				return new UpdateServerCommand().execute(id, product, login);
			}
		} catch (NumberFormatException exception) {
			setErrorMessage("Этой команде необходимо передать параметр типа int!");
		} catch (NoElementException | UniqueException exception) {
			setErrorMessage(exception.getMessage());
		}
		return "Объект в коллекции не был изменен!";
	}
}