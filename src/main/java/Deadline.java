public class Deadline extends Task {
    String dueBy;
    private static String[] format(String[] comp) {
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
        return new String[] {desc.toString(), dueBy.toString()};
    }

    public Deadline(String desc, String dueBy) {
        super(desc);
        this.dueBy = dueBy;
    }
    public Deadline(String[] comp) {
        super(Deadline.format(comp)[0]);
        this.dueBy = Deadline.format(comp)[1];
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), this.dueBy);
    }
}
