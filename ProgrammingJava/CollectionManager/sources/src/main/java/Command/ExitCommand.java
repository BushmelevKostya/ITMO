package Command;

import static java.lang.System.exit;

public class ExitCommand extends Command {

    public ExitCommand() {
    }

    @Override
    public void execute(String id) {
        exit(0);
    }
}
