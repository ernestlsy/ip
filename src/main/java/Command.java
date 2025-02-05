abstract public class Command {
    protected boolean isExit = false;
    abstract void execute(Ui ui, TaskList taskList, Storage storage) throws PixelException;
    public boolean isExit() {
        return this.isExit;
    }

}
