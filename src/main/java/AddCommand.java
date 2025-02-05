public class AddCommand extends Command {
    private TaskType taskType;
    private String[] args;
    public AddCommand(TaskType taskType, String[] args) {
        this.taskType = taskType;
        this.args = args;
    }
    @Override
    public void execute(Ui ui, TaskList taskList, Storage storage) throws PixelException {
        String[] components;
        switch (this.taskType) {
        case TODO:
            components = Parser.parseToDo(this.args);
            ui.addResponse(taskList.addTask(new ToDo(components[0])), taskList.getListSize());
            break;
        case DEADLINE:
            components = Parser.parseDeadline(this.args);
            ui.addResponse(taskList.addTask(new Deadline(components[0],
                            Parser.parseDateTime(components[1]))),
                    taskList.getListSize());
            break;
        case EVENT:
            components = Parser.parseEvent(this.args);
            ui.addResponse(taskList.addTask(new Event(components[0],
                            Parser.parseDateTime(components[1]),
                            Parser.parseDateTime(components[2]))),
                    taskList.getListSize());
            break;
        default:
            throw new PixelException("Please enter a valid task type!");
        }
        storage.save(taskList);
    }
}
