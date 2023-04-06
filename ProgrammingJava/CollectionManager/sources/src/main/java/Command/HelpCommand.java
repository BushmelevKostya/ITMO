package Command;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Print all valid commands from file
 */
public class HelpCommand extends Command {
    private final HashMap<String, String> data = new HashMap<>();

    public HelpCommand() {
        try (BufferedReader br = new BufferedReader(new FileReader("./src/main/java/Data/БД.json"))) {
            Gson gson = new Gson();
            var json = gson.fromJson(br, HashMap.class);
            for (Object key : json.keySet()) {
                data.put((String) key, (String) json.get(key));
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * @param id isn't used
     */
    public void execute(String id) {
        for (String key : data.keySet()) {
            System.out.println(key + " : " + data.get(key));
        }
    }
}