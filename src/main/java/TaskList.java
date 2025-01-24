import java.util.ArrayList;
public class TaskList {
    private ArrayList<Task> contents = new ArrayList<>(100);

    protected String addTask(Task task) {
        this.contents.add(task);
        return String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list", task.toString(), this.contents.size());
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Here are the tasks in your list:\n");
        for (int i = 1; i <= this.contents.size(); i++) {
            String curr = i + ". " + this.contents.get(i-1) + "\n";
            out.append(curr);
        }
        return out.toString();
    }

    protected String markTask(int idx) throws PixelException {
        if (idx < 0 || idx >= this.contents.size() || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        this.contents.get(idx).markTask();
        return "Excellent, I've marked this task as done:\n  " + this.contents.get(idx);
    }
    protected String unmarkTask(int idx) throws PixelException {
        if (idx < 0 || idx >= this.contents.size() || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        this.contents.get(idx).unmarkTask();
        return "Alright, I've marked this task as not done yet:\n  " + this.contents.get(idx);
    }

    protected String deleteTask(int idx) throws PixelException {
        if (idx < 0 || idx >= this.contents.size() || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        Task task = this.contents.remove(idx);
        return String.format("No problem, I've removed the task from the list:\n  %s\nNow you have %d tasks in the list", task.toString(), this.contents.size());
    }
}
