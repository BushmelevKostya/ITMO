package Command;

import Builder.Director;
import Builder.ProductBuilder;
import Classes.Product;
import Collection.MainCollection;
import IO.Validator;

import java.util.TreeMap;

/**
 * Remove command with received key
 */
public class RemoveCommand extends Command {
    Validator validator = new Validator();

    public RemoveCommand() {
    }

    /**
     * @param value key is id identifier removed element
     */
    @Override
    public void execute(String value) {
        try {
            var key = validator.checkParamType(value);
            if (validator.isId(key)) {
                TreeMap<Integer, Product> collection = MainCollection.getCollection();
                collection.remove(key);
                MainCollection.setCollection(collection);
            }
        } catch (NumberFormatException exception){
            System.out.println("Этой команде необходимо передать параметр типа int!");
        }
    }
}