package pixel.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.time.LocalDateTime;

import pixel.task.TaskList;
import pixel.task.ToDo;
import pixel.task.Deadline;
import pixel.task.Event;

public class Storage {
    private final String filePath;

    public Storage() {
        this.filePath = "./data/Pixel.txt";
        try {
            File directory = new File("./data");
            directory.mkdir();
            File file = new File("./data/Pixel.txt");
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public void load(TaskList taskList) throws PixelException {
        String keyword, desc, isDone, dueBy, from, to;
        try {
            File file = new File(this.filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                keyword = sc.nextLine();
                switch (keyword) {
                case "todo":
                    desc = sc.nextLine();
                    isDone = sc.nextLine();
                    taskList.addTask(new ToDo(desc, Boolean.parseBoolean(isDone)));
                    continue;
                case "deadline":
                    desc = sc.nextLine();
                    isDone = sc.nextLine();
                    dueBy = sc.nextLine();
                    taskList.addTask(new Deadline(desc, Boolean.parseBoolean(isDone), LocalDateTime.parse(dueBy)));
                    continue;
                case "event":
                    desc = sc.nextLine();
                    isDone = sc.nextLine();
                    from = sc.nextLine();
                    to = sc.nextLine();
                    taskList.addTask(new Event(desc, Boolean.parseBoolean(isDone), LocalDateTime.parse(from), LocalDateTime.parse(to)));
                    continue;
                case "EOF":
                    return;
                default:
                    throw new PixelException("Invalid file contents");
                }
            }
        } catch (FileNotFoundException e) {
            throw new PixelException("Invalid file path!");
        }
    }

    public void save(TaskList taskList) {
        try {
            FileWriter writer = new FileWriter(this.filePath);
            writer.write(taskList.toFileFormat());
            writer.close();
        } catch (IOException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
