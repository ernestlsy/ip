import java.util.Scanner;
public class Pixel {
    private static void wrapPrint(String text) {
        System.out.println("________________________________ \n"
                + text + "\n________________________________ \n");
    }
    static String greet = " Hello! I'm your personal assistant, Pixel \n"
            + " How may I assist you?";
    static String bye = " Goodbye. Hope to see you again soon!";

    public static void main(String[] args) {
        TaskList tasklist = new TaskList();
        Scanner sc = new Scanner(System.in);

        wrapPrint(greet);
        while (true) {
            String input = sc.nextLine();
            if (input.isEmpty()) {
                break;
            }
            String[] parts = input.split(" ");
            String keyword = parts[0];
            switch (keyword) {
                case "mark":
                    wrapPrint(tasklist.markTask(Integer.parseInt(parts[1]) - 1));
                    continue;
                case "unmark":
                    wrapPrint(tasklist.unmarkTask(Integer.parseInt(parts[1]) - 1));
                    continue;
                default:
            }
            switch (input) {
                case "bye":
                    wrapPrint(bye);
                    sc.close();
                    return;
                case "list":
                    wrapPrint(tasklist.toString());
                    break;
                default:
                    wrapPrint(tasklist.addTask(input));
            }
        }
    }
}
