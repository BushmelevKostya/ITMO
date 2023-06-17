package server.commands;

import common.product.Organization;
import common.product.Product;
import server.MainCollection;
import server.commands.ServerCommand;

import java.util.ArrayList;

/**
 * Print information about all manufacturers
 */
public class PrintFieldAscendingManufacturer extends ServerCommand {

    public PrintFieldAscendingManufacturer() {
    }

    /**
     * @param id isn't used
     */
    @Override
    public String execute(Integer id, Product product, String login) {
        MainCollection.getCollection().values().stream()
                .map(Product::getManufacturer)
                .sorted(Organization::compareTo)
                .forEach(organization -> addToResponse(organization.toString() + "\n"));
        return response;
    }
}
