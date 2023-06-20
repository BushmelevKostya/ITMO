package server.commands;

import common.product.Product;
import server.database.DBParser;

import java.sql.SQLException;

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