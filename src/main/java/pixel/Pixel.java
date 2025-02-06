package pixel;

import pixel.util.Storage;
import pixel.util.Ui;
import pixel.util.Parser;
import pixel.util.PixelException;
import pixel.task.TaskList;
import pixel.command.Command;

public class Pixel {
    private final TaskList taskList;
    private final Ui ui;
    private final Storage storage;

    public Pixel() {
        this.storage = new Storage();
        this.taskList = new TaskList();
        this.ui = new Ui();
    }

    private void run() {
        try {
            this.storage.load(this.taskList);
        } catch (PixelException e) {
            this.ui.exceptionResponse(e);
        }
        boolean isTerminated = false;
        this.ui.greet();
        while (!isTerminated) {
            try {
                String fullCommand = ui.read();
                Command c = Parser.parseFullCommand(fullCommand);
                c.execute(ui, taskList, storage);
                isTerminated = c.isExitCommand();
            } catch (PixelException e) {
                this.ui.exceptionResponse(e);
            }
        }
    }

    public static void main(String[] args) {
        new Pixel().run();
    }
}
