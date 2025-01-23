public class TaskList {
    String[] contents = new String[100];
    int head = -1;

    public String addTask(String task) {
        head += 1;
        contents[head] = task;
        return "added: " + task;
    }

    public String displayList() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i <= head; i++) {
            String curr = i+1 + ". " + contents[i] + "\n";
            out.append(curr);
        }
        return out.toString();
    }
}
