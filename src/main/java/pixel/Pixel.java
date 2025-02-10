package pixel;

import pixel.command.Command;
import pixel.task.TaskList;
import pixel.util.Parser;
import pixel.util.PixelException;
import pixel.util.Storage;
import pixel.util.Ui;

public class Pixel {
    private final TaskList taskList;
    private final Ui ui;
    private final Storage storage;

    public Pixel() {
        this.storage = new Storage();
        this.taskList = new TaskList();
        this.ui = new Ui();
    }

    public String init() {
        try {
            this.storage.load(this.taskList);
        } catch (PixelException e) {
            this.ui.exceptionResponse(e);
        }
        return ui.greet();
    }

    public String getResponse(String input) {
        try {
            Command c = Parser.parseFullCommand(input);
            return c.execute(ui, taskList, storage);
        } catch (PixelException e) {
            return e.getMessage();
        }
    }

}
