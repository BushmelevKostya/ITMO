package Command;

import Collection.MainCollection;
import IO.JSONParser;
import com.sun.tools.javac.Main;

import java.io.IOException;

import static java.lang.System.exit;

/**
 * Save collection to file
 */
public class SaveCommand extends Command {
    public SaveCommand() {
    }

    /**
     * @param value this id isn't used
     */
    @Override
    public void execute(String value) {
        JSONParser parser = new JSONParser();
        try {
            parser.parseToFile(MainCollection.getCollection());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            exit(0);
        }
        System.out.println("Коллекция успешно сохранена!");
    }
}