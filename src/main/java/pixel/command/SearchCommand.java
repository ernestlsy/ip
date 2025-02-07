package pixel.command;

import pixel.task.TaskList;
import pixel.util.Storage;
import pixel.util.Ui;

public class SearchCommand extends Command {
    private final String keyword;

    public SearchCommand(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void execute(Ui ui, TaskList taskList, Storage storage) {
        ui.searchResponse(taskList.searchTask(this.keyword));
    }
}
