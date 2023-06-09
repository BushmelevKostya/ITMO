package common.client.commands;

import common.client.ClientCommand;
import common.client.ClientExecutor;
import common.exception.ExitException;

import java.util.Stack;

/**
 * Execute script out of file
 * name of file - Script.txt
 */
public class ExecuteClientCommand extends ClientCommand {
    public static Stack<String> stack = new Stack<>();

    /**
     * during execution need to enter name of file
     *
     * @param value this id is not used
     */
    @Override
    public void execute(String value) throws ExitException {
        if (stack.contains(value)){
            System.out.println("Скрипты вызываются бесконечно!");
            throw new ExitException();
        }
        stack.push(value);
        new ClientExecutor().runScript(value);
        stack.pop();
    }
}
