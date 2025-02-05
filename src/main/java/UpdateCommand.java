public class UpdateCommand extends Command {
    private final boolean isCompleted;
    private final int taskIndex;
    public UpdateCommand(boolean isCompleted, int taskIndex) {
        this.isCompleted = isCompleted;
        this.taskIndex = taskIndex;
    }
    @Override
    public void execute(Ui ui, TaskList taskList, Storage storage) throws PixelException {
        if (isCompleted) {
            ui.markResponse(taskList.markTask(this.taskIndex));
        } else {
            ui.unmarkResponse(taskList.unmarkTask(this.taskIndex));
        }
        storage.save(taskList);
    }
}
