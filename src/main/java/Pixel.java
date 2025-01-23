import java.util.Scanner;
public class Pixel {
    public static void main(String[] args) {
        String greet = "________________________________ \n"
                + " Hello! I'm your personal assistant, Pixel \n"
                + " How may I assist you? \n"
                + "________________________________ \n";
        String bye = "________________________________ \n"
                + " Goodbye. Hope to see you again soon! \n"
                + "________________________________ \n";
        System.out.println(greet);

        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("bye")) {
                System.out.println(bye);
                sc.close();
                break;
            } else {
                System.out.println("________________________________ \n"
                        + input + "\n________________________________ \n");
            }
        }
    }
}
