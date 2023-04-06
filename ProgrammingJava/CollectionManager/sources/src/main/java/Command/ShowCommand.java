package Command;

import Collection.MainCollection;

/**
 * Print all information about element collection
 */
public class ShowCommand extends Command {
    public ShowCommand() {
    }

    /**
     * @param value this id isn't used
     */
    @Override
    public void execute(String value) {
        MainCollection.printCollection();
    }
}