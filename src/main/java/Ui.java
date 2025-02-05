import java.util.Scanner;
public class Ui {
    private Scanner sc;
    public Ui() {
        this.sc = new Scanner(System.in);
    }
    public static void wrapPrint(String text) {
        System.out.println("________________________________\n"
                + text + "\n________________________________\n");
    }
    public String read() throws PixelException {
        String input = sc.nextLine();
        if (input.isEmpty()) {
            throw new PixelException("Please provide a valid input!");
        } else {
            return input;
        }
    }

    public void greet() {
        Ui.wrapPrint(" Hello! I'm your personal assistant, Pixel\n" + " How may I assist you?");
    }
    public void exit() {
        Ui.wrapPrint(" Goodbye. Hope to see you again soon!");
        this.sc.close();
    }
    public void addResponse(Task task, int listSize) {
        Ui.wrapPrint(String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list", task.toString(), listSize));
    }
    public void markResponse(Task task) {
        Ui.wrapPrint("Excellent, I've marked this task as done:\n  " + task.toString());
    }
    public void unmarkResponse(Task task) {
        Ui.wrapPrint("Alright, I've marked this task as not done yet:\n  " + task.toString());
    }
    public void deleteResponse(Task task, int listSize) {
        Ui.wrapPrint(String.format("No problem, I've removed the task from the list:\n  %s\nNow you have %d tasks in the list", task.toString(), listSize));
    }
    public void listResponse(TaskList taskList) {
        Ui.wrapPrint("Here are the tasks in your list:\n" + taskList.toString());
    }
    public void exceptionResponse(PixelException e) {
        Ui.wrapPrint(e.getMessage());
    }
}
