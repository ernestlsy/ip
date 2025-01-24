public class Event extends Task {
    String from;
    String to;
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
    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }
    public Event(String[] comp) throws PixelException {
        super(Event.format(comp)[0]);
        String[] temp = Event.format(comp);
        this.from = temp[1];
        this.to = temp[2];
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), this.from, this.to);
    }
}
