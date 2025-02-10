package pixel.util;

import java.util.ArrayList;
import java.util.Scanner;

import pixel.task.Task;
import pixel.task.TaskList;

/**
 * Utility class which handles all functionality involving reading input from user and printing output.
 */
public class Ui {
    private Scanner sc;

    public Ui() {
        this.sc = new Scanner(System.in);
    }

    private static void wrapPrint(String text) {
        System.out.println("________________________________\n"
                + text + "\n________________________________\n");
    }

    /**
     * Reads a line of input from standard input.
     *
     * @return Input read from standard input, as a String
     * @throws PixelException If input is empty
     */
    public String read() throws PixelException {
        String input = sc.nextLine();
        if (input.isEmpty()) {
            throw new PixelException("Please provide a valid input!");
        } else {
            return input;
        }
    }

    /**
     * Prints greeting message.
     */
    public String greet() {
       return " Hello! I'm your personal assistant, Pixel\n" + " How may I assist you?";
    }

    /**
     * Prints exit message, and closes Scanner.
     */
    public String exit() {
        return " Goodbye. Hope to see you again soon!";
    }

    /**
     * Prints response informing user of successful task addition and the number of Tasks currently in the TaskList.
     *
     * @param task Task added to the TaskList
     * @param listSize Number of Tasks in the TaskList
     */
    public String addResponse(Task task, int listSize) {
        return String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list",
                task.toString(), listSize);
    }

    /**
     * Prints response informing user of successful task update.
     *
     * @param task Task marked as complete in the TaskList
     */
    public String markResponse(Task task) {
        return "Excellent, I've marked this task as done:\n  " + task.toString();
    }

    /**
     * Prints response informing user of successful task update.
     *
     * @param task Task marked as incomplete in the TaskList
     */
    public String unmarkResponse(Task task) {
        return "Alright, I've marked this task as not done yet:\n  " + task.toString();
    }

    /**
     * Prints response informing user of successful task deletion and the number of Tasks currently in the TaskList.
     *
     * @param task Task deleted from the TaskList
     * @param listSize Number of Tasks in the TaskList
     */
    public String deleteResponse(Task task, int listSize) {
        return String.format("No problem, I've removed the task from the list:\n  "
                + "%s\nNow you have %d tasks in the list", task.toString(), listSize);
    }

    /**
     * Prints the String representation of the TaskList, which displays the Tasks stored in the TaskList,
     * together with their details.
     *
     * @param taskList TaskList storing the Tasks
     */
    public String listResponse(TaskList taskList) {
        return "Here are the tasks in your list:\n" + taskList.toString();
    }

    public String searchResponse(ArrayList<Task> matchingTasks) {
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

    /**
     * Prints the error message of a PixelException.
     *
     * @param e PixelException thrown
     */
    public void exceptionResponse(PixelException e) {
        Ui.wrapPrint(e.getMessage());
    }
}
