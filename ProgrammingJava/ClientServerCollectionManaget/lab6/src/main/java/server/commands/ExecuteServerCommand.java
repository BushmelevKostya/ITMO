package server.commands;

import client.ClientExecutor;
import common.exception.ExitException;
import common.product.Product;

import java.util.Stack;

/**
 * Execute script out of file
 * name of file - Script.txt
 */
public class ExecuteServerCommand extends ServerCommand {
    public static Stack<String> stack = new Stack<>();


    public String execute(Integer id, Product product) {
        return "";
    }
}
