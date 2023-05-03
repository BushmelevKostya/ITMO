package server.commands;

import common.product.Product;
import server.MainCollection;
import server.ServerValidator;
import server.commands.ServerCommand;

import java.util.TreeMap;

/**
 * Remove all objects with less key
 */
public class RemoveLowerKey extends ServerCommand {
    private final ServerValidator validator = new ServerValidator();

    public RemoveLowerKey() {
    }
    
    @Override
    public String execute(Integer id, Product product) {
        TreeMap<Integer, Product> collection = new TreeMap<>();
        TreeMap<Integer, Product> iterCollection = MainCollection.getCollection();
        boolean f = false;
        try {
            for (Integer key : iterCollection.keySet()) {
                if (key.compareTo(id) >= 0) {
                    collection.put(key, iterCollection.get(key));
                    f = true;
                }
            }
            MainCollection.setCollection(collection);
            if (f) return "Коллекция была изменена!";
        } catch (NumberFormatException exception) {
            setErrorMessage("Этой команде необходимо передать параметр типа int!");
        }
        return "Коллекция не была изменена!";
    }
}