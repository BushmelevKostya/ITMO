package server.commands;

import common.product.Product;
import server.MainCollection;

import java.awt.*;
import java.util.Arrays;
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
    public String execute(Integer id, Product product, String login) {
    
        MainCollection.getCollection().entrySet().stream()
            .filter(entry -> entry.getValue().getPartNumber().equals(id.toString()))
            .forEach(entry -> addToResponse(entry.getKey() + " ->\n" + entry.getValue() + "\n"));
        
        return response;
    }
    

}