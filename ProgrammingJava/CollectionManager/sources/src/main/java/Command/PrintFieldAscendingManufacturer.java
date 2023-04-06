package Command;

import Classes.Organization;
import Collection.MainCollection;

import java.util.ArrayList;

/**
 * Print information about all manufacturers
 */
public class PrintFieldAscendingManufacturer extends Command {

    public PrintFieldAscendingManufacturer() {
    }

    /**
     * @param id isn't used
     */
    @Override
    public void execute(String id) {
        var collection = MainCollection.getCollection();
        var organizations = new ArrayList<Organization>();
        for (Integer key : collection.keySet()) {
            organizations.add(collection.get(key).getManufacturer());
        }
        var sortedOrganizations = Organization.sort(organizations);
        for (Organization organization : sortedOrganizations) {
            System.out.println(organization.toString());
        }
    }
}
