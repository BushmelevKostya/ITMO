package common.client.commands;

import common.client.ClientCommand;

import static java.lang.System.exit;

public class ExitCommand extends ClientCommand {

    public ExitCommand() {
    }

    @Override
    public void execute(String id) {
        exit(0);
    }
}
