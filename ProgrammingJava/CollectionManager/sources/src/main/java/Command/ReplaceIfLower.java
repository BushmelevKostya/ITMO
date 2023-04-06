package Command;

import Builder.Director;
import Builder.ProductBuilder;
import Collection.MainCollection;
import Exceptions.ExitException;
import IO.Validator;

import java.io.IOException;

/**
 * replace if new element has lower key
 */
public class ReplaceIfLower extends Command {
    Validator validator = new Validator();

    public ReplaceIfLower() {
    }

    /**
     * @param value id of the element being changed
     */
    @Override
    public void execute(String value) throws ExitException {
        try {
            var id = validator.checkParamType(value);
            if (validator.isId(id)) {
                var product = new Director(new ProductBuilder(id)).make();
                if (MainCollection.getCollection().get(id).compare(product)) {
                    new UpdateCommand().execute(id, product);
                }
            }
        } catch (NumberFormatException exception) {
            System.out.println("Этой команде необходимо передать параметр типа int!");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}