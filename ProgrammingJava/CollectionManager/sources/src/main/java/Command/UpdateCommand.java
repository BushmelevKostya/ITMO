package Command;

import Builder.Director;
import Builder.ProductBuilder;
import Classes.Product;
import Collection.MainCollection;
import Exceptions.ExitException;
import IO.Validator;

import java.util.TreeMap;

/**
 * Replace old element new
 */
public class UpdateCommand extends Command {
    Validator validator = new Validator();

    public UpdateCommand() {
    }

    /**
     * @param value id of the element being changed
     */
    @Override
    public void execute(String value) throws ExitException {
        try {
            var id = validator.checkParamType(value);
            var product = validator.getById(id);
            if (product != null) {
                TreeMap<Integer, Product> collection = MainCollection.getCollection();
                var newCollection = new Director(new ProductBuilder(id)).make(product);
                collection.remove(id);
                collection.put(id, newCollection);
                MainCollection.setCollection(collection);
            }
        } catch (NumberFormatException exception) {
            System.out.println("Этой команде необходимо передать параметр типа int!");
        }
    }

    /**
     * @param id      id of the element being changed
     * @param product new value if it already exists
     */
    public void execute(Integer id, Product product) {
        if (validator.isId(id)) {
            TreeMap<Integer, Product> collection = MainCollection.getCollection();
            collection.remove(id);
            collection.put(id, product);
            MainCollection.setCollection(collection);
        }
    }
}