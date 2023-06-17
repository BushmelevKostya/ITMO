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
    public String execute(Integer id, Product product, String login) {
        MainCollection.getCollection().values().stream()
                .map(Product::getPartNumber)
                .sorted()
                .forEach(partNumber -> addToResponse(partNumber + "   "));
        return response;
    }
}