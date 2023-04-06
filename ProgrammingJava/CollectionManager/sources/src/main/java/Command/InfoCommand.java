package Command;

import Collection.MainCollection;

/**
 * Print info about collection
 */
public class InfoCommand extends Command {
    public InfoCommand() {
    }

    /**
     * @param id isn't used
     */
    @Override
    public void execute(String id) {
        System.out.println("Класс коллекции: " + MainCollection.getType());
        System.out.println("Время создания коллекции: " + MainCollection.getTime());
        System.out.println("В коллекции элементов: " + MainCollection.getSize());
    }
}
