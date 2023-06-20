package server.commands;

import common.product.Product;
import server.MainCollection;

import java.util.TreeMap;

/**
 * Clear colleciton
 */
public class ClearCommand extends ServerCommand {
    
    public ClearCommand() {
    }

    /**
     * @param id this id is not used
     */
    
    public String execute(Integer id, Product product) {
        MainCollection.setCollection(new TreeMap<>());
        return "Коллекция очищена!";
    }
}