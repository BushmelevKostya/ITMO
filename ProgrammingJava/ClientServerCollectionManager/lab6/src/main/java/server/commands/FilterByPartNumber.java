package server.commands;

import common.product.Product;
import server.MainCollection;

import java.util.TreeMap;

/**
 * Print all objects with a given PartNumber
 */
public class FilterByPartNumber extends ServerCommand {
    
    public FilterByPartNumber() {
    }

    /**
     * during execution need to enter value of PartNumber
     *
     * @param id is not used
     */
    @Override
    public String execute(Integer id, Product product) {
        TreeMap<Integer, Product> collection = MainCollection.getCollection();
        for (Integer key : collection.keySet()) {
            if (collection.get(key).getPartNumber().equals(id.toString())) {
                addToResponse(key + " : " + collection.get(key) + "\n");
            }
        }
        return response;
    }
    

}