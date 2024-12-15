class CustomCheckedException extends Exception {
    CustomCheckedException() {
        super("Custom checked exception occurred.");
    }

    CustomCheckedException(String message) {
        super(message);
    }
}