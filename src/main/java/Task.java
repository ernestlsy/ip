public class Task {
    protected String desc;
    protected boolean isDone;

    public Task(String desc) {
        this.desc = desc;
        this.isDone = false;
    }

    private String getStatusIcon() {
        return this.isDone ? "[X]" : "[ ]";
    }

    protected void markTask() {
        this.isDone = true;
    }
    protected void unmarkTask() {
        this.isDone = false;
    }

    protected String getDesc() {
        return this.desc;
    }

    @Override
    public String toString() {
        return this.getStatusIcon() + " " + this.desc;
    }
}
