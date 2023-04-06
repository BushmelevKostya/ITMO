/**
 * variant №313202
 *
 * @autor Bushmelev Kostya
 * the program implements the management of the elements of the collection
 * @see {Link to a documentation: {C:/Java/lab5/doc/index.html}
 */

import IO.Executor;
import IO.Starter;
import IO.Validator;

public class Main {
    public static void main(String[] args) {
        String fileName = new Validator().checkFileName(args);
        System.out.println("Добрый день! Используйте help для получения перечня команд.\n");
        new Starter(fileName.strip()).run();
        new Executor().run();
    }
}