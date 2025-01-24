public class ToDo extends Task {
    private static String format(String[] comp) throws PixelException {
        StringBuilder desc = new StringBuilder();
        for (int i = 1; i < comp.length; i++) {
            desc.append(comp[i]).append(" ");
        }
        if (desc.toString().isEmpty()) {
            throw new PixelException("Please include a description for the ToDo!");
        }
        return desc.toString().strip();
    }

    public ToDo(String desc) {
        super(desc);
    }
    public ToDo(String[] comp) throws PixelException {
        super(ToDo.format(comp));
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
