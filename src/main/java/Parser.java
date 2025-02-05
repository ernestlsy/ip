import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Parser {
    public static LocalDateTime parseDateTime(String input) throws PixelException {
        String[] comp = input.split(" ");
        if (comp.length > 2) {
            throw new PixelException("Please use the format YYYY-MM-DD HH:MM for the date and time!");
        }
        try {
            if (comp.length == 1) {
                return LocalDateTime.parse(comp[0] + "T00:00");
            }
            return LocalDateTime.parse(comp[0] + "T" + comp[1]);
        } catch (DateTimeParseException e) {
            throw new PixelException("Please use the format YYYY-MM-DD HH:MM for the date and time!");
        }
    }

    public static String[] parseToDo(String[] commandComponents) throws PixelException {
        StringBuilder desc = new StringBuilder();
        for (int i = 1; i < commandComponents.length; i++) {
            desc.append(commandComponents[i]).append(" ");
        }
        if (desc.toString().isEmpty()) {
            throw new PixelException("Please include a description for the ToDo!");
        }
        return new String[] { desc.toString().strip() };
    }
    public static String[] parseDeadline(String[] commandComponents) throws PixelException {
        int i = 1;
        StringBuilder desc = new StringBuilder();
        StringBuilder dueBy = new StringBuilder();
        while (i < commandComponents.length) {
            if (commandComponents[i].equals("/by")) {
                i++;
                break;
            } else {
                desc.append(commandComponents[i]).append(" ");
                i++;
            }
        }
        while (i < commandComponents.length) {
            dueBy.append(commandComponents[i]).append(" ");
            i++;
        }
        if (desc.toString().isEmpty()) {
            throw new PixelException("Please include a description for the Deadline!");
        } else if (dueBy.toString().isEmpty()) {
            throw new PixelException("Please set a deadline using '/by' followed by a date/time!");
        }
        return new String[] { desc.toString().strip(), dueBy.toString().strip() };
    }
    public static String[] parseEvent(String[] commandComponents) throws PixelException {
        int i = 1;
        StringBuilder desc = new StringBuilder();
        StringBuilder from = new StringBuilder();
        StringBuilder to = new StringBuilder();
        while (i < commandComponents.length) {
            if (commandComponents[i].equals("/from")) {
                i++;
                break;
            } else {
                desc.append(commandComponents[i]).append(" ");
                i++;
            }
        }
        while (i < commandComponents.length) {
            if (commandComponents[i].equals("/to")) {
                i++;
                break;
            } else {
                from.append(commandComponents[i]).append(" ");
                i++;
            }
        }
        while (i < commandComponents.length) {
            to.append(commandComponents[i]).append(" ");
            i++;
        }
        if (desc.toString().isEmpty()) {
            throw new PixelException("Please include a description for the Event!");
        } else if (from.toString().isEmpty()) {
            throw new PixelException("Please set a starting date/time using '/from' followed by a date/time!");
        } else if (to.toString().isEmpty()) {
            throw new PixelException("Please set a ending date/time using '/to' followed by a date/time!");
        }
        return new String[] { desc.toString().strip(), from.toString().strip(), to.toString().strip() };
    }
    public static Command parseFullCommand(String input) throws PixelException {
        String[] components = input.split("\\s+");
        String keyword = components[0];
        try {
            switch (keyword) {
            case "bye":
                return new ExitCommand();
            case "list":
                return new ListCommand();
            case "todo":
                return new AddCommand(TaskType.TODO, components);
            case "deadline":
                return new AddCommand(TaskType.DEADLINE, components);
            case "event":
                return new AddCommand(TaskType.EVENT, components);
            case "mark":
                return new UpdateCommand(true, Integer.parseInt(components[1])-1);
            case "unmark":
                return new UpdateCommand(false, Integer.parseInt(components[1])-1);
            case "delete":
                return new DeleteCommand(Integer.parseInt(components[1])-1);
            default:
                throw PixelException.unknownInput();
            }
        } catch (NumberFormatException e) {
            throw new PixelException("Please input a valid task number!");
        }
    }
}
