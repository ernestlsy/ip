package pixel.command;

import pixel.util.Storage;
import pixel.util.Ui;
import pixel.util.PixelException;
import pixel.task.TaskList;

abstract public class Command {
    protected boolean isExitCommand = false;

    abstract public void execute(Ui ui, TaskList taskList, Storage storage) throws PixelException;

    public boolean isExitCommand() {
        return this.isExitCommand;
    }

}
