package server.commands;

import common.product.Product;
import server.MainCollection;
import server.ServerValidator;
import server.commands.ServerCommand;

import java.util.TreeMap;

/**
 * Remove command with received key
 */
public class RemoveCommand extends ServerCommand {
    private final ServerValidator validator = new ServerValidator();

    public RemoveCommand() {
    }

    @Override
    public String execute(Integer id, Product product) {
        try {
            if (validator.isId(id)) {
                TreeMap<Integer, Product> collection = MainCollection.getCollection();
                collection.remove(id);
                MainCollection.setCollection(collection);
                return "Элемент коллекции был удален!";
            }
        } catch (NumberFormatException exception){
            setErrorMessage("Этой команде необходимо передать параметр типа int!");
        }
        return "Элемент коллекции не был удален!";
    }
}