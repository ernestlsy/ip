public class TaskList {
    private Task[] contents = new Task[100];
    private int count = 0;

    protected String addTask(String taskDesc) {
        this.contents[count] = new Task(taskDesc);
        this.count++;
        return "added: " + taskDesc;
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= this.count; i++) {
            String curr = i + ". " + this.contents[i-1] + "\n";
            out.append(curr);
        }
        return out.toString();
    }

    protected String markTask(int idx) {
        this.contents[idx].markTask();
        return "Excellent, I've marked this task as done:\n  " + this.contents[idx];
    }
    protected String unmarkTask(int idx) {
        this.contents[idx].unmarkTask();
        return "Alright, I've marked this task as not done yet:\n  " + this.contents[idx];
    }
}
