import java.util.Scanner;
public class Pixel {
    private static String wrap(String text) {
        return "________________________________ \n"
                + text + "\n________________________________ \n";
    }
    static String greet = wrap(" Hello! I'm your personal assistant, Pixel \n"
            + " How may I assist you?");
    static String bye = wrap(" Goodbye. Hope to see you again soon!");

    public static void main(String[] args) {
        TaskList tasklist = new TaskList();
        Scanner sc = new Scanner(System.in);

        System.out.println(greet);
        while (true) {
            String input = sc.nextLine();
            switch (input) {
                case "bye":
                    System.out.println(bye);
                    sc.close();
                    return;
                case "list":
                    System.out.println(wrap(tasklist.displayList()));
                    break;
                default:
                    System.out.println(wrap(tasklist.addTask(input)));
            }
        }
    }
}
