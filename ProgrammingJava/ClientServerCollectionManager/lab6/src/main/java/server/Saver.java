package server;

import java.io.IOException;

import static java.lang.System.exit;

/**
 * Save collection to file
 */
public class Saver{
    public Saver() {
    }
    
    public static void save() {
        JSONParser parser = new JSONParser();
        try {
            parser.parseToFile(MainCollection.getCollection());
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            exit(0);
        }
    }
}