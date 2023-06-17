package server.commands;

import common.product.Product;
import server.MainCollection;
import server.ServerValidator;
import server.commands.ServerCommand;
import server.database.DBParser;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * Remove all objects with less key
 */
public class RemoveLowerKey extends ServerCommand {
    private final ServerValidator validator = new ServerValidator();
    DBParser parser = new DBParser(migrations);

    public RemoveLowerKey() {
    }
    
    @Override
    public String execute(Integer id, Product product, String login) throws SQLException{
        int size = MainCollection.getCollection().size();
        try {
            migrations.deleteFromProductWhere(id, migrations.getUserId(login));
            parser.parse();
            if (MainCollection.getCollection().size() < size) return "Коллекция была изменена!";
        } catch (NumberFormatException exception) {
            setErrorMessage("Этой команде необходимо передать параметр типа int!");
        }
       if (MainCollection.getCollection().lowerKey(id) != null) return "Коллекция не была изменена, отказано в доступе!";
       return "Коллекция не была изменена!";
    }
}