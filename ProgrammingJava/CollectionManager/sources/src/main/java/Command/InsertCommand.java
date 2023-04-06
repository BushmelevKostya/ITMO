package Command;

import Builder.Director;
import Builder.ProductBuilder;
import Collection.MainCollection;
import Exceptions.ExitException;
import Exceptions.FalseValuesException;
import IO.Validator;

import java.io.IOException;

/**
 * Add new element to collection
 *
 * @see ProductBuilder
 */
public class InsertCommand extends Command {

    private final Validator validator = new Validator();

    public InsertCommand() {
    }

    /**
     * @param value this id is key of new collection's element
     */
    @Override
    public void execute(String value) throws ExitException {
        try {
            var id = validator.checkParamType(value);
            validator.idCheck(id);
            MainCollection.getCollection().put(id, new Director(new ProductBuilder(id)).make());
        } catch (NumberFormatException exception) {
            System.out.println("Этой команде необходимо передать параметр типа int!");
        } catch (FalseValuesException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}