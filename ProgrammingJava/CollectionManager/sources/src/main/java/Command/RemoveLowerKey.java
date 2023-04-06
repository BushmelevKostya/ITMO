package Command;

import Classes.Product;
import Collection.MainCollection;
import IO.Validator;

import java.util.TreeMap;

/**
 * Remove all objects with less key
 */
public class RemoveLowerKey extends Command {
    Validator validator = new Validator();

    public RemoveLowerKey() {
    }

    /**
     * @param value all objects with less key removed
     */
    @Override
    public void execute(String value) {
        TreeMap<Integer, Product> collection = new TreeMap<>();
        TreeMap<Integer, Product> iterCollection = MainCollection.getCollection();
        try {
            var id = validator.checkParamType(value);
            for (Integer key : iterCollection.keySet()) {
                if (key.compareTo(id) >= 0) {
                    collection.put(key, iterCollection.get(key));
                }
            }
            MainCollection.setCollection(collection);
        } catch (NumberFormatException exception) {
            System.out.println("Этой команде необходимо передать параметр типа int!");
        }
    }
}