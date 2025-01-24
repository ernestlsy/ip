public class TaskList {
    private Task[] contents = new Task[100];
    private int count = 0;

    protected String addTask(Task task) {
        this.contents[count] = task;
        this.count++;
        return String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list", task.toString(), this.count);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 1; i <= this.count; i++) {
            String curr = i + ". " + this.contents[i-1] + "\n";
            out.append(curr);
        }
        return out.toString();
    }

    protected String markTask(int idx) throws PixelException {
        if (idx <= 0 || idx >= this.count || this.contents[idx] == null) {
            throw new PixelException("Please input a valid task number!");
        }
        this.contents[idx].markTask();
        return "Excellent, I've marked this task as done:\n  " + this.contents[idx];
    }
    protected String unmarkTask(int idx) throws PixelException {
        if (idx <= 0 || idx >= this.count || this.contents[idx] == null) {
            throw new PixelException("Please input a valid task number!");
        }
        this.contents[idx].unmarkTask();
        return "Alright, I've marked this task as not done yet:\n  " + this.contents[idx];
    }
}
