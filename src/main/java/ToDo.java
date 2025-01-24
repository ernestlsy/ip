public class ToDo extends Task {
    private static String format(String[] comp) {
        StringBuilder desc = new StringBuilder();
        for (int i = 1; i < comp.length; i++) {
            desc.append(comp[i]).append(" ");
        }
        return desc.toString().strip();
    }

    public ToDo(String desc) {
        super(desc);
    }
    public ToDo(String[] comp) {
        super(ToDo.format(comp));
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
