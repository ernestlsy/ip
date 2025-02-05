public class Pixel {
    TaskList taskList;
    Ui ui;
    Storage storage;
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
        boolean isExit = false;
        this.ui.greet();
        while (!isExit) {
            try {
                String fullCommand = ui.read();
                Command c = Parser.parseFullCommand(fullCommand);
                c.execute(ui, taskList, storage);
                isExit = c.isExit();
            } catch (PixelException e) {
                this.ui.exceptionResponse(e);
            }
        }
    }
    public static void main(String[] args) {
        new Pixel().run();
    }
}
