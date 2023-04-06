package Command;

import Collection.MainCollection;

import java.util.HashSet;

/**
 * Print all unique value of PartNumber
 */
public class PrintUniquePartNumber extends Command {
    public PrintUniquePartNumber() {
    }

    /**
     * @param id isn't used
     */
    @Override
    public void execute(String id) {
        HashSet<String> set = new HashSet<>();
        var collection = MainCollection.getCollection();
        for (Integer key : collection.keySet()) {
            set.add(collection.get(key).getPartNumber());
        }
        for (String element : set) {
            System.out.println(element);
        }
    }
}