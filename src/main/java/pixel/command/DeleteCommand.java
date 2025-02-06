package pixel.command;

import pixel.util.Storage;
import pixel.util.Ui;
import pixel.util.PixelException;
import pixel.task.TaskList;

public class DeleteCommand extends Command {
    private final int taskIndex;

    public DeleteCommand(int taskIndex) {
        this.taskIndex = taskIndex;
    }

    @Override
    public void execute(Ui ui, TaskList taskList, Storage storage) throws PixelException {
        ui.deleteResponse(taskList.deleteTask(this.taskIndex), taskList.getListSize());
        storage.save(taskList);
    }
}
