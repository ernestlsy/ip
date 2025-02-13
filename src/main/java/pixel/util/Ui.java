package pixel.util;

import java.util.ArrayList;

import pixel.task.Task;
import pixel.task.TaskList;

/**
 * Utility class which handles all functionality involving reading input from user and formatting response.
 */
public class Ui {
    public static String GREET = " Hello! I'm your personal assistant, Pixel\n" + " How may I assist you?";
    public static String EXIT = " Goodbye. Hope to see you again soon!";

    /**
     * Returns response informing user of successful task addition and the number of Tasks currently in the TaskList.
     *
     * @param task Task added to the TaskList
     * @param listSize Number of Tasks in the TaskList
     * @return String response indicating successful task addition
     */
    public static String addResponse(Task task, int listSize) {
        return String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list",
                task.toString(), listSize);
    }

    /**
     * Returns response informing user of successful task update.
     *
     * @param task Task marked as complete in the TaskList
     * @return String response indicating successful task update
     */
    public static String markResponse(Task task) {
        return "Excellent, I've marked this task as done:\n  " + task.toString();
    }

    /**
     * Returns response informing user of successful task update.
     *
     * @param task Task marked as incomplete in the TaskList
     * @return String response indicating successful task update
     */
    public static String unmarkResponse(Task task) {
        return "Alright, I've marked this task as not done yet:\n  " + task.toString();
    }

    /**
     * Returns response informing user of successful task deletion and the number of Tasks currently in the TaskList.
     *
     * @param task Task deleted from the TaskList
     * @param listSize Number of Tasks in the TaskList
     * @return String response indicating successful task deletion
     */
    public static String deleteResponse(Task task, int listSize) {
        return String.format("No problem, I've removed the task from the list:\n  "
                + "%s\nNow you have %d tasks in the list", task.toString(), listSize);
    }

    /**
     * Returns the String representation of the details of all Tasks stored in the TaskList
     *
     * @param taskList TaskList storing the Tasks
     * @return String response containing details of all Tasks in the TaskList
     */
    public static String listResponse(TaskList taskList) {
        return "Here are the tasks in your list:\n" + taskList.toString();
    }

    /**
     * Returns the String representation of the details of all Tasks stored in the TaskList
     * that match the input keyword.
     *
     * @param matchingTasks ArrayList of matching tasks returned from TaskList class
     * @return String response containing details of all matching Tasks in the TaskList
     */
    public static String searchResponse(ArrayList<Task> matchingTasks) {
        if (!matchingTasks.isEmpty()) {
            StringBuilder out = new StringBuilder();
            for (int i = 1; i <= matchingTasks.size(); i++) {
                String curr = i + ". " + matchingTasks.get(i - 1) + "\n";
                out.append(curr);
            }
            return "Here are the tasks matching your description:\n" + out.toString();
        } else {
            return "There are no tasks matching your description.";
        }
    }
}
