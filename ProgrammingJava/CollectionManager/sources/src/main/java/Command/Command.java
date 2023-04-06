package Command;

import Exceptions.ExitException;

public abstract class Command {
    public abstract void execute(String value) throws ExitException;
}
