package client.commands;

import client.ClientCommand;

import static java.lang.System.exit;

public class ExitCommand extends ClientCommand {

    public ExitCommand() {
    }

    @Override
    public void execute(String id) {
        exit(0);
    }
}
