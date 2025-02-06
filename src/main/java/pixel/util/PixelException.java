package pixel.util;

public class PixelException extends RuntimeException {
    private static final PixelException UNKNOWN_INPUT_EXCEPTION = new PixelException("Sorry, I'm not sure what that means...");

    public PixelException(String message) {
        super(message);
    }

    public static PixelException unknownInput() {
        return PixelException.UNKNOWN_INPUT_EXCEPTION;
    }
}
