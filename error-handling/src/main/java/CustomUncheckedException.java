class CustomUncheckedException extends RuntimeException {
    CustomUncheckedException() {
        super("Custom unchecked exception occurred.");
    }

    CustomUncheckedException(String message) {
        super(message);
    }
}