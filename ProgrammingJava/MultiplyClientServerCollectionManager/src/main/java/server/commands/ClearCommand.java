package server.commands;

import common.product.Product;
import server.MainCollection;
import server.database.DBParser;
import server.database.Migrations;

import java.sql.SQLException;
import java.util.TreeMap;

/**
 * Clear colleciton
 */
public class ClearCommand extends ServerCommand {
    DBParser parser = new DBParser(DBParser.migrations);
    
    public ClearCommand() {
    }
    
    /**
     * @param id this id is not used
     */
    
    public String execute(Integer id, Product product, String login) throws SQLException {
        this.migrations.clearProductTable(migrations.getUserId(login));
        parser.parse();
        return "Очищены элементы коллекции, принадлежащие пользователю " + login + "!";
    }
}