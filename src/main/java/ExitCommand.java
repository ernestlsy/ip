public class ExitCommand extends Command {
    @Override
    public void execute(Ui ui, TaskList taskList, Storage storage) {
        ui.exit();
        this.isExit = true;
    }
}
