package Command;

import Collection.MainCollection;

import java.util.TreeMap;

/**
 * Clear colleciton
 */
public class ClearCommand extends Command {
    public ClearCommand() {
    }

    /**
     * @param id this id is not used
     */
    @Override
    public void execute(String id) {
        MainCollection.setCollection(new TreeMap<>());
    }
}