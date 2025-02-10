package pixel.command;

import pixel.task.TaskList;
import pixel.util.Storage;
import pixel.util.Ui;

/**
 * Represents a Command for displaying contents of the TaskList.
 */
public class ListCommand extends Command {
    /**
     * Calls method from Ui class to print the contents of the TaskList.
     *
     * @param ui Ui object for this instance of Pixel
     * @param taskList TaskList storing the tasks
     * @param storage Storage object handling disk storage for this instance of Pixel
     */
    @Override
    public String execute(Ui ui, TaskList taskList, Storage storage) {
        return ui.listResponse(taskList);
    }
}
