package pixel.task;

import java.util.ArrayList;

import pixel.util.PixelException;

/**
 * Represents a task list used to store and manage tasks from the user.
 */
public class TaskList {
    private final ArrayList<Task> contents = new ArrayList<>(100);

    /**
     * Returns the size of the list, which is the number of tasks in the list.
     *
     * @return Size of the list of tasks
     */
    public int getListSize() {
        return this.contents.size();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= this.contents.size(); i++) {
            String curr = i + ". " + this.contents.get(i - 1) + "\n";
            out.append(curr);
        }
        return out.toString();
    }

    /**
     * Adds the provided task to the list of tasks, then returns the Task.
     *
     * @param task Task to be added
     * @return The Task which was added
     */
    public Task addTask(Task task) {
        this.contents.add(task);
        return task;
    }

    /**
     * Marks the Task at the provided index as complete, then returns the Task.
     *
     * @param idx The index at which the Task to be marked is stored in the list
     * @return The Task which was marked
     * @throws PixelException If the index provided does not correspond to a Task
     */
    public Task markTask(int idx) throws PixelException {
        boolean indexOutOfRange = idx < 0 || idx >= this.contents.size();
        if (indexOutOfRange || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        this.contents.get(idx).markTask();
        return this.contents.get(idx);
    }

    /**
     * Marks the Task at the provided index as incomplete, then returns the Task.
     *
     * @param idx The index at which the Task to be marked is stored in the list
     * @return The Task which was marked
     * @throws PixelException If the index provided does not correspond to a Task
     */
    public Task unmarkTask(int idx) throws PixelException {
        boolean indexOutOfRange = idx < 0 || idx >= this.contents.size();
        if (indexOutOfRange || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        this.contents.get(idx).unmarkTask();
        return this.contents.get(idx);
    }

    /**
     * Removes the Task at the provided index from the list, then returns the Task.
     *
     * @param idx The index at which the Task to be removed is stored in the list
     * @return The Task which was removed
     * @throws PixelException If the index provided does not correspond to a Task
     */
    public Task deleteTask(int idx) throws PixelException {
        boolean indexOutOfRange = idx < 0 || idx >= this.contents.size();
        if (indexOutOfRange || this.contents.get(idx) == null) {
            throw new PixelException("Please input a valid task number!");
        }
        return this.contents.remove(idx);
    }

    public ArrayList<Task> searchTask(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : this.contents) {
            if (task.desc.contains(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }

    /**
     * Returns the contents of the TaskList in a format compatible for writing to a file in disk.
     *
     * @return Formatted contents of TaskList
     */
    public String toFileFormat() {
        StringBuilder out = new StringBuilder();
        for (int i = 1; i <= this.contents.size(); i++) {
            out.append(this.contents.get(i - 1).toFileFormat());
            out.append("\n");
        }
        out.append("EOF");
        return out.toString();
    }
}
