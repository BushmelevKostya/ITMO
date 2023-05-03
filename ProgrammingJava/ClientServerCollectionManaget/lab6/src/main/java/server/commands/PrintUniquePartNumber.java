package server.commands;

import common.product.Product;
import server.MainCollection;
import server.commands.ServerCommand;

import java.util.HashSet;

/**
 * Print all unique value of PartNumber
 */
public class PrintUniquePartNumber extends ServerCommand {
    public PrintUniquePartNumber() {
    }

    /**
     * @param id isn't used
     */
    @Override
    public String execute(Integer id, Product product) {
        HashSet<String> set = new HashSet<>();
        var collection = MainCollection.getCollection();
        for (Integer key : collection.keySet()) {
            set.add(collection.get(key).getPartNumber());
        }
        for (String element : set) {
            addToResponse(element);
        }
        return response;
    }
}