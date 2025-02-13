package pixel.task;

public class ToDo extends Task {
    public ToDo(String desc) {
        super(desc);
    }

    public ToDo(String desc, boolean isDone) {
        super(desc, isDone);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String toFileFormat() {
        return String.format("todo\n%s\n%s", this.desc, this.isDone);
    }
}
