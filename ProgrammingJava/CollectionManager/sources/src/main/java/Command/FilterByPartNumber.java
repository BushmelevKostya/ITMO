package Command;

import Classes.Product;
import Collection.MainCollection;
import Exceptions.ExitException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Print all objects with a given PartNumber
 */
public class FilterByPartNumber extends Command {
    public FilterByPartNumber() {
    }

    /**
     * during execution need to enter value of PartNumber
     *
     * @param id is not used
     */
    @Override
    public void execute(String value) {
        TreeMap<Integer, Product> collection = MainCollection.getCollection();
        for (Integer key : collection.keySet()) {
            if (collection.get(key).getPartNumber().equals(value)) {
                System.out.printf(key + " : " + collection.get(key) + "\n");
            }
        }
    }
}