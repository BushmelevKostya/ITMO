package IO;

import Command.*;
import Exceptions.*;

import java.io.*;
import java.util.HashMap;

public class Executor {
    private final HashMap<String, Command> commandMap;
    private final Validator validator = new Validator();

    public Executor() {
        commandMap = new HashMap<>();

        commandMap.put("help", new HelpCommand());
        commandMap.put("exit", new ExitCommand());
        commandMap.put("info", new InfoCommand());
        commandMap.put("show", new ShowCommand());
        commandMap.put("insert", new InsertCommand());
        commandMap.put("update", new UpdateCommand());
        commandMap.put("remove", new RemoveCommand());
        commandMap.put("clear", new ClearCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("execute", new ExecuteCommand());
        commandMap.put("replace_if_greater", new ReplaceIfGreater());
        commandMap.put("replace_if_lower", new ReplaceIfLower());
        commandMap.put("remove_lower_key", new RemoveLowerKey());
        commandMap.put("filter_by_part_number", new FilterByPartNumber());
        commandMap.put("print_unique_part_number", new PrintUniquePartNumber());
        commandMap.put("print_field_ascending_manufacturer", new PrintFieldAscendingManufacturer());
    }

    /**
     * this method use when program has been started
     */
    public void run() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Введите команду в формате: \"<команда> <ключ>\"");
            while (true) {
                try {
                    execute(br.readLine().strip());
                } catch (ExitException ignored) {
                }
            }
        } catch (
                IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * @param fileName filename file which execute
     * @see ExecuteCommand
     */

    public void runScript(String fileName) {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine().strip();
            while (line != null) {
                try {
                    executeScript(line, reader);
                    try {
                        line = reader.readLine().strip();
                    } catch (NullPointerException exception) {
                        line = null;
                    }
                } catch (NumberFormatException exception) {
                    System.out.println("Некорректные данные в файле " + fileName + " : " + exception.getMessage());
                    break;
                } catch (FalseValuesException | NullPointerException | IllegalArgumentException | FalseTypeException |
                         InfiniteException | UniqueException | NullStringException exception) {
                    System.out.println(exception.getMessage());
                    break;
                } catch (ExitException exception) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void execute(String str) throws ExitException {
        Reader reader = new Reader(str);
        String command = reader.getCommand();
        var value = reader.getValue();
        if (validator.check(str) && validator.checkCommand(command) && validator.checkParam(command, value)) {
            commandMap.get(command).execute(value);
        }
        System.out.println("\nВведите команду в формате: \"<команда> <ключ>\"");
    }

    public void executeScript(String str, BufferedReader bufferedReader) throws ExitException, IOException, NullPointerException, FalseValuesException, IllegalArgumentException, FalseTypeException, InfiniteException, UniqueException, NullStringException {
        Reader reader = new Reader(str);
        String command = reader.getCommand();
        var value = reader.getValue();
        if (validator.check(str) && validator.checkCommand(command) && validator.checkParam(command, value)) {
            if (!command.equals("insert")) {
                commandMap.get(command).execute(value);
            } else {
                new InsertScriptCommand(bufferedReader).execute(value);
            }
        } else {
            throw new ExitException();
        }
    }
}
