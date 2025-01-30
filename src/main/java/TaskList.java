import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskList {
    private ArrayList<Task> contents = new ArrayList<>(100);

    protected String addTask(Task task) {
        this.contents.add(task);
        saveToFile();
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
        saveToFile();
        return "Excellent, I've marked this task as done:\n  " + this.contents.get(idx);
    }
    protected String unmarkTask(int idx) throws PixelException {
        if (idx < 0 || idx >= this.contents.size() || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        this.contents.get(idx).unmarkTask();
        saveToFile();
        return "Alright, I've marked this task as not done yet:\n  " + this.contents.get(idx);
    }

    protected String deleteTask(int idx) throws PixelException {
        if (idx < 0 || idx >= this.contents.size() || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        Task task = this.contents.remove(idx);
        saveToFile();
        return String.format("No problem, I've removed the task from the list:\n  %s\nNow you have %d tasks in the list", task.toString(), this.contents.size());
    }

    private void saveToFile() {
        try {
            File directory = new File("./data");
            directory.mkdir();
            File file = new File("./data/Pixel.txt");
            file.createNewFile();
            FileWriter writer = new FileWriter("./data/Pixel.txt");
            writer.write(this.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
