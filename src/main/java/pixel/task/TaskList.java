package pixel.task;

import java.util.ArrayList;
import pixel.util.PixelException;

public class TaskList {
    private final ArrayList<Task> contents = new ArrayList<>(100);
    public int getListSize() {
        return this.contents.size();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= this.contents.size(); i++) {
            String curr = i + ". " + this.contents.get(i-1) + "\n";
            out.append(curr);
        }
        return out.toString();
    }

    public Task addTask(Task task) {
        this.contents.add(task);
        return task;
    }

    public Task markTask(int idx) throws PixelException {
        if (idx < 0 || idx >= this.contents.size() || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        this.contents.get(idx).markTask();
        return this.contents.get(idx);
    }
    public Task unmarkTask(int idx) throws PixelException {
        if (idx < 0 || idx >= this.contents.size() || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        this.contents.get(idx).unmarkTask();
        return this.contents.get(idx);
    }

    public Task deleteTask(int idx) throws PixelException {
        if (idx < 0 || idx >= this.contents.size() || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        return this.contents.remove(idx);
    }

    public String toFileFormat() {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= this.contents.size(); i++) {
            out.append(this.contents.get(i-1).toFileFormat());
            out.append("\n");
        }
        out.append("EOF");
        return out.toString();
    }
}
