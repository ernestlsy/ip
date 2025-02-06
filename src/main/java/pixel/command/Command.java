package pixel.command;

import pixel.util.Storage;
import pixel.util.Ui;
import pixel.util.PixelException;
import pixel.task.TaskList;

/**
 * Represents the structure of a Command entered by the user, which performs a function when executed.
 */
abstract public class Command {
    protected boolean isExit = false;
    abstract public void execute(Ui ui, TaskList taskList, Storage storage) throws PixelException;
    /**
     * Returns whether this Command is an ExitCommand
     *
     * @return isExit boolean
     */
    public boolean isExit() {
        return this.isExit;
    }
}
