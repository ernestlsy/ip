public class PixelException extends RuntimeException {
    public PixelException(String message) {
        super(message);
    }

    public static PixelException unknownInput() {
        return new PixelException("Sorry, I'm not sure what that means...");
    }
}
