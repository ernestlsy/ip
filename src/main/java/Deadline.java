import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    LocalDateTime dueBy;
    private static LocalDateTime parseDateTime(String input) throws PixelException {
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
    private static String[] format(String[] comp) throws PixelException {
        int idx = 1;
        StringBuilder desc = new StringBuilder();
        StringBuilder dueBy = new StringBuilder();
        while (idx < comp.length) {
            if (comp[idx].equals("/by")) {
                idx++;
                break;
            } else {
                desc.append(comp[idx]).append(" ");
                idx++;
            }
        }
        while (idx < comp.length) {
            dueBy.append(comp[idx]).append(" ");
            idx++;
        }
        if (desc.toString().isEmpty()) {
            throw new PixelException("Please include a description for the Deadline!");
        } else if (dueBy.toString().isEmpty()) {
            throw new PixelException("Please set a deadline using '/by' followed by a date/time!");
        }
        return new String[] {desc.toString().strip(), dueBy.toString().strip()};
    }

    public Deadline(String desc, LocalDateTime dueBy) {
        super(desc);
        this.dueBy = dueBy;
    }
    public Deadline(String[] comp) throws PixelException {
        super(Deadline.format(comp)[0]);
        this.dueBy = parseDateTime(Deadline.format(comp)[1]);
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(),
                this.dueBy.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")));
    }
}
