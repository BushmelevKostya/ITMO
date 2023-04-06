package Command;

import Exceptions.ExitException;
import IO.Executor;

import java.util.Stack;

/**
 * Execute script out of file
 * name of file - Script.txt
 */
public class ExecuteCommand extends Command {
    public static Stack<String> stack = new Stack<>();

    /**
     * during execution need to enter name of file
     *
     * @param value this id is not used
     */
    @Override
    public void execute(String value) throws ExitException {
        if (stack.contains(value)){
            System.out.println("Скрипты вызываются бескончено!");
            throw new ExitException();
        }
        stack.push(value);
        new Executor().runScript(value);
        stack.pop();
    }
}
