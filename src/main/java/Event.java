import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    LocalDateTime from;
    LocalDateTime to;
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
        StringBuilder from = new StringBuilder();
        StringBuilder to = new StringBuilder();
        while (idx < comp.length) {
            if (comp[idx].equals("/from")) {
                idx++;
                break;
            } else {
                desc.append(comp[idx]).append(" ");
                idx++;
            }
        }
        while (idx < comp.length) {
            if (comp[idx].equals("/to")) {
                idx++;
                break;
            } else {
                from.append(comp[idx]).append(" ");
                idx++;
            }
        }
        while (idx < comp.length) {
            to.append(comp[idx]).append(" ");
            idx++;
        }
        if (desc.toString().isEmpty()) {
            throw new PixelException("Please include a description for the Event!");
        } else if (from.toString().isEmpty()) {
            throw new PixelException("Please set a starting date/time using '/from' followed by a date/time!");
        } else if (to.toString().isEmpty()) {
            throw new PixelException("Please set a ending date/time using '/to' followed by a date/time!");
        }
        return new String[] {desc.toString().strip(), from.toString().strip(), to.toString().strip()};
    }
    public Event(String desc, LocalDateTime from, LocalDateTime to) {
        super(desc);
        this.from = from;
        this.to = to;
    }
    public Event(String[] comp) throws PixelException {
        super(Event.format(comp)[0]);
        String[] temp = Event.format(comp);
        this.from = parseDateTime(temp[1]);
        this.to = parseDateTime(temp[2]);
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(),
                this.from.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")),
                this.to.format(DateTimeFormatter.ofPattern("MMM d yyyy HH:mm")));
    }
}
