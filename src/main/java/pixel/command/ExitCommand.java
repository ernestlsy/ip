package pixel.command;

import pixel.util.Storage;
import pixel.util.Ui;
import pixel.task.TaskList;

/**
 * Represents an exit Command to terminate Pixel.
 */
public class ExitCommand extends Command {
    /**
     * Initiates termination procedures by Ui class, then sets the isExit flag to true.
     *
     * @param ui Ui object for this instance of Pixel
     * @param taskList TaskList storing the tasks
     * @param storage Storage object handling disk storage for this instance of Pixel
     */
    @Override
    public void execute(Ui ui, TaskList taskList, Storage storage) {
        ui.exit();
        this.isExit = true;
    }
}
