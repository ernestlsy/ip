public class Event extends Task {
    String from;
    String to;
    private static String[] format(String[] comp) {
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
        return new String[] {desc.toString(), from.toString(), to.toString()};
    }
    public Event(String desc, String from, String to) {
        super(desc);
        this.from = from;
        this.to = to;
    }
    public Event(String[] comp) {
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
