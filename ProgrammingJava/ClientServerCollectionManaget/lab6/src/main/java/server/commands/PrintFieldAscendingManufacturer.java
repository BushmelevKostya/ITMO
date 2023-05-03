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
    public String execute(Integer id, Product product) {
        var collection = MainCollection.getCollection();
        var organizations = new ArrayList<Organization>();
        for (Integer key : collection.keySet()) {
            organizations.add(collection.get(key).getManufacturer());
        }
        var sortedOrganizations = Organization.sort(organizations);
        for (Organization organization : sortedOrganizations) {
            addToResponse(organization.toString());
        }
        return response;
    }
}
